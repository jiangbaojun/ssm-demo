package com.ssm.block.mybatis.example3;


import com.ssm.block.mybatis.example3.entity.User;
import com.ssm.block.mybatis.example3.handler.MyResultHandler;
import org.apache.ibatis.cursor.Cursor;
import org.apache.ibatis.session.RowBounds;

import java.util.List;
import java.util.Map;

public interface UserDao {

	User selectUser(String id);

	/**
	 * 此次查询的数据量很大
	 * 直接查询，很慢很慢。可能导致内存溢出
	 */
	List<User> selectAllUser(Map<String,Object> params);

	/**
	 * 分批fetch获取，不用一次把数据都加载进内存
	 * 要注意：
	 * 1、方法返回值必须是void
	 * 2、需要在xml-sql中指定fetchSize。fetchSize的值对查询速度影响很大，合理设置
	 */
	void selectAllUserFetch(Map<String,Object> params, MyResultHandler myResultHandler);

	/**
	 * 游标查询
	 * 返回游标对象
	 * 需要在xml-sql中指定fetchSize。fetchSize的值对查询速度影响很大，合理设置
	 */
	Cursor<User> selectAllUserCursor(Map<String,Object> params);

	/**
	 * 通过RowBounds限制查询条数
	 */
	List<User> selectUserBounds(Map<String,Object> params, RowBounds rowBounds);

}
