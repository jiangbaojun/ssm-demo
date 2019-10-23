package com.ssm.controller.mapping;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.mvc.condition.PatternsRequestCondition;
import org.springframework.web.servlet.mvc.condition.RequestMethodsRequestCondition;
import org.springframework.web.servlet.mvc.method.RequestMappingInfo;

import com.ssm.block.mvc.rhm.CustomerHandlerMapping;

/**
 * 查找所有mappings
 */
@Controller
public class MappingScanController {

	/** 根据自己项目里面的requestMappingHandlerMapping，进行注入 */
	@Autowired
	private CustomerHandlerMapping requestMappingHandlerMapping;

	@RequestMapping(value = "/mappings")
	@ResponseBody
	public List<HashMap<String, String>> list() {
		List<HashMap<String, String>> urlList = new ArrayList<HashMap<String, String>>();

		Map<RequestMappingInfo, HandlerMethod> map = requestMappingHandlerMapping.getHandlerMethods();
		for (Map.Entry<RequestMappingInfo, HandlerMethod> m : map.entrySet()) {
			HashMap<String, String> hashMap = new HashMap<String, String>();
			RequestMappingInfo info = m.getKey();
			HandlerMethod method = m.getValue();
			PatternsRequestCondition p = info.getPatternsCondition();
			for (String url : p.getPatterns()) {
				hashMap.put("url", url);
			}
			hashMap.put("className", method.getMethod().getDeclaringClass().getName()); // 类名
			hashMap.put("method", method.getMethod().getName()); // 方法名
			hashMap.put("request-method", info.getMethodsCondition().getMethods().toString());
			RequestMethodsRequestCondition methodsCondition = info.getMethodsCondition();
			String type = methodsCondition.toString();
			if (type != null && type.startsWith("[") && type.endsWith("]")) {
				type = type.substring(1, type.length() - 1);
				hashMap.put("type", type); // 方法名
			}
			urlList.add(hashMap);
		}
		return urlList;
	}

}