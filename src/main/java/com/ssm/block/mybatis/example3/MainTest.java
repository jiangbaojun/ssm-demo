package com.ssm.block.mybatis.example3;

import com.ssm.block.mybatis.example3.handler.MyResultHandler;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Map;

/**
 * 大数据量查询
 * 采用普通查询、游标查询、流式查询
 */
public class MainTest {

	public static void main(String[] args) {
		InputStream inputStream;
		try {
			String resource = "com/ssm/block/mybatis/example3/config.xml";
			inputStream = Resources.getResourceAsStream(resource);
			SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
			SqlSession session = sqlSessionFactory.openSession();

			UserDao userDao = session.getMapper(UserDao.class);

			long start = System.currentTimeMillis();
			Map<String,Object> params = new HashMap<>();
			params.put("minId", "10");
			//直接查数据
//			userDao.selectAllUser(params);

			//使用fetchSize做流式查询，分批抓取数据
			MyResultHandler myResultHandler = new MyResultHandler();
			userDao.selectAllUserFetch(params, myResultHandler);

			//游标查询，
//			Cursor<User> users = userDao.selectAllUserCursor(params);
//			users.forEach((user -> {
////				System.out.println(user);
//			}));


			System.out.println(System.currentTimeMillis()-start);

		} catch (IOException e) {
			e.printStackTrace();
		}

	}

}
