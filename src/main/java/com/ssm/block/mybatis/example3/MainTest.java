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
//			SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream, "oracle_db");
			SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
			SqlSession session = sqlSessionFactory.openSession();

			UserDao userDao = session.getMapper(UserDao.class);

			long start = System.currentTimeMillis();
			Map<String,Object> params = new HashMap<>();
			params.put("minId", "10");
			//直接查数据
//			List<User> users = userDao.selectAllUser(params);
//			System.out.println("users size:"+users.size());

			//流式查询1，使用ResultHandler接收处理数据
			MyResultHandler myResultHandler = new MyResultHandler();
			userDao.selectAllUserStream(params, myResultHandler);

			//流式查询2，使用Cursor接收处理数据
//			Cursor<User> streamUsers = userDao.selectAllUserStream2(params);
//			streamUsers.forEach((user -> {
//				//System.out.println(user.getId());
//			}));
//			streamUsers.close();

			//游标查询1，使用ResultHandler接收处理数据.jdbc连接上要添加useCursorFetch=true
//			MyResultHandler myResultHandler = new MyResultHandler();
//			userDao.selectAllUserCursor(params, myResultHandler);

			//游标查询2，使用Cursor接收处理数据
//			Cursor<User> users = userDao.selectAllUserCursor2(params);
//			users.forEach((user -> {
//				//System.out.println(user.getId());
//			}));
//			users.close();

			System.out.println(System.currentTimeMillis()-start);

		} catch (IOException e) {
			e.printStackTrace();
		}

	}

}
