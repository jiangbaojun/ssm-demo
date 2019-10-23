package com.ssm.block.mvc.message;

import java.text.DateFormat;

import com.fasterxml.jackson.databind.ObjectMapper;

/**
 * 暂未使用自定义ObjectMapper，难度较大
 * jackson的ObjectMapper的扩展性还是很不错的，没有特殊必要，不用自定义
 * @author		姜宝俊
 */
public class MyObjectMapper extends ObjectMapper {
	private static final long serialVersionUID = 1L;

	@Override
	public ObjectMapper setDateFormat(DateFormat dateFormat) {
		super.setDateFormat(new MyDateFormat(dateFormat));
		return this;
	}
}
