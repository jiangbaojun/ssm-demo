package com.ssm.block.spring.aop.beans;

import org.springframework.stereotype.Component;

@Component
public class MyUserSon extends MyUser{


	public String eat() throws Exception {
		System.out.println("son eat");
		return "eat";
	}

}
