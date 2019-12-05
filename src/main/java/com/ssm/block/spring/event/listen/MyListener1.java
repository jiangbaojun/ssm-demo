package com.ssm.block.spring.event.listen;

import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;

import com.ssm.block.spring.event.entry.Event1;

/**
 * 监听Event1类型事件
 */
@Component
public class MyListener1 implements ApplicationListener<Event1> {

    @Override
    public void onApplicationEvent(Event1 event) {
        System.out.println("MyListener1收到Event1事件："+ event.getSource());
    }

}