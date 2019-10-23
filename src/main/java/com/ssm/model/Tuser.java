package com.ssm.model;


import java.sql.Time;
import java.sql.Timestamp;
import java.util.Date;

/**
 * 用户实体
 */
public class Tuser {

    private Integer id;
    private String name;
    private String status;
    private Integer age;
    private Date birthday;
    private Timestamp update_time;
    private Time time;
    
    
	public Tuser() {
		super();
	}
	public Tuser(Integer id, String name, Integer age) {
		super();
		this.id = id;
		this.name = name;
		this.age = age;
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
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public Integer getAge() {
		return age;
	}
	public void setAge(Integer age) {
		this.age = age;
	}
	public Date getBirthday() {
		return birthday;
	}
	public void setBirthday(Date birthday) {
		this.birthday = birthday;
	}
	public Timestamp getUpdate_time() {
		return update_time;
	}
	public void setUpdate_time(Timestamp update_time) {
		this.update_time = update_time;
	}
	public Time getTime() {
		return time;
	}
	public void setTime(Time time) {
		this.time = time;
	}
	@Override
	public String toString() {
		return "Tuser [id=" + id + ", name=" + name + ", status=" + status + ", age=" + age + ", birthday=" + birthday
				+ ", update_time=" + update_time + ", time=" + time + "]";
	}
}
