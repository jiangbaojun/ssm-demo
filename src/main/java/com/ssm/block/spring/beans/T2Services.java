package com.ssm.block.spring.beans;

import javax.annotation.Resource;

import org.springframework.stereotype.Component;

@Component
public class T2Services {
	
	@Resource
	MyUser myUser;
	
	private int age;
	private String name;
	
	public T2Services() {
		super();
	}
	public T2Services(int age, String name) {
		super();
		this.age = age;
		this.name = name;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	public void test() {
		System.out.println("t2Services.test方法");
	}
	@Override
	public String toString() {
		return "T2Services [age=" + age + ", name=" + name + "]";
	}
	
	
}
