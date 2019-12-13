package com.ssm.block.spring.imports.bean;

public class Test {

	private String name;

	public Test(String name) {
		super();
		this.name = name;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		return "Test [name=" + name + "]";
	}
	
}
