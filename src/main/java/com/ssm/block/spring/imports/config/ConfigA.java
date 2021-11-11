package com.ssm.block.spring.imports.config;

import com.ssm.block.spring.imports.annotations.EnableAdviceTestFunction;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.ssm.block.spring.imports.bean.TestA;

@Configuration
@EnableAdviceTestFunction(false)
public class ConfigA {

	@Bean
	public TestA testA() {
		return new TestA("配置A");
	}
}
