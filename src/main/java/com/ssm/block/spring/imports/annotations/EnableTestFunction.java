package com.ssm.block.spring.imports.annotations;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import org.springframework.context.annotation.Import;

import com.ssm.block.spring.imports.config.select.TestImportSelector;

/**
 * 自定义注解，通过import引入ImportSelector类（本例：TestImportSelector）
 * 由ImportSelector类根据当前注解信息，决定引入那些bean
 */
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.TYPE)
@Import(TestImportSelector.class)
public @interface EnableTestFunction {
	
	boolean value(); 
	
}
