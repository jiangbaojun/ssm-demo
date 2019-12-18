package com.ssm.block.mybatis.example2.entity;

import java.util.Date;

public class Organization {

	private String id;
	private String name;
	private Date date;
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	@Override
	public String toString() {
		return "Organization [id=" + id + ", name=" + name + ", date=" + date + "]";
	}
	
}
