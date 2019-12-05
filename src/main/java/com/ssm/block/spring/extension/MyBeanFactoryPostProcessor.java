package com.ssm.block.spring.extension;

import org.springframework.beans.BeansException;
import org.springframework.beans.MutablePropertyValues;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.config.BeanFactoryPostProcessor;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.stereotype.Component;

/**
 * BeanFactory后置处理
 */
@Component
public class MyBeanFactoryPostProcessor implements BeanFactoryPostProcessor {

	/**
	 * 可以在此处修改beanDefinition
	 */
    @Override
    public void postProcessBeanFactory(ConfigurableListableBeanFactory beanFactory) throws BeansException {
        BeanDefinition beanDefinition = beanFactory.getBeanDefinition("t2Services");
        //此处仅仅是beandefinition，不要实例化bean，虽然通过getbean能够实例化，但是不推荐
//        Object obj = beanFactory.getBean(T2Services.class);
        MutablePropertyValues propertyValues = beanDefinition.getPropertyValues();
        //添加属性值
        propertyValues.addPropertyValue("name", "jiangbaojun");
    }
}