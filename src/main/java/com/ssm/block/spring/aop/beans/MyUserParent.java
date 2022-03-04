package com.ssm.block.spring.aop.beans;

import org.springframework.stereotype.Component;

@Component
public class MyUserParent{


	public String eat() throws Exception {
		System.out.println("parent eat");
		return "eat";
	}

}
