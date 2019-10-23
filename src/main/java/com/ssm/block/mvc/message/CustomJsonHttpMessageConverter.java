package com.ssm.block.mvc.message;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;

import org.springframework.http.HttpInputMessage;
import org.springframework.http.HttpOutputMessage;
import org.springframework.http.MediaType;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.http.converter.HttpMessageNotWritableException;

import com.fasterxml.jackson.databind.ObjectMapper;

/**
 * 自定义消息转换
 * HttpMessageConverter接口提供了 5 个方法：
		canRead：判断该转换器是否能将请求内容转换成 Java 对象
		canWrite：判断该转换器是否可以将 Java 对象转换成返回内容
		getSupportedMediaTypes：获得该转换器支持的 MediaType 类型
		read：读取请求内容并转换成 Java 对象
		write：将 Java 对象转换后写入返回内容
 * @author		姜宝俊
 */
class CustomJsonHttpMessageConverter implements HttpMessageConverter<Object> {

	// 本次测试，使用Jackson的json映射处理
	private ObjectMapper objectMapper = new ObjectMapper();

	// 该转换器的支持类型
	private List<MediaType> supportedMediaTypes = Arrays.asList(MediaType.APPLICATION_JSON);

	/**
	 * 判断转换器是否可以将输入内容转换成 Java 类型
	 * @param clazz     需要转换的 Java 类型
	 * @param mediaType 该请求的 MediaType
	 * @return
	 */
	@Override
	public boolean canRead(Class<?> clazz, MediaType mediaType) {
		if (mediaType == null) {
			return true;
		}
		for (MediaType supportedMediaType : getSupportedMediaTypes()) {
			if (supportedMediaType.includes(mediaType)) {
				return true;
			}
		}
		return false;
	}

	/**
	 * 判断转换器是否可以将 Java 类型转换成指定输出内容
	 * @param clazz     需要转换的 Java 类型
	 * @param mediaType 该请求的 MediaType
	 * @return
	 */
	@Override
	public boolean canWrite(Class<?> clazz, MediaType mediaType) {
		if (mediaType == null || MediaType.ALL.equals(mediaType)) {
			return true;
		}
		for (MediaType supportedMediaType : getSupportedMediaTypes()) {
			if (supportedMediaType.includes(mediaType)) {
				return true;
			}
		}
		return false;
	}

	/**
	 * 获得该转换器支持的 MediaType
	 */
	@Override
	public List<MediaType> getSupportedMediaTypes() {
		return supportedMediaTypes;
	}
	public void setSupportedMediaTypes(List<MediaType> supportedMediaTypes) {
		this.supportedMediaTypes = supportedMediaTypes;
	}
	/**
	 * 获得该转换器的消息处理器
	 */
	public ObjectMapper getObjectMapper() {
		return objectMapper;
	}
	public void setObjectMapper(ObjectMapper objectMapper) {
		this.objectMapper = objectMapper;
	}

	/**
	 * 读取请求内容，将其中的 Json 转换成 Java 对象
	 * @param clazz        需要转换的 Java 类型
	 * @param inputMessage 请求对象
	 */
	@Override
	public Object read(Class<?> clazz, HttpInputMessage inputMessage) throws IOException, HttpMessageNotReadableException {
		/********************** 获得请求内容，测试直接转换为字符串 ******************************/
//		InputStream inputStream = inputMessage.getBody();
//		// 获取输入流
//		BufferedReader streamReader = new BufferedReader(new InputStreamReader(inputStream, "utf-8"));
//		// 写入数据到Stringbuilder
//		StringBuilder sb = new StringBuilder();
//		String line = null;
//		while ((line = streamReader.readLine()) != null) {
//			sb.append(line);
//		}
//		return sb.toString();
		
		/********************** 测试TUser对象 ******************************/
//		return new Tuser(12,"xiaoqiang",8);
		
		/********************** jackson默认 ******************************/
		Object o = objectMapper.readValue(inputMessage.getBody(), clazz);
		return o;
	}

	/**
	 * 将 Java 对象转换成 Json 返回内容
	 * @param o             需要转换的对象
	 * @param contentType   返回类型
	 * @param outputMessage 回执对象
	 */
	@Override
	public void write(Object o, MediaType contentType, HttpOutputMessage outputMessage)
			throws IOException, HttpMessageNotWritableException {
		/********************** 测试返回自定义的数据 ******************************/
//		OutputStream outputStream = outputMessage.getBody();
//		outputStream.write(("messageConvert:"+o.toString()).getBytes("utf-8"));
		
		/********************** jackson默认 ******************************/
		objectMapper.writeValue(outputMessage.getBody(), o);
	}
}