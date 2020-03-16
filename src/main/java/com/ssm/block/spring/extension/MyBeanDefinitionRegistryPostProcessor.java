package com.ssm.block.spring.extension;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.beans.factory.support.BeanDefinitionBuilder;
import org.springframework.beans.factory.support.BeanDefinitionRegistry;
import org.springframework.beans.factory.support.BeanDefinitionRegistryPostProcessor;
import org.springframework.stereotype.Component;

import com.ssm.block.spring.beans.Person;

/**
 * 手动动态注册beandefinition
 * 相当于没有beandefinition的情况下，添加一个beandefinition。类似于在xml添加一个<bean/>
 * 比BeanFactoryPostProcessor先执行
 */
@Component
public class MyBeanDefinitionRegistryPostProcessor implements BeanDefinitionRegistryPostProcessor {
    @Override
    public void postProcessBeanDefinitionRegistry(BeanDefinitionRegistry registry)
    throws BeansException {
        //构造bean定义
        BeanDefinitionBuilder beanDefinitionBuilder = BeanDefinitionBuilder
				.genericBeanDefinition(Person.class);
        //设置依赖
        beanDefinitionBuilder.addPropertyValue("name", "小强");
        BeanDefinition personBeanDefinition = beanDefinitionBuilder.getRawBeanDefinition();
        //注册bean定义
        registry.registerBeanDefinition("personRegistry", personBeanDefinition);

	}

    @Override
    public void postProcessBeanFactory(ConfigurableListableBeanFactory beanFactory) {
    	
    }
}