package com.ssm.block.spring.imports.bean;

public class TestB {

	private String name;

	public TestB(String name) {
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
		return "TestB [name=" + name + "]";
	}
	
}
