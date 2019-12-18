package com.ssm.block.mybatis.example2.plugins;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.Statement;
import java.util.Properties;

import org.apache.ibatis.cache.CacheKey;
import org.apache.ibatis.executor.Executor;
import org.apache.ibatis.executor.parameter.ParameterHandler;
import org.apache.ibatis.executor.resultset.ResultSetHandler;
import org.apache.ibatis.executor.statement.StatementHandler;
import org.apache.ibatis.mapping.BoundSql;
import org.apache.ibatis.mapping.MappedStatement;
import org.apache.ibatis.plugin.Interceptor;
import org.apache.ibatis.plugin.Intercepts;
import org.apache.ibatis.plugin.Invocation;
import org.apache.ibatis.plugin.Plugin;
import org.apache.ibatis.plugin.Signature;
import org.apache.ibatis.session.ResultHandler;
import org.apache.ibatis.session.RowBounds;


@Intercepts({
	@Signature(type = ParameterHandler.class, method = "setParameters", args = {PreparedStatement.class}),
	@Signature(type = StatementHandler.class, method = "prepare", args = {Connection.class, Integer.class}),
	@Signature(type = ResultSetHandler.class, method = "handleResultSets", args = {Statement.class}),
	@Signature(type = Executor.class, method = "query", args = {MappedStatement.class, Object.class, RowBounds.class, ResultHandler.class}),
    @Signature(type = Executor.class, method = "query", args = {MappedStatement.class, Object.class, RowBounds.class, ResultHandler.class, CacheKey.class, BoundSql.class})
})
//@Intercepts({@Signature(
//		  type= Executor.class,
//		  method = "update",
//		  args = {MappedStatement.class,Object.class})})
public class ExamplePlugin implements Interceptor {
	private Properties properties = new Properties();

	@Override
	public Object intercept(Invocation invocation) throws Throwable {
		//参数
		Object[] args = invocation.getArgs();
		//目标对象
        Object target = invocation.getTarget();
        if(target instanceof Executor) {
        	Executor executor = (Executor) target;
        	MappedStatement ms = (MappedStatement) args[0];
            Object parameter = args[1];
            RowBounds rowBounds = (RowBounds) args[2];
            ResultHandler resultHandler = (ResultHandler) args[3];
            CacheKey cacheKey;
            BoundSql boundSql;
            if (args.length == 4) {
                boundSql = ms.getBoundSql(parameter);
                cacheKey = executor.createCacheKey(ms, parameter, rowBounds, boundSql);
            } else {
                cacheKey = (CacheKey) args[4];
                boundSql = (BoundSql) args[5];
            }
            
        } else if(target instanceof StatementHandler) {
        	StatementHandler statementHandler = (StatementHandler) target;
        	BoundSql boundSql = statementHandler.getBoundSql();
        	System.out.println(args);
        	
        } else if(target instanceof ParameterHandler) {
        	ParameterHandler parameterHandler = (ParameterHandler) target;
        	Object parObj = parameterHandler.getParameterObject();
        	System.out.println(args);
        	
        } else if(target instanceof ResultSetHandler) {
        	ResultSetHandler resultSetHandler = (ResultSetHandler) target;
        	System.out.println(resultSetHandler);
        }
        
		// implement pre processing if need
		Object returnObject = invocation.proceed();
		// implement post processing if need
		return returnObject;
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