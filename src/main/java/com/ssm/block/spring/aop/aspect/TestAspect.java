package com.ssm.block.spring.aop.aspect;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

/**
 * 常规用法
 */
@Aspect
//@Component
public class TestAspect {

	//com.ssm.block.spring.aop.beans 包及子包的所有类所有方法
//	@Pointcut("execution(* com.ssm.block.spring.aop.beans..*(..))")
	
	//com.ssm.block.spring.aop.beans 包的所有方法(不包含子包)
	@Pointcut("execution(* com.ssm.block.spring.aop.beans.*.*(..))")
    
	//com.ssm.block.spring.aop.beans 包的所有方法(不包含子包)
//	@Pointcut("within(com.ssm.block.spring.aop.beans.*)")
	
	//com.ssm.block.spring.aop.beans 包及子包的所有方法
//	@Pointcut("within(com.ssm.block.spring.aop.beans..*)")
	
	//com.ssm.block.spring.aop.beans.MyUser 类的所有方法
//	@Pointcut("within(com.ssm.block.spring.aop.beans.MyUser)")
	public void pc() {
	}

    @Before(value = "pc()")
    public void befor() {
    	System.out.println("i am @before");
    }
    
    @After(value = "pc()")
    public void after() {
    	System.out.println("i am @after");
    }
    
    /**
     * 只有join point（目标方法）正常执行该通知生效。如果目标方法执行过程中出现异常，该通知不执行。
     * 使用returning接收返回值，注意参数名要匹配
     * 与@After的区别，@After无论目标方法是否出现异常，都会执行。
     */
//    @AfterReturning(value = "pc()")
    @AfterReturning(value = "pc()", returning="obj")
    public void AfterReturning(Object obj) {
    	System.out.println("i am @AfterReturning");
    	System.out.println("@AfterReturning收到返回值："+obj);
    }
    
    /**
     * 当目标方法抛出异常，该通知执行
     */
//    @AfterThrowing(value = "pc()")
    @AfterThrowing(value = "pc()", throwing="e")
	public void AfterThrowing(Exception e) {
    	System.out.println("i am @AfterThrowing");
    	System.out.println("AfterThrowing通知发现异常："+e.getMessage());
	}
    
    @Around(value = "pc()")
    public Object doBasicProfiling(ProceedingJoinPoint pjp) throws Throwable {
    	Object o1 = pjp.getThis();
    	Object o2 = pjp.getSignature();
    	Object o3 = pjp.getTarget();
    	Object[] o4 = pjp.getArgs();
    	
    	
    	System.out.println("i am @Around before");
        Object retVal = pjp.proceed();
        System.out.println("i am @Around after");
        return retVal;
    }
	

}