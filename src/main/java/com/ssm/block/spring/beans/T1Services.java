package com.ssm.block.spring.beans;

import org.springframework.stereotype.Component;

@Component
public class T1Services {
	private int age;
	private String name;
	
	public T1Services() {
		super();
		System.out.println("T1Services无参构造");
	}
	public T1Services(int age, String name) {
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
		System.out.println("t1Services.test方法");
	}
	@Override
	public String toString() {
		return "T1Services [age=" + age + ", name=" + name + "]";
	}
	
	
}
