package com.ssm.block.spring.imports.bean;

public class TestC {

	private String name;

	public TestC(String name) {
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
		return "TestC [name=" + name + "]";
	}
	
}
