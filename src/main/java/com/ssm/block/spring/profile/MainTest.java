package com.ssm.block.spring.profile;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * 测试profile
 */
public class MainTest {
	public static void main(String[] args) {
		AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext();
		//手动设置profile
//		ctx.getEnvironment().setActiveProfiles("development");
		ctx.getEnvironment().setActiveProfiles("production");
		
		//设置JVM参数，自动获取profile。例如-Dspring.profiles.active="production"
//		Environment env = ctx.getEnvironment();
//		String[] profiles = env.getActiveProfiles();
		
		ctx.register(AppConfig.class);
		ctx.refresh();
		Object obj = ctx.getBean("dataSource");
		System.out.println(obj);
	}
}

