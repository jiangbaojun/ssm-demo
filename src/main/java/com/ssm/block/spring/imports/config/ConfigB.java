package com.ssm.block.spring.imports.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.ssm.block.spring.imports.bean.TestB;

@Configuration
public class ConfigB {

	@Bean
	public TestB testB() {
		return new TestB("配置B");
	}
}
