package com.ssm.controller.mapping;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.ssm.block.mvc.rhm.WhereFrom;

/**
 * 测试自定义hanglermapping
 * 1、根据不用的servername，映射到不同的方法上。通过@WhereFrom注解进行标识
 * 2、测试RequestCondition的compareTo方法
 */
@Controller
@RequestMapping("/hm")
public class RequestMappingHMController {
	
	/**
	 * 普通测试方法
	 */
	@WhereFrom(2)
	@ResponseBody
	@RequestMapping(value = "/common")
	public String common() {
		System.out.println("普通的方法测试");
		return "普通的方法测试";
	}

	/**
	 * http://140.100.100.73:8980/ssm-demo/hm/detail.do访问
	 * 140.100.100.73是本机的局域网IP
	 */
	@WhereFrom(0)
	@ResponseBody
	@RequestMapping(value = "/detail")
	public String detailForTemplateZero() {
		System.out.println("网络地址访问");
		return "网络地址访问";
	}
	
	/**
	 * http://localhost:8980/ssm-demo/hm/detail.do访问
	 * SPRINGMVC本身具有校验机制，不能定义完全相同的@RequestMapping ，使用method做区分
	 */
	@WhereFrom(1)
	@ResponseBody
	@RequestMapping(value = "/detail", method = RequestMethod.GET)
	public String detailForTemplateOne() {
		System.out.println("localhost访问");
		return "localhost访问";
	}

	/**
	 * http://127.0.0.1:8980/ssm-demo/hm/detail.do访问
	 */
	@WhereFrom(2)
	@ResponseBody
	@RequestMapping(value = "/detail", method = { RequestMethod.GET, RequestMethod.POST })
	public String detailForTemplateTwo() {
		System.out.println("127.0.0.1访问");
		return "127.0.0.1访问";
	}
	
	/**
	 * combinTest1和combinTest2为了测试一个请求，多个匹配mapping情况。优先使用order值小的
	 * 详见RequestCondition的compareTo方法
	 */
	@WhereFrom(value={2}, order=3)
	@ResponseBody
	@RequestMapping(value = {"/test/combin","test/combin1"})
	public String combinTest1() {
		System.out.println("test/combin for complex");
		return "test/combin for complex";
	}
	
	@WhereFrom(value={2}, order=1)
	@ResponseBody
	@RequestMapping(value = "/test/combin")
	public String combinTest2() {
		System.out.println("test/combin");
		return "test/combin";
	}
}