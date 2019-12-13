package com.ssm.block.spring.imports.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.ssm.block.spring.imports.bean.TestA;

@Configuration
public class ConfigA {

	@Bean
	public TestA testA() {
		return new TestA("配置A");
	}
}
