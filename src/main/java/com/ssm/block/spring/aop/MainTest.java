package com.ssm.block.spring.aop;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.ssm.block.spring.aop.beans.MyUser;
import com.ssm.block.spring.aop.beans.bean1.MyUser2;

/**
 * 测试
 */
public class MainTest {
	public static void main(String[] args) {
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
		context.register(AppConfig.class);
		context.refresh();
		
		MyUser u1 = context.getBean(MyUser.class);
		MyUser2 u2 = context.getBean(MyUser2.class);
		
		try {
			u1.eat();
		} catch (Exception e) {
			e.printStackTrace();
		}
//		u2.eat();
		
	}
}

