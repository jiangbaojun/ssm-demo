package com.ssm.block.mybatis.example3;

import com.ssm.block.mybatis.example3.entity.User;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.RowBounds;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 限定查询条数
 * 1、可以全局注册插件，修改RowBounds实现
 * 2、单独的查询方法，传递RowBounds参数实现
 */
public class MainTest1 {

	public static void main(String[] args) {
		InputStream inputStream;
		try {
			String resource = "com/ssm/block/mybatis/example3/config.xml";
			inputStream = Resources.getResourceAsStream(resource);
			SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
			SqlSession session = sqlSessionFactory.openSession();

			UserDao userDao = session.getMapper(UserDao.class);
			Map<String,Object> params = new HashMap<>();
			params.put("minId", "10");
			List<User> users = userDao.selectUserBounds(params, new RowBounds(0, 200));
			System.out.println("查询条数："+users.size());

		} catch (IOException e) {
			e.printStackTrace();
		}

	}

}
