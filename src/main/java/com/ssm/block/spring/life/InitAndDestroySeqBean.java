package com.ssm.block.spring.life;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Component;

/**
 * bean生命周期测试
 */
@Component
public class InitAndDestroySeqBean implements InitializingBean,DisposableBean {
 
    public InitAndDestroySeqBean(){
        System.out.println("1执行InitAndDestroySeqBean: 构造方法");
    }
    
    @PostConstruct
    public void postConstruct() {  
       System.out.println("2执行InitAndDestroySeqBean: postConstruct");  
    }  
    
    @Override
    public void afterPropertiesSet() throws Exception {
        System.out.println("3执行InitAndDestroySeqBean: afterPropertiesSet"); 
    }
    
    public void initMethod() {
        System.out.println("4执行InitAndDestroySeqBean: init-method");
    }
 
    @PreDestroy
    public void preDestroy()  {
        System.out.println("5执行InitAndDestroySeqBean: preDestroy");
    }
    
    @Override
    public void destroy() throws Exception {
        System.out.println("6执行InitAndDestroySeqBean: destroy");
    }
    
    public void destroyMethod() {
        System.out.println("执行InitAndDestroySeqBean: destroy-method");
    }
    
    public static void main(String[] args) {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("com/chj/spring/bean.xml");
        context.close();
    }
}