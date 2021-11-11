package com.ssm.block.spring.imports;

import com.ssm.block.spring.imports.annotations.EnableTestFunction;
import com.ssm.block.spring.imports.bean.Test;
import com.ssm.block.spring.imports.config.ConfigA;
import com.ssm.block.spring.imports.config.ConfigB;
import com.ssm.block.spring.imports.config.register.TestImportBeanDefinitionRegistrar;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.context.annotation.ImportResource;

/**
 * import测试
 * 使用@Import导入一个或多个配置类
 * 使用@ImportResource导入xml配置
 * 使用@EnableTestFunction，通过ImportSelector导入配置
 */
@Configuration
//@Import(ConfigA.class)
@Import({ConfigA.class, ConfigB.class, TestImportBeanDefinitionRegistrar.class})
@ImportResource("classpath:/com/ssm/block/spring/imports/config/config.xml")
@EnableTestFunction(true)
//@EnableAdviceTestFunction(true)
public class AppConfig {

	@Bean
	public Test test() {
		return new Test("配置test");
	}
}
