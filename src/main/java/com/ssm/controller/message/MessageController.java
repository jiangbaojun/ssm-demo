package com.ssm.controller.message;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.ssm.model.Tuser;

/**
 * messageConvert使用
 */
@Controller
@RequestMapping("/message")
public class MessageController {

	/**
	 * 单个参数
	 */
	@RequestMapping(value="/t1")
	@ResponseBody
	public String t1(@RequestBody String str) {
		System.out.println("str:"+str);
		return "Read data:"+str;
	}
	
	/**
	 * 在形参上同时声明两个@RequestBody是不被支持的
	 * https://blog.csdn.net/isea533/article/details/33397735
	 */
	@RequestMapping(value="/t2")
	@ResponseBody
	public String t2(@RequestBody String str, @RequestBody String aa) {
		System.out.println("str:"+str);
		System.out.println("aa:"+aa);
	    return "Read data:"+str+"-"+aa;
	}
	
	/**
	 * 对象示例。只允许TUser的属性，或者在实体类上添加忽略注解
	 * https://blog.csdn.net/isea533/article/details/33397735
	 */
	@RequestMapping(value="/t3")
	@ResponseBody
	public Tuser t3(@RequestBody Tuser user) {
		System.out.println("user:"+user);
//		user.setBirthday(new Date());
//		user.setUpdate_time(new Timestamp(new Date().getTime()));
//		user.setTime(new Time(new Date().getTime()));
		return user;
	}
}