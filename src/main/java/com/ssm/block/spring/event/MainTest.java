package com.ssm.block.spring.event;

import java.util.ArrayList;
import java.util.List;

import org.springframework.context.ApplicationEventPublisher;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.ssm.block.spring.event.entry.Event1;
import com.ssm.block.spring.event.entry.Event2;

/**
 * 测试发布和监听事件
 */
public class MainTest {
	public static void main(String[] args) {
//		ConfigurableApplicationContext  context = new ClassPathXmlApplicationContext("spring-annotation-common.xml");
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
		context.register(AppConfig.class);
		context.refresh();

		MyPublisher myPublisher = context.getBean("myPublisher", MyPublisher.class);
		ApplicationEventPublisher applicationEventPublisher  = myPublisher.getApplicationEventPublisher();
		
		//发布ApplicationEvent事件
		applicationEventPublisher.publishEvent(new Event1("我是事件1"));
		applicationEventPublisher.publishEvent(new Event2("我是事件2"));
		
		//发布默认的事件
		//当publishEvent发布的不是ApplicationEvent类型时，默认为PayloadApplicationEvent<T>类型。
		applicationEventPublisher.publishEvent("我是事件");
		List<String> list = new ArrayList<String>();
		list.add("a");list.add("b");list.add("c");
        applicationEventPublisher.publishEvent(list);
        
		context.close();

	}
}
