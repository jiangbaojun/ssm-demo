package com.ssm.block.mybatis.example1;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import com.ssm.block.mybatis.example1.entity.User;

public class MainTest {

	public static void main(String[] args) {
		InputStream inputStream;
		try {
			String resource = "com/ssm/block/mybatis/example1/config.xml";
			inputStream = Resources.getResourceAsStream(resource);
			SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
			SqlSession session = sqlSessionFactory.openSession();
			
			Object obj = session.selectOne("com.ssm.block.mybatis.example1.mapper.selectUser","1");
			System.out.println(obj);
			List<User> list = session.selectList("com.ssm.block.mybatis.example1.mapper.selectAllUser");
			System.out.println(list);
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

}
