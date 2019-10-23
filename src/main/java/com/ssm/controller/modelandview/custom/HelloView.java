package com.ssm.controller.modelandview.custom;

import java.util.Date;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Component;
import org.springframework.web.servlet.View;

/**
 * 自定义视图，视图名称为bean名称。配置文件中有BeanNameViewResolver的配置
 * @author		姜宝俊
 */
@Component
public class HelloView implements View{
	
	    @Override
	    public String getContentType(){
	        return "text/html";
	    }
	    
	    @Override
	    public void render(Map<String,?> model,HttpServletRequest request,
	            HttpServletResponse response){
	    	try {
	    		response.getWriter().print("<h1>hello view,time:"+new Date()+"</h1>");
			} catch (Exception e) {
				e.printStackTrace();
			}
	    }
	}