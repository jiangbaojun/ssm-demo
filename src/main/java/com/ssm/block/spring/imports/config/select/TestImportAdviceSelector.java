package com.ssm.block.spring.imports.config.select;

import org.springframework.context.annotation.AdviceMode;
import org.springframework.context.annotation.AdviceModeImportSelector;

import com.ssm.block.spring.imports.annotations.EnableAdviceTestFunction;
import com.ssm.block.spring.imports.bean.TestSelect;

/**
 * IOC容器启动时，通过ConfigurationClassPostProcessor（实现了BeanDefinitionRegistryPostProcessor），在postProcessBeanDefinitionRegistry中查找ImportSelector
 * 将selectImports方法返回的数组，注入IOC中
 */
public class TestImportAdviceSelector extends AdviceModeImportSelector<EnableAdviceTestFunction>{

	/**
	 * 根据配置类注解元信息，动态导入返回的bean
	 */
	@Override
	protected String[] selectImports(AdviceMode adviceMode) {
		System.out.println(adviceMode);
		return new String[]{TestSelect.class.getName()};
	}

}
