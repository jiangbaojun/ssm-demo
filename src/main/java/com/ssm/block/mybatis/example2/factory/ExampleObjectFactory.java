package com.ssm.block.mybatis.example2.factory;

import java.util.Collection;
import java.util.List;
import java.util.Properties;

import org.apache.ibatis.reflection.factory.DefaultObjectFactory;

import com.ssm.block.mybatis.example2.entity.User;

/**
 * 覆盖mybatis对象创建，例如实体类
 */
public class ExampleObjectFactory extends DefaultObjectFactory {
	
	@Override
	public Object create(Class type) {
		if(User.class.isAssignableFrom(type)){
			//实体类进行自定义实例化
			return new User("objectFactory");
		}
		return super.create(type);
	}
	
	@Override
	public <T> T create(Class<T> type, List<Class<?>> constructorArgTypes, List<Object> constructorArgs) {
		return super.create(type, constructorArgTypes, constructorArgs);
	}

	@Override
	public void setProperties(Properties properties) {
		super.setProperties(properties);
	}

	@Override
	public <T> boolean isCollection(Class<T> type) {
		return Collection.class.isAssignableFrom(type);
	}
}