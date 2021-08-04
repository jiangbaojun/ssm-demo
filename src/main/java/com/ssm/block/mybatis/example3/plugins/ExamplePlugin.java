package com.ssm.block.mybatis.example3.plugins;

import org.apache.ibatis.cache.CacheKey;
import org.apache.ibatis.executor.Executor;
import org.apache.ibatis.executor.parameter.ParameterHandler;
import org.apache.ibatis.executor.resultset.ResultSetHandler;
import org.apache.ibatis.executor.statement.StatementHandler;
import org.apache.ibatis.mapping.BoundSql;
import org.apache.ibatis.mapping.MappedStatement;
import org.apache.ibatis.plugin.*;
import org.apache.ibatis.session.ResultHandler;
import org.apache.ibatis.session.RowBounds;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.Statement;
import java.util.Properties;


/**
 * 通过修改全局RowBounds，限定查询结果条数
 */
@Intercepts({
	@Signature(type = ParameterHandler.class, method = "setParameters", args = {PreparedStatement.class}),
	@Signature(type = StatementHandler.class, method = "prepare", args = {Connection.class, Integer.class}),
	@Signature(type = ResultSetHandler.class, method = "handleResultSets", args = {Statement.class}),
	@Signature(type = Executor.class, method = "query", args = {MappedStatement.class, Object.class, RowBounds.class, ResultHandler.class}),
    @Signature(type = Executor.class, method = "query", args = {MappedStatement.class, Object.class, RowBounds.class, ResultHandler.class, CacheKey.class, BoundSql.class})
})
public class ExamplePlugin implements Interceptor {

	private Properties properties = new Properties();

	@Override
	public Object intercept(Invocation invocation) throws Throwable {
		Object[] args = invocation.getArgs();
		if (args!=null && args.length>2 && args[2] instanceof RowBounds){
			Object maxCount = properties.get("maxCount");
			args[2] = new RowBounds(0, Integer.parseInt(maxCount.toString()));
		}
		return invocation.proceed();
	}

	@Override
	public void setProperties(Properties properties) {
		this.properties = properties;
	}

	@Override
	public Object plugin(Object target) {
//		return target;
		return Plugin.wrap(target, this);
	}
}
