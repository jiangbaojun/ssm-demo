package com.ssm.block.spring.event.entry;

import org.springframework.context.ApplicationEvent;

/**
 * Event1类型的事件
 */
public class Event1 extends ApplicationEvent {

	private static final long serialVersionUID = 1L;

	public Event1(Object source) {
		super(source);
	}

}
