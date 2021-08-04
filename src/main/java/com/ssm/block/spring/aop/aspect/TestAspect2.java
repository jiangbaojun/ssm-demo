package com.ssm.block.spring.aop.aspect;

import com.ssm.block.spring.aop.annotation.MethodTest;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

/**
 * 常规用法
 */
@Aspect
@Component
public class TestAspect2 {


	//@within，执行方法（join point）所在的类上有TargetTest注解，这个类可以是父类(看joint point是在父类还是子类)
	@Pointcut("@within(com.ssm.block.spring.aop.annotation.TargetTest) && @annotation(com.ssm.block.spring.aop.annotation.MethodTest)")

    //@target，调用执行方法（join point）的目标对象类上有TargetTest注解，这个类不可以是父类。
//	@Pointcut("@target(com.ssm.block.spring.aop.annotation.TargetTest) && @annotation(com.ssm.block.spring.aop.annotation.MethodTest)")
	public void pc() {
	}

    /**
     * 使用@Before("pc() && @annotation(methodTest)") 获得注解对象
     * 其中 @annotation(methodTest)中的值必须和before方法参数名称一致
     * @param jp
     * @param methodTest
     */
//    @Before(value = "pc()")
    @Before("pc() && @annotation(methodTest)")
    public void befor(JoinPoint jp, MethodTest methodTest) {
    	System.out.println("i am TestAspect2 @before");
    }

    @After(value = "pc()")
    public void after() {
    	System.out.println("i am TestAspect2 @after");
    }

    /**
     * 只有join point（目标方法）正常执行该通知生效。如果目标方法执行过程中出现异常，该通知不执行。
     * 使用returning接收返回值，注意参数名要匹配
     * 与@After的区别，@After无论目标方法是否出现异常，都会执行。
     */
//    @AfterReturning(value = "pc()")
    @AfterReturning(value = "pc()", returning="obj")
    public void AfterReturning(Object obj) {
    	System.out.println("i am TestAspect2 @AfterReturning");
    	System.out.println("@AfterReturning收到返回值："+obj);
    }

    /**
     * 当目标方法抛出异常，该通知执行
     */
//    @AfterThrowing(value = "pc()")
    @AfterThrowing(value = "pc()", throwing="e")
	public void AfterThrowing(Exception e) {
    	System.out.println("i am TestAspect2 @AfterThrowing");
    	System.out.println("AfterThrowing通知发现异常："+e.getMessage());
	}

    @Around(value = "pc()")
    public Object doBasicProfiling(ProceedingJoinPoint pjp) throws Throwable {
    	Object o1 = pjp.getThis();
    	Object o2 = pjp.getSignature();
    	Object o3 = pjp.getTarget();
    	Object[] o4 = pjp.getArgs();


    	System.out.println("i am TestAspect2 @Around before");
        Object retVal = pjp.proceed();
        System.out.println("i am TestAspect2 @Around after");
        return retVal;
    }


}
