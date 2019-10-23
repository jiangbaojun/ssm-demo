package com.ssm.controller.modelandview.custom;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Component;
import org.springframework.web.servlet.view.AbstractView;

/**
 * 自定义视图，视图名称为bean名称。配置文件中有BeanNameViewResolver的配置
 * @author		姜宝俊
 */
@Component
public class WelcomeView extends AbstractView {

    @Override
    //执行Model对象解析
    protected void renderMergedOutputModel(Map<String, Object> model, HttpServletRequest request, HttpServletResponse response)
            throws Exception {
        response.setContentType("text/html;charset=utf-8");
        String html = "我是自定义的视图";
        response.setContentLength(html.getBytes().length);
        response.getOutputStream().write(html.getBytes());

    }

}