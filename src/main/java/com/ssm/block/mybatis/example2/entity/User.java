package com.ssm.block.mybatis.example2.entity;

import java.util.Arrays;
import java.util.Date;
import java.util.List;

//@Alias("user")
public class User {

	private Integer id;
	private String name;
	private String content;
	private Date createTime;
	private String[] phones;
	private Integer orgId;
	
	private List<Role> roles;
	private Organization org;
	
	private String desc;
	public User() {
		super();
	}
	public User(String desc) {
		super();
		this.desc = desc;
	}
	public User(Integer id, String name, String content, Date createTime, String[] phones, Integer orgId) {
		super();
		this.id = id;
		this.name = name;
		this.content = content;
		this.createTime = createTime;
		this.phones = phones;
		this.orgId = orgId;
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
	public List<Role> getRoles() {
		return roles;
	}
	public void setRoles(List<Role> roles) {
		this.roles = roles;
	}
	public Organization getOrg() {
		return org;
	}
	public void setOrg(Organization org) {
		this.org = org;
	}
	
	public Integer getOrgId() {
		return orgId;
	}
	public void setOrgId(Integer orgId) {
		this.orgId = orgId;
	}
	@Override
	public String toString() {
		return "User [id=" + id + ", name=" + name + ", content=" + content + ", createTime=" + createTime + ", phones="
				+ Arrays.toString(phones) + ", orgId=" + orgId + ", roles=" + roles + ", org=" + org + ", desc=" + desc
				+ "]";
	}
}
