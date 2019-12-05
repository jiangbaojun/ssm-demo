package com.ssm.block.spring.event.listen;

import org.springframework.context.ApplicationListener;
import org.springframework.context.PayloadApplicationEvent;
import org.springframework.stereotype.Component;

/**
 * 接收PayloadApplicationEvent类型事件。并且paylod是字符串
 */
//@Component
//public class ListenerPayLoad implements ApplicationListener<PayloadApplicationEvent<String>> {
//	public void onApplicationEvent(PayloadApplicationEvent<String> event) {
//		String msg = event.getPayload();
//		System.out.println("ListenerPayLoad收到事件:" + msg);
//	}
//}

/**
 * 接收PayloadApplicationEvent类型事件。任意的payload类型
 */
@Component
public class ListenerPayLoad implements ApplicationListener<PayloadApplicationEvent> {
    public void onApplicationEvent(PayloadApplicationEvent event) {
        Object msg = event.getPayload();
        System.out.println("ListenerPayLoad收到事件:" + msg);
    }
}