package com.ssm.block.spring.aop.beans.bean2;

import com.ssm.block.spring.aop.annotation.MethodTest;
import org.springframework.stereotype.Component;

@Component
public class Xiaohong extends People{

    public Xiaohong(){
        name = "小红";
        age = 12;
    }

    @MethodTest
    public void printSex(){
        System.out.println("女");
    }
}
