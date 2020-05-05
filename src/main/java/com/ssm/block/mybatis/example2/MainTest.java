package com.ssm.block.mybatis.example2;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.alibaba.druid.pool.DruidDataSource;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.ExecutorType;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import com.ssm.block.mybatis.example2.dao.UserDao;
import com.ssm.block.mybatis.example2.entity.User;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.springframework.beans.factory.annotation.Autowired;

import javax.sql.DataSource;

public class MainTest {

	public static void main(String[] args) throws ParseException {


		InputStream inputStream;
		try {
			String resource = "com/ssm/block/mybatis/example2/config.xml";
			inputStream = Resources.getResourceAsStream(resource);
//			SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
			SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream, "production");
			SqlSession session = sqlSessionFactory.openSession(true);

			System.out.println("----------------------------------命名空间查找（sqlid）-----------------------------------------------------------");
//			Object obj = session.selectOne("com.ssm.block.mybatis.example2.dao.UserDao.selectUser","1");
//			System.out.println(obj);
//			List<User> list = session.selectList("com.ssm.block.mybatis.example2.dao.UserDao.selectAllUser");
//			System.out.println(list);
			
			System.out.println("------------------------------------接口方式---------------------------------------------------------");
			UserDao userDao = session.getMapper(UserDao.class);
//			System.out.println(userDao.selectUserByPhone("5"));
//			System.out.println(userDao.selectUserByPhones(new String[]{"5"}));
//			System.out.println(userDao.selectYoungUser(new SimpleDateFormat("yyyy-MM-dd").parse("2019-12-11")));
//			System.out.println(userDao.selectUser("1"));
//			System.out.println(userDao.selectAllUser());
			List<User> list = userDao.getUserAllInfo();
//			List<User> list = userDao.getUserAllInfo2();
			System.out.println(list);
			
			//多条插入1
//			List<User> list = new ArrayList<User>();
//			for(int i=1;i<=1000;i++) {
//				User user = new User(i,"小强"+i,i+"",new Date(),new String[]{""+i},(i%2)+1);
//				list.add(user);
//			}
//			long start = new Date().getTime();
//			System.out.println(userDao.addUsers(list));
//			long end = new Date().getTime();
//			System.out.println(end-start);
			
			//多条插入2，不推荐，效率太低
//			long start = new Date().getTime();
//			for(int i=1;i<=1000;i++) {
//				User user = new User(i,"小强"+i,i+"",new Date(),new String[]{""+i},(i%2)+1);
//				userDao.addUser(user);
//			}
//			long end = new Date().getTime();
//			System.out.println(end-start);
			
			//多条插入3,如果数据库不支持批量插入sql，使用ExecutorType.BATCH类型的session，手动提交事务
//			SqlSession sessionManual = sqlSessionFactory.openSession(ExecutorType.BATCH);
//			UserDao userDaoManual = sessionManual.getMapper(UserDao.class);
//			long start = new Date().getTime();
//			for(int i=1;i<=1000;i++) {
//				User user = new User(i,"小强"+i,i+"",new Date(),new String[]{""+i},(i%2)+1);
//				userDaoManual.addUser(user);
//			}
//			long end = new Date().getTime();
//			sessionManual.commit();
//			System.out.println(end-start);
			
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

}
