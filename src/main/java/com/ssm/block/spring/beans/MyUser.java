package com.ssm.block.spring.beans;

import org.springframework.stereotype.Component;

public class MyUser {

	private String id="123";
	private Integer age;
	private String name;
	
	public MyUser() {
		super();
	}
	public MyUser(String id, Integer age, String name) {
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
