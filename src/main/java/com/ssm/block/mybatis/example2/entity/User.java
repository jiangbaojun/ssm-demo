package com.ssm.block.mybatis.example2.entity;

import java.util.Arrays;
import java.util.Date;

import org.apache.ibatis.type.Alias;

//@Alias("user")
public class User {

	private Integer id;
	private String name;
	private String content;
	private Date createTime;
	private String[] phones;
	
	private String desc;
	public User() {
		super();
	}
	public User(String desc) {
		super();
		this.desc = desc;
	}
	public String[] getPhones() {
		return phones;
	}
	public void setPhones(String[] phones) {
		this.phones = phones;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public Date getCreateTime() {
		return createTime;
	}
	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}
	
	public String getDesc() {
		return desc;
	}
	public void setDesc(String desc) {
		this.desc = desc;
	}
	@Override
	public String toString() {
		return "User [id=" + id + ", name=" + name + ", content=" + content + ", createTime=" + createTime + ", phones="
				+ Arrays.toString(phones) + ", desc=" + desc + "]";
	}
	
}
