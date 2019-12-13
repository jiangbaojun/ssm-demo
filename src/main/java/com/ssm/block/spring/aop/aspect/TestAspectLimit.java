package com.ssm.block.spring.aop.aspect;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

/**
 * 限定条件
 */
@Component
@Aspect
public class TestAspectLimit {

	//参数类型为Date，并且只有一个Date类型的参数
//	@Pointcut("execution(* com.ssm.block.spring.aop.beans..*(..)) && args(java.util.Date)")
	
	//参数类型包含Date，并且以Date开始
//	@Pointcut("execution(* com.ssm.block.spring.aop.beans..*(..)) && args(java.util.Date,..)")
	
	//含有MethodTest注解
	@Pointcut("execution(* com.ssm.block.spring.aop.beans..*(..)) && @annotation(com.ssm.block.spring.aop.annotation.MethodTest)")
	public void pc1() {}

	@Before(value = "pc1()")
	public void befor(JoinPoint jp) {
		Object[] args = jp.getArgs();//获得传入的join point参数
		System.out.println("i am @before");
	}
	
	/**
	 * 可以在通知方法上，添加args(date)，获得join point方法参数
	 * 注意参数名要匹配。
	 * 本例中只有参数是(Date,String)的joint point生效
	 */
	@Before(value = "pc1() && args(date,str)")
	public void befor1(Date date, String str) {
		System.out.println("your str "+str+", your date "+new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(date));
		System.out.println("i am @before1");
	}
}