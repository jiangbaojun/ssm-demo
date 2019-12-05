package com.ssm.block.spring.beans;

public class Person {

	private String id;
	private Integer age;
	private String name;
	
	public Person() {
		super();
	}
	public Person(String id, Integer age, String name) {
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
		return "Persion [id=" + id + ", age=" + age + ", name=" + name + "]";
	}
	
	
}
