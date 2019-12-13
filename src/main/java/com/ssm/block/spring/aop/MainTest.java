package com.ssm.block.spring.aop;

import java.util.Date;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.ssm.block.spring.aop.beans.AopUser;
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
		
		AopUser u = context.getBean(AopUser.class);
		u.eat();
		u.workString("123");
		u.workDate1(new Date());
		u.workDate2(new Date());
		u.workStringAndDate(new Date(), "123");
		u.workString2AndDate("123",new Date(), "123");
		
//		MyUser u1 = context.getBean(MyUser.class);
//		MyUser2 u2 = context.getBean(MyUser2.class);
//		
//		try {
//			u1.eat();
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
//		u2.eat();
		
	}
}

