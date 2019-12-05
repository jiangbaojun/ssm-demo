package com.ssm.block.spring.event;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableAsync;

@Configuration
@ComponentScan(basePackages = "com.ssm.block.spring.event")
@EnableAsync
public class AppConfig {

}
