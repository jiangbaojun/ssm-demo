package com.ssm.block.spring.event.listen;

import org.springframework.context.event.EventListener;
import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.stereotype.Component;

import com.ssm.block.spring.event.entry.Event1;
import com.ssm.block.spring.event.entry.Event2;

/**
 * 通过@EventListener注解，间厅指定类型的事件
 */
@Component
public class MyAnnotationListener {

    @EventListener
    public void listener1(Event1 event) {
        System.out.println("注解监听event1:" + event.getSource());
    }

    /**
     *  此处要注意，如果需要通过@Async开启异步事件。一定要记得打开spring容器的异步开关，可以通过@EnableAsync注解开启
     */
    @EventListener
    @Async
    public void listener2(Event2 event) {
        try {
        	System.out.println("注解监听event2,异步before");
            Thread.sleep(3000);
            System.out.println("注解监听event2,异步after");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("注解监听event2:" + event.getSource());
    }

}
