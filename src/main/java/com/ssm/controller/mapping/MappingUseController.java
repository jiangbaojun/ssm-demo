package com.ssm.controller.mapping;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * mapping使用
 */
@Controller
@RequestMapping("/use")
public class MappingUseController {

	@RequestMapping(value = "/t1")
	@ResponseBody
	public String t1() {
		return "t1";
	}

	/**
	 * 使用get方式访问：http://127.0.0.1:8980/ssm-demo/use.do
	 */
	@RequestMapping(method = RequestMethod.GET)
	@ResponseBody
	public String t2() {
		return "t2";
	}

	/**
	 * produces生产者，表明response响应的content-type是produces类型的
	 */
	@RequestMapping(value = "/prod", produces = { "application/JSON" })
	@ResponseBody
	String getProduces() {
		return "Produces attribute";
	}

	/**
	 * consumes消费者，表明只接受（只消费）content-type是consumes类型的请求
	 */
	@RequestMapping(value = "/cons", consumes = { "application/JSON", "application/XML" })
	@ResponseBody
	String getConsumes() {
		return "Consumes attribute";
	}

	/**
	 * 请求的head必须和headers指定项匹配。本例，请求的head必须要有auth=123
	 * 如果是content-type项，consumes最终取consumes和headers的并集
	 */
	@RequestMapping(value = "/head", 
			consumes = { "application/JSON", "application/XML" },
			headers = { "content-type=text/plain", "content-type=text/html", "auth=123" })
	@ResponseBody
	String head() {
		return "head is mapping";
	}
	
	/**
	 * 请求必须包含指定的参数
	 */
	@RequestMapping(value = "/param", params = {"aa=11", "bb=22"})
	@ResponseBody
	String param() {
		return "params is correct";
	}
}