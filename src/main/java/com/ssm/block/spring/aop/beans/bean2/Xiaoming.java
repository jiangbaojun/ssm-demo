package com.ssm.block.spring.aop.beans.bean2;

import com.ssm.block.spring.aop.annotation.MethodTest;
import com.ssm.block.spring.aop.annotation.TargetTest;
import org.springframework.stereotype.Component;

@Component
@TargetTest
public class Xiaoming extends People{

    public Xiaoming(){
        name = "小明";
        age = 12;
    }

    @MethodTest("123")
    public void printSex(){
        System.out.println("男");
    }

    public String setName(String name) {
        this.name = name;
        return name;
    }
}
