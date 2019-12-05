package com.ssm.block.spring.life;

import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.ssm.block.spring.beans.T1Services;

public class XmlMainTest {
	public static void main(String[] args) {
//		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("spring-xml-common.xml");
		ConfigurableApplicationContext  context = new ClassPathXmlApplicationContext("spring-xml-common.xml");

		T1Services service = context.getBean("t1Services", T1Services.class);
		service.test();
		
//		context.start();
		context.close();

	}
}
