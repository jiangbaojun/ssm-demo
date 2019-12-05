package com.ssm.block.spring.aop.beans.bean1;

import org.springframework.stereotype.Component;

@Component
public class MyUser2 {

	private String id;
	private Integer age;
	private String name;
	
	public void eat() {
		System.out.println("user2 eat");
	}
	
	private void work() {
		System.out.println("user2 work");
	}
	
	public MyUser2() {
		super();
	}
	public MyUser2(String id, Integer age, String name) {
		super();
		this.id = id;
		this.age = age;
		this.name = name;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public Integer getAge() {
		return age;
	}
	public void setAge(Integer age) {
		this.age = age;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	@Override
	public String toString() {
		return "MyUser [id=" + id + ", age=" + age + ", name=" + name + "]";
	}
	
	
}
