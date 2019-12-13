package com.ssm.block.spring.imports.config.register;

import org.springframework.beans.factory.support.BeanDefinitionBuilder;
import org.springframework.beans.factory.support.BeanDefinitionRegistry;
import org.springframework.context.annotation.ImportBeanDefinitionRegistrar;
import org.springframework.core.type.AnnotationMetadata;

import com.ssm.block.spring.imports.bean.TestDefinition;

public class TestImportBeanDefinitionRegistrar implements ImportBeanDefinitionRegistrar {

	@Override
	public void registerBeanDefinitions(AnnotationMetadata importingClassMetadata, BeanDefinitionRegistry registry) {
		BeanDefinitionBuilder testDefinition = BeanDefinitionBuilder.rootBeanDefinition(TestDefinition.class);
		// 通过registry就可以注入到容器里啦
		registry.registerBeanDefinition("testDefinition", testDefinition.getBeanDefinition());
		ImportBeanDefinitionRegistrar.super.registerBeanDefinitions(importingClassMetadata, registry);
	}
}
