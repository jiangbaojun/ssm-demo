package com.ssm.block.spring.config;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * 通过注解构建spring容器测试
 */
public class MainTest {
	public static void main(String[] args) {
	    AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
	    context.register(AppConfig.class);
	    context.refresh();

	    System.out.println(context.getBean("cuser"));
	    System.out.println(context.getBean("jdbcBean"));
	    System.out.println(context.getBean("annotationUser"));
	}
}

