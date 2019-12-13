package com.ssm.block.spring.imports.config.select;

import java.util.Map;
import java.util.Set;

import org.springframework.context.annotation.ImportSelector;
import org.springframework.core.type.AnnotationMetadata;

import com.ssm.block.spring.imports.annotations.EnableTestFunction;
import com.ssm.block.spring.imports.bean.TestSelect;

/**
 * IOC容器启动时，通过ConfigurationClassPostProcessor（实现了BeanDefinitionRegistryPostProcessor），在postProcessBeanDefinitionRegistry中查找ImportSelector
 * 将selectImports方法返回的数组，注入IOC中
 */
public class TestImportSelector implements ImportSelector{

	/**
	 * 根据配置类注解元信息，动态导入返回的bean
	 */
	@Override
	public String[] selectImports(AnnotationMetadata importingClassMetadata) {
		//含有EnableTestFunction注解的配置类
		String className = importingClassMetadata.getClassName();
		//含有EnableTestFunction注解的配置类上面的所有注解
		Set<String> types = importingClassMetadata.getAnnotationTypes();
		//获得给定注解（EnableTestFunction）的属性
		Map<String, Object>  attr = importingClassMetadata.getAnnotationAttributes(EnableTestFunction.class.getName());
		boolean switchFlag = (boolean) attr.get("value");
		if(switchFlag) {
			//模拟加载TestSelect
			return new String[] {TestSelect.class.getName()};
		}
		return new String[]{};
	}

}
