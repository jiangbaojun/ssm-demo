package com.ssm.block.spring.imports.bean;

public class TestDefinition {

	private String name;
	
	public TestDefinition() {
		super();
	}

	public TestDefinition(String name) {
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
		return "TestDefinition [name=" + name + "]";
	}
	
}
