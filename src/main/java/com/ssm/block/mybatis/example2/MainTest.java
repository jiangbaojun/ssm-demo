package com.ssm.block.mybatis.example2;

import java.io.IOException;
import java.io.InputStream;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import com.ssm.block.mybatis.example1.entity.User;
import com.ssm.block.mybatis.example2.dao.UserDao;

public class MainTest {

	public static void main(String[] args) throws ParseException {
		InputStream inputStream;
		try {
			String resource = "com/ssm/block/mybatis/example2/config.xml";
			inputStream = Resources.getResourceAsStream(resource);
			SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
			SqlSession session = sqlSessionFactory.openSession();
			
			System.out.println("----------------------------------命名空间查找（sqlid）-----------------------------------------------------------");
//			Object obj = session.selectOne("com.ssm.block.mybatis.example2.dao.UserDao.selectUser","1");
//			System.out.println(obj);
//			List<User> list = session.selectList("com.ssm.block.mybatis.example2.dao.UserDao.selectAllUser");
//			System.out.println(list);
			
			System.out.println("------------------------------------接口方式---------------------------------------------------------");
			UserDao userDao = session.getMapper(UserDao.class);
			System.out.println(userDao.selectUserByPhone("5"));
			System.out.println(userDao.selectUserByPhones(new String[]{"5"}));
//			System.out.println(userDao.selectYoungUser(new SimpleDateFormat("yyyy-MM-dd").parse("2019-12-11")));
//			System.out.println(userDao.selectUser("1"));
//			System.out.println(userDao.selectAllUser());
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

}
