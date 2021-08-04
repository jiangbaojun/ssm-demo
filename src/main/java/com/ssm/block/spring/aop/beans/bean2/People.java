package com.ssm.block.spring.aop.beans.bean2;

import com.ssm.block.spring.aop.annotation.MethodTest;
import com.ssm.block.spring.aop.annotation.TargetTest;

@TargetTest
public class People {
    protected String name;
    protected int age;

    @MethodTest
    public int printAge() {
        System.out.println(age);
        return age;
    }

    public String printName() {
        System.out.println(name);
        return name;
    }
}
