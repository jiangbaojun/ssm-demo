package com.ssm.block.spring.imports.bean;

public class TestA {

	private String name;

	public TestA(String name) {
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
		return "TestA [name=" + name + "]";
	}
	
}
