package com.ssm.block.mybatis.example2.dao;

import java.util.Date;
import java.util.List;

import com.ssm.block.mybatis.example2.entity.User;

public interface UserDao {

	public User selectUser(String id);
	public List<User> selectYoungUser(Date date);
	public List<User> selectUserByPhone(String phone);
	public List<User> selectUserByPhones(String[] phones);
	public List<User> selectAllUser();
}
