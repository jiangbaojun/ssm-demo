package com.ssm.block.spring.event.entry;

import org.springframework.context.ApplicationEvent;

/**
 * Event2类型的事件
 */
public class Event2 extends ApplicationEvent {

	private static final long serialVersionUID = 1L;

	public Event2(Object source) {
		super(source);
	}

}
