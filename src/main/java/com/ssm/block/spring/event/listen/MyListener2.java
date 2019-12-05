package com.ssm.block.spring.event.listen;

import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;

import com.ssm.block.spring.event.entry.Event2;

/**
 * 监听Event2类型事件
 */
@Component
public class MyListener2 implements ApplicationListener<Event2> {

    @Override
    public void onApplicationEvent(Event2 event) {
    	System.out.println("MyListener2收到Event2事件："+ event.getSource());
    }

}