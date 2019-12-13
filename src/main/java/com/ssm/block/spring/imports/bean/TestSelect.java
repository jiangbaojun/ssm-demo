package com.ssm.block.spring.imports.bean;

public class TestSelect {

	private String name;
	
	public TestSelect() {
		super();
	}

	public TestSelect(String name) {
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
		return "TestSelect [name=" + name + "]";
	}
	
}
