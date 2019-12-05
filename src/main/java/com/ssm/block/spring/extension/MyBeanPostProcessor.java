package com.ssm.block.spring.extension;

import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.stereotype.Component;

/**
 * bean后置处理
 */
@Component
public class MyBeanPostProcessor implements BeanPostProcessor {
	
    //在bean实例化之后,初始化之前调用 （例如init-method之前）
    public Object postProcessBeforeInitialization(Object bean, String beanName) {
        return bean; // we could potentially return any object reference here...
    }

    //在bean实例化并且初始化之后调用，例如：postConstruct和afterPropertiesSet之后
    public Object postProcessAfterInitialization(Object bean, String beanName) {
        System.out.println("Bean '" + beanName + "' created : " + bean.toString());
        return bean;
    }
}