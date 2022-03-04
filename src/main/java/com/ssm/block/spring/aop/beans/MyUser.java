package com.ssm.block.spring.aop.beans;

import org.springframework.stereotype.Component;

@Component
public class MyUser extends MyUserParent {

	private String id;
	private Integer age;
	private String name;

	public String eat() throws Exception {
		try {
			System.out.println("user eat");
//			int a = 10/0;
		} catch (Exception e) {
			System.out.println("出现异常:"+e.getMessage());
			throw new Exception("我要出现异常");
		} finally {
			System.out.println("执行finally");
		}
		return "eated";
	}

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
