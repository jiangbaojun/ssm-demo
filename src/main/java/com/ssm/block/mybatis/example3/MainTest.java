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
 * 这3种查询方式，常规非大数据模式下普通查询最快，其次是流式查询，最次是游标查询。
 * 主要是由于游标查询需要和数据库进行多次网络交互，Client处理完这部分后再拉取下一部分数据，因此会比较慢。
 * 但是流式查询又会长时间占用同一个数据库连接，因此要取舍一下：是能接受连接一直持有但是可能拥塞导致响应慢，还是可能占用较多连接数但单次响应快。
 *
 *
 * 一、普通查询
 * 优点：应用代码简单，数据量较小时操作速度快。
 * 缺点：数据量大时会出现OOM问题。
 *
 * 二、流式查询
 * 优点：大数据量时不会有OOM问题。
 * 缺点：占用数据库时间更长，导致网络拥塞的可能性较大。
 *
 * 三、游标查询
 * 优点：大数据量时不会有OOM问题，相比流式查询对数据库单次占用时间较短。
 * 缺点：相比流式查询，对服务端资源消耗更大，响应时间更长。
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
