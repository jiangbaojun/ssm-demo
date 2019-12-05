package com.ssm.block.spring.aware;

import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.ssm.block.spring.beans.MyUser;

/**
 * 测试后置处理器
 */
public class MainTest {
	public static void main(String[] args) {
		ConfigurableApplicationContext  context = new ClassPathXmlApplicationContext("spring-annotation-common.xml");

		System.out.println(context.getBean("t2Services"));
		
		System.out.println(context.getBean(MyUser.class));
		
		context.close();

	}
}
