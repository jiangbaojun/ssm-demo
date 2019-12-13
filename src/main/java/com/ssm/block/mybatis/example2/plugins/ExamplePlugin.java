package com.ssm.block.mybatis.example2.plugins;

import java.util.Properties;

import org.apache.ibatis.javassist.bytecode.analysis.Executor;
import org.apache.ibatis.mapping.MappedStatement;
import org.apache.ibatis.plugin.Interceptor;
import org.apache.ibatis.plugin.Intercepts;
import org.apache.ibatis.plugin.Invocation;
import org.apache.ibatis.plugin.Signature;

@Intercepts({ 
	@Signature(type = Executor.class, method = "update", args = { MappedStatement.class, Object.class }) 
})
public class ExamplePlugin implements Interceptor {
	private Properties properties = new Properties();

	public Object intercept(Invocation invocation) throws Throwable {
		// implement pre processing if need
		Object returnObject = invocation.proceed();
		// implement post processing if need
		return returnObject;
	}

	public void setProperties(Properties properties) {
		this.properties = properties;
	}

	@Override
	public Object plugin(Object target) {
		// TODO Auto-generated method stub
		return null;
	}
}