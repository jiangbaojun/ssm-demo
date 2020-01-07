package com.ssm.block.mvc.message.bak;

import java.text.DateFormat;

import com.fasterxml.jackson.databind.ObjectMapper;

/**
 * 自定义ObjectMap的日期格式化，此种方式叫繁琐，建议使用objectmapper的serializer实现
 * @author		姜宝俊
 */
public class MyObjectMapper1 extends ObjectMapper {
	private static final long serialVersionUID = 1L;

	
	@Override
	public ObjectMapper setDateFormat(DateFormat dateFormat) {
		super.setDateFormat(new MyDateFormat(dateFormat));
		return this;
	}
}
