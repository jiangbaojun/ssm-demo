package com.ssm.block.mvc.rhm;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * 自定义注解
 */
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
public @interface WhereFrom {

	/**
	 * 定义访问从哪里来，区分servername，如localhost、127.0.0.1等
	 */
	int[] value();

	/**
	 * 当有多个mapping，执行RequestCondition的compareto方法，判断依据。选择order值小的
	 */
	int order() default 0;
}