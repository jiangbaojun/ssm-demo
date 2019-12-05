package com.ssm.block.spring.propertysource;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class TestBean {
	@Value("${age}")
	private Integer age;
	@Value("${name}")
	private String name;
	@Value("${jdbc.url}")
	private String url;
	
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
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
	@Override
	public String toString() {
		return "TestBean [age=" + age + ", name=" + name + ", url=" + url + "]";
	}
}
