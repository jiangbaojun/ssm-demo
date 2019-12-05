package com.ssm.block.spring.aop.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;

@Aspect
public class TestAspectPointCut {
	
   @Pointcut("within(com.ssm.block.spring.aop.beans..)")
   public void pc1() {}

   @Pointcut("within(com.xyz.someapp.service..)")
   public void pc2() {}

  
   @Pointcut("within(com.xyz.someapp.dao..)")
   public void pc3() {}
   
   @Pointcut("execution( com.xyz.someapp..service..(..))")
   public void pc4() {}

   @Pointcut("execution( com.xyz.someapp.dao..(..))")
   public void pc5() {}
}