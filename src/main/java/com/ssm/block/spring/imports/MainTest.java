package com.ssm.block.spring.imports;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.ssm.block.spring.imports.bean.TestDefinition;
import com.ssm.block.spring.imports.bean.TestSelect;

/**
 * 测试profile
 */
public class MainTest {
	public static void main(String[] args) {
		AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext();
		ctx.register(AppConfig.class);
		ctx.refresh();
		
		System.out.println(ctx.getBean("test"));
		System.out.println(ctx.getBean("testA"));
		System.out.println(ctx.getBean("testB"));
		System.out.println(ctx.getBean("testXml"));
		System.out.println(ctx.getBean(TestSelect.class));
		System.out.println(ctx.getBean(TestDefinition.class));
	}
}

