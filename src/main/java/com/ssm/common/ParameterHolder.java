package com.ssm.common;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.time.DateUtils;
import org.springframework.web.context.request.NativeWebRequest;
import org.springframework.web.context.request.RequestAttributes;
import org.springframework.web.context.request.ServletWebRequest;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.servlet.HandlerMapping;

import com.alibaba.fastjson.JSON;
import com.ssm.common.constant.ConfigConstant;

/**
 * 参数处理类
 */
public class ParameterHolder {

    /**
     * 解析request参数
     */
	public static Map<String, Object> getFormParameter(HttpServletRequest request) {
		Map<String, Object> paramMap = (Map<String, Object>) request.getAttribute(ConfigConstant.REQUESTMAP_KEY);
		if (paramMap != null) {
			return paramMap;
		} else {
			paramMap = new HashMap<String, Object>();
			request.setAttribute(ConfigConstant.REQUESTMAP_KEY, paramMap);
		}
		//文件form key
		List<String> filesKey = new ArrayList<String>();
		// 解析上传文件
		if (request instanceof MultipartHttpServletRequest) {
			MultipartHttpServletRequest multipartRequest = (MultipartHttpServletRequest) request;
			Map<String, MultipartFile> files = multipartRequest.getFileMap();
			Iterator<String> iterator = files.keySet().iterator();
			while (iterator.hasNext()) {
				String formKey = (String) iterator.next();
				filesKey.add(formKey);
				List<MultipartFile> fileList = new ArrayList<MultipartFile>();
				List<MultipartFile> multipartFileList = multipartRequest.getFiles(formKey);
				// 过滤为空的上传文件
				for (MultipartFile multipartFile : multipartFileList) {
					if (StringUtils.isNotEmpty(multipartFile.getOriginalFilename())) {
						fileList.add(multipartFile);
					}
				}
				if (fileList.size() > 0) {
					paramMap.put(formKey, multipartFileList);
				}
			}
		}
		// 解析query参数
		for (Entry<String, String[]> entry : request.getParameterMap().entrySet()) {
			String name = entry.getKey();
			String[] names = name.split("-", -1);
			//该项是文件
			if(filesKey.contains(name)) {
				continue;
			}
			if (names.length > 2) {
				// 忽略不符合格式的参数，参数格式为：big-* 或 d-* 或 *
				continue;
			}
			String[] values = entry.getValue();
			Object value = StringUtils.join(values, ",");
			if ("".equals(value)) {
				value = null;// 保留空置
			}
			if (names.length == 2 && value != null) {
				name = names[1];
				value = formatValue(names[0], value);
			}
			paramMap.put(name, value);
		}
		//解析payload body参数
		paramMap = handlePayloadParam(paramMap,request);
		//path参数
		paramMap = handleRestParam(paramMap,request);
		return paramMap;
	}

    private static Map<String, Object> handlePayloadParam(Map<String, Object> paramMap, HttpServletRequest request){
        if(paramMap==null){
            paramMap = new HashMap<String, Object>();
        }
        Map<String, Object> payloadMap = new HashMap<String, Object>();
        try {
            // 获取输入流
            BufferedReader streamReader = new BufferedReader(new InputStreamReader(request.getInputStream(), "UTF-8"));

            // 写入数据到Stringbuilder
            StringBuilder sb = new StringBuilder();
            String line = null;
            while ((line = streamReader.readLine()) != null) {
                sb.append(line);
            }
            payloadMap = JSON.parseObject(sb.toString());
            paramMap.putAll(payloadMap);
        } catch (Exception e) {}
        return paramMap;
    }

    /**
     * 解析rest风格的path参数。如果存在冲突，优先path参数
     */
	private static Map<String, Object> handleRestParam(Map<String, Object> paramMap, HttpServletRequest request) {
	    if(paramMap==null){
            paramMap = new HashMap<String, Object>();
        }
		NativeWebRequest webRequest = new ServletWebRequest(request);
		Map<String, String> uriTemplateVars = (Map<String, String>) webRequest.getAttribute(HandlerMapping.URI_TEMPLATE_VARIABLES_ATTRIBUTE, RequestAttributes.SCOPE_REQUEST);
		paramMap.putAll(uriTemplateVars);
		return paramMap;
	}

	private static Object formatValue(String prefix, Object val) {
		Object result = null;
		String value = "";
		try {
			value = String.valueOf(val);
			if ("int".equalsIgnoreCase(prefix)) {
				result = Integer.parseInt(value);
			} else if ("long".equalsIgnoreCase(prefix)) {
				result = Long.parseLong(value);
			} else if ("date".equalsIgnoreCase(prefix)) {
				result = DateUtils.parseDate(String.valueOf(value), ConfigConstant.DATE_TIME_FORMAT);
			} else if ("double".equalsIgnoreCase(prefix)) {
				result = Double.parseDouble(value);
			} else if ("boolean".equalsIgnoreCase(prefix)) {
				result = Boolean.parseBoolean(value);
			} else if ("bigDecimal".equalsIgnoreCase(prefix)) {
				result = new BigDecimal(value);
			} else if ("string[]".equalsIgnoreCase(prefix)) {
				result = StringUtils.split(value, ",");
			} else if ("int[]".equalsIgnoreCase(prefix)) {
				String[] s = StringUtils.split(value, ",");
				Integer[] order_int = new Integer[s.length];
				for (int i = 0; i < s.length; i++) {
					order_int[i] = Integer.parseInt(s[i]);
				}
				result = order_int;
			} else if ("long[]".equalsIgnoreCase(prefix)) {
				String[] s = StringUtils.split(value, ",");
				Long[] order_long = new Long[s.length];
				for (int i = 0; i < s.length; i++) {
					order_long[i] = Long.parseLong(s[i]);
				}
				result = order_long;
			} else if ("double[]".equalsIgnoreCase(prefix)) {
				String[] s = StringUtils.split(value, ",");
				Double[] order_double = new Double[s.length];
				for (int i = 0; i < s.length; i++) {
					order_double[i] = Double.parseDouble(s[i]);
				}
				result = order_double;
			} else if ("date[]".equalsIgnoreCase(prefix)) {
				String[] s = StringUtils.split(value, ",");
				Date[] order_date = new Date[s.length];
				for (int i = 0; i < s.length; i++) {
					order_date[i] = DateUtils.parseDate(String.valueOf(s[i]), ConfigConstant.DATE_TIME_FORMAT);
				}
				result = order_date;
			} else if ("boolean[]".equalsIgnoreCase(prefix)) {
				String[] s = StringUtils.split(value, ",");
				Boolean[] order_boolean = new Boolean[s.length];
				for (int i = 0; i < s.length; i++) {
					order_boolean[i] = Boolean.parseBoolean(s[i]);
				}
				result = order_boolean;
			} else if ("bigDecimal[]".equalsIgnoreCase(prefix)) {
				String[] s = StringUtils.split(value, ",");
				BigDecimal[] order_bigDecimal = new BigDecimal[s.length];
				for (int i = 0; i < s.length; i++) {
					order_bigDecimal[i] = new BigDecimal(s[i]);
				}
				result = order_bigDecimal;
			} else {
				result = val;
			}
		} catch (Exception e) {
			throw new RuntimeException("参数值【" + value + "】格式错误!");
		}
		return result;
	}
}
