package com.ssm.block.spring.extension;

import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.ssm.block.spring.beans.MyUser;

/**
 * 测试
 */
public class MainTest {
	public static void main(String[] args) {
		ConfigurableApplicationContext  context = new ClassPathXmlApplicationContext("spring-annotation-common.xml");

		System.out.println(context.getBean("t2Services"));
		
		System.out.println(context.getBean(MyUser.class));
		
		context.close();

	}
}
