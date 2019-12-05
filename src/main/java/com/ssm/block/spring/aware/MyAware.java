package com.ssm.block.spring.aware;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.BeanFactoryAware;
import org.springframework.beans.factory.BeanNameAware;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.context.EnvironmentAware;
import org.springframework.context.MessageSource;
import org.springframework.context.MessageSourceAware;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Component;

import com.ssm.block.spring.beans.T1Services;

/**
 * 测试BeanNameAware, BeanFactoryAware, ApplicationContextAware
 */
@Component
public class MyAware implements BeanNameAware, BeanFactoryAware, ApplicationContextAware, EnvironmentAware, MessageSourceAware {

	/**
	 * 在所有常规的bean实例化之后，初始化之前调用
	 */
	@Override
	public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
		System.out.println("ApplicationContextAware set");
	}

	/**
	 * 在所有正常bean实例化后，还未初始化前调用
	 */
	@Override
	public void setBeanFactory(BeanFactory beanFactory) throws BeansException {
		//此时bean已初始化
		System.out.println("beanFactory set");
	}

	@Override
	public void setBeanName(String name) {
		System.out.println("bean set:"+name);
	}

	@Override
	public void setEnvironment(Environment environment) {
		System.out.println("environment set:"+environment);
	}

	@Override
	public void setMessageSource(MessageSource messageSource) {
		System.out.println("messageSource set:"+messageSource);
	}

}
