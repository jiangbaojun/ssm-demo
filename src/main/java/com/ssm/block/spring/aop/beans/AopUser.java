package com.ssm.block.spring.aop.beans;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.stereotype.Component;

import com.ssm.block.spring.aop.annotation.MethodTest;
import com.ssm.block.spring.aop.annotation.TargetTest;

@Component
@TargetTest
public class AopUser {

	private String mame;
	
	@MethodTest
	public String workDate1(Date date1) {
		System.out.println("i workDate1");
		return "i workDate1 at "+new SimpleDateFormat("yyyy-MM-dd").format(date1);
	}
	
	@MethodTest
	public String workDate2(Date date2) {
		System.out.println("i workDate2");
		return "i workDate2 at "+new SimpleDateFormat("yyyy-MM-dd").format(date2);
	}
	
	@MethodTest
	public void workString(String str) {
		System.out.println("i workString");
	}
	
	@MethodTest
	public void workStringAndDate(Date date, String str) {
		System.out.println("i workStringAndDate");
	}
	@MethodTest
	public void workString2AndDate(String str2, Date date, String str) {
		System.out.println("i workString2AndDate");
	}
	
	public void eat() {
		System.out.println("i eating");
	}

	public String getMame() {
		return mame;
	}

	public void setMame(String mame) {
		this.mame = mame;
	}
	
	
}
