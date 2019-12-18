package com.ssm.block.mybatis.example2.dao;

import java.util.Date;
import java.util.List;

import com.ssm.block.mybatis.example2.entity.User;

public interface UserDao {

	public int addUser(User user);
	public int addUsers(List<User> users);
	public User selectUser(String id);
	public List<User> selectYoungUser(Date date);
	public List<User> getUserAllInfo();
	public List<User> selectUserByPhone(String phone);
	public List<User> selectUserByPhones(String[] phones);
	public List<User> selectAllUser();
	public List<User> getUserAllInfo2();
}
