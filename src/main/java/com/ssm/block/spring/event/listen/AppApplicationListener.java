package com.ssm.block.spring.event.listen;

import org.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.springframework.context.ApplicationEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextClosedEvent;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.context.event.ContextStartedEvent;
import org.springframework.context.event.ContextStoppedEvent;
import org.springframework.stereotype.Component;

/**
 * 监听ApplicationEvent事件
 * 没有指定ApplicationListener的具体类型，会接受到所有ApplicationEvent事件 
 */
@Component
public class AppApplicationListener implements ApplicationListener {

    @Override
    public void onApplicationEvent(ApplicationEvent event) {
        System.out.println("+++++++++++++++++++++++++++++++++++++++++++++");
        if (event instanceof ContextStartedEvent){
            System.out.println("================:{}"+ "ContextStartedEvent");
        }
        if (event instanceof ContextRefreshedEvent){
            System.out.println("================:{}"+ "ContextRefreshedEvent");
            DefaultListableBeanFactory  af = (DefaultListableBeanFactory) ((ContextRefreshedEvent) event).getApplicationContext().getAutowireCapableBeanFactory();
            //af.removeBeanDefinition("testBean");
        }
        if (event instanceof ContextClosedEvent){
            System.out.println("================:{}"+ "ContextClosedEvent");
        }
        if (event instanceof ContextStoppedEvent){
            System.out.println("================:{}"+ "ContextStoppedEvent");
        }
        System.out.println(">>>>>>>>>>>>>>>>:{}\n"+event.getClass().getName());
    }

}