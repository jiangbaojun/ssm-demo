package com.ssm.block.mvc.rhm;

import javax.servlet.http.HttpServletRequest;

import org.springframework.web.servlet.mvc.condition.RequestCondition;

/**
 * 自定义RequestCondition
 * @author		姜宝俊
 */
public class CustomerRequestCondition implements RequestCondition<CustomerRequestCondition> {

	private int[] templates;
	private int order;

	public CustomerRequestCondition(int[] templates) {
		this.templates = templates;
	}

	public CustomerRequestCondition(int[] templates, int order) {
		this.templates = templates;
		this.order = order;
	}

	/**
	 * 当某个requestMapping，具有多个RequestCondition（即有多个RequestMappingInfo），例如注册多个RequestMappingHandlerMapping组件
	 * combin方法对这些RequestCondition进行合并
	 */
	public CustomerRequestCondition combine(CustomerRequestCondition other) {
		int[] allTemplates = mergeTemplates(other.templates);
		return new CustomerRequestCondition(allTemplates);
	}

	/**
	 * 每次请求都会执行
	 * 判断当前请求与当前condition能否对应的上，如果一致则返回当前RequestCondition，如果返回值为空，则说明其不能匹配
	 */
	public CustomerRequestCondition getMatchingCondition(HttpServletRequest request) {
		String serverName = request.getServerName();	//本测试用例，根据servername做个区分
		int template = getTemplateByServerName(serverName);
		for (int i = 0; i < templates.length; i++) {
			if (template == templates[i]) {
				return this;
			}
		}
		return null;
	}

	/**
	 * 当一次请求有多个匹配的requestMapping时，而每个requestMapping会有对应的RequestCondition。即本次请求会有多个RequestCondition
	 * 通过compareTo比较，决定使用哪个RequestCondition
	 * 例如，RequestMappingHMController的combinTest1和combinTest2方法声明的情况
	 */
	public int compareTo(CustomerRequestCondition other, HttpServletRequest request) {
		// 返回order值较小的condition
		if (other == null) {
			return 1;
		}
		return this.order - other.order;
	}

	// 项目中实际会用到的，根据当前请求的域名获取其对应用户所选择的模板
	private int getTemplateByServerName(String serverName) {
		if (serverName.equalsIgnoreCase("localhost")) {
			return 1;
		} else if (serverName.equalsIgnoreCase("127.0.0.1")) {
			return 2;
		}
		return 0;
	}

	// 将两个template数据进行合并
	private int[] mergeTemplates(int[] otherTemplates) {
		if (null == otherTemplates) {
			return templates;
		}

		int[] results = new int[templates.length + otherTemplates.length];
		for (int i = 0; i < templates.length; i++) {
			results[i] = templates[i];
		}

		for (int i = templates.length; i < results.length; i++) {
			results[i] = otherTemplates[i - templates.length];
		}

		return results;
	}
}