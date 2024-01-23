package com.ssm.block.spring.i18n;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.Locale;

/**
 * 测试国际化i18n
 * 
 * MessageSource有三个方法
 *  String getMessage(String code, Object[] args, String defaultMessage, Locale locale)
 * 	code表示国际化资源中的属性名；args用于传递格式化串占位符所用的运行期参数；当在资源找不到对应属性名时，返回defaultMessage参数所指定的默认信息；locale表示本地化对象；
 * 	
 * 	String getMessage(String code, Object[] args, Locale locale) throws NoSuchMessageException;
 * 	与上面的方法类似，只不过在找不到资源中对应的属性名时，直接抛出NoSuchMessageException异常；
 * 	
 * 	String getMessage(MessageSourceResolvable resolvable, Locale locale) throws NoSuchMessageException;
 * 	MessageSourceResolvable 将属性名、参数数组以及默认信息封装起来，它的功能和第一个接口方法相同。
 */
public class MainTest {
	public static void main(String[] args) {
		AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext();
		ctx.register(AppConfig.class);
		ctx.refresh();
		
		//在公共的test.properties中查找
		System.out.println(ctx.getMessage("name",null, Locale.US));
		
		System.out.println("**************************age*****************************************");
		System.out.println(ctx.getMessage("age",null, Locale.US));
		System.out.println(ctx.getMessage("age",null, Locale.SIMPLIFIED_CHINESE));
		System.out.println(ctx.getMessage("age",null, Locale.TRADITIONAL_CHINESE));
		
		System.out.println("**************************username*****************************************");
		System.out.println(ctx.getMessage("username",null, Locale.US));
		System.out.println(ctx.getMessage("username",null, Locale.SIMPLIFIED_CHINESE));
		System.out.println(ctx.getMessage("username",null, Locale.TRADITIONAL_CHINESE));
		
		System.out.println("**************************who*****************************************");
		System.out.println(ctx.getMessage("who",new String[]{"us","1"}, Locale.US));
		System.out.println(ctx.getMessage("who",new String[]{"prc","2"}, Locale.SIMPLIFIED_CHINESE));
		System.out.println(ctx.getMessage("who",new String[]{"tw","3"}, Locale.TRADITIONAL_CHINESE));
		
		System.out.println("**************************默认值测试*****************************************");
		System.out.println(ctx.getMessage("who",new String[]{"prc","2"}, "没有值，默认是我", Locale.SIMPLIFIED_CHINESE));
		System.out.println(ctx.getMessage("who1",new String[]{"prc","2"}, "没有值，默认是我", Locale.SIMPLIFIED_CHINESE));
	}
}

