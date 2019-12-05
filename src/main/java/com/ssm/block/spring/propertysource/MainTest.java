package com.ssm.block.spring.propertysource;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * 测试propertySource
 */
public class MainTest {
	public static void main(String[] args) {
		AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext();
		ctx.register(AppConfig.class);
		ctx.refresh();
		
		Object testBean = ctx.getBean("testBean");
		System.out.println(testBean);
		
		Object obj = ctx.getBean("dataSource");
		System.out.println(obj);
	}
}

