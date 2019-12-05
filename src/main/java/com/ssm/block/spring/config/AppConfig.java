package com.ssm.block.spring.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

import com.ssm.block.spring.config.beans.Cuser;

/**
 * 配置类
 */
@Configuration
@ComponentScan(basePackages = "com.ssm.block.spring.config")
@PropertySource("classpath:/properties/jdbc.properties")
public class AppConfig  {
	
	@Bean("annotationUser")
	public Cuser getCuser() {
		Cuser u= new Cuser();
		u.setName("anno的小明");
		return u;
	}
}

