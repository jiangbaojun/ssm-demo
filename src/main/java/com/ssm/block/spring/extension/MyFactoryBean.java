package com.ssm.block.spring.extension;

import org.springframework.beans.factory.FactoryBean;
import org.springframework.stereotype.Component;

import com.ssm.block.spring.beans.MyUser;

/**
 * FactoryBean
 * 创建两个实例，MyFactoryBean本身和getObject方法返回的实例对象
 */
@Component
public class MyFactoryBean implements FactoryBean<MyUser> {

    public MyUser getObject() throws Exception {
        return new MyUser("1999",12,"xiaoming");
    }

    public Class<MyUser> getObjectType() {
        return MyUser.class;
    }

    public boolean isSingleton() {
        return true;
    }
}