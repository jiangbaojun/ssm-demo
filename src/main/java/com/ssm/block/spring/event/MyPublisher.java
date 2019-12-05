package com.ssm.block.spring.event;

import org.springframework.context.ApplicationEventPublisher;
import org.springframework.context.ApplicationEventPublisherAware;
import org.springframework.stereotype.Component;

/**
 * 事件发布者
 */
@Component("myPublisher")
public class MyPublisher implements ApplicationEventPublisherAware{
    private ApplicationEventPublisher applicationEventPublisher;

    @Override
    public void setApplicationEventPublisher(ApplicationEventPublisher applicationEventPublisher) {
        this.applicationEventPublisher = applicationEventPublisher;
    }
    
    public ApplicationEventPublisher getApplicationEventPublisher() {
		return applicationEventPublisher;
	}
}