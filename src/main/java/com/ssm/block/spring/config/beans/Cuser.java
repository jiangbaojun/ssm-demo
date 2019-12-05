package com.ssm.block.spring.config.beans;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class Cuser {
	private String id;
	private Integer age;
	private String name;
	
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
	@Value("我是小明")
	public void setName(String name) {
		this.name = name;
	}
	@Override
	public String toString() {
		return "Cuser [id=" + id + ", age=" + age + ", name=" + name + "]";
	}
	
}
