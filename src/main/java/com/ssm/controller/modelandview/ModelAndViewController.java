package com.ssm.controller.modelandview;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.ssm.model.Tuser;

/**
 * modelandview使用
 */
@Controller
@RequestMapping("/mv")
public class ModelAndViewController {

	// @ModelAttribute修饰的方法会先于t1调用，该方法用于接收前台jsp页面传入的参数
	@ModelAttribute
	public void userModel(String loginname, Integer age, Model model) {
		Tuser user = new Tuser();
		user.setName(loginname);
		user.setAge(age);
		model.addAttribute("user", user);
	}

	/**
	 * model实际上是把属性放入request域中，类似request.setAttribute()
	 */
	@RequestMapping(value = "/t1")
	public String t1(HttpServletRequest request, Model model) {
		Tuser user = (Tuser) model.asMap().get("user");
		System.out.println(user);
		user.setName("测试");
		return "mv/t1";
	}

	/**
	 * 使用modelAndView跳转页面，传递数据
	 */
	@RequestMapping("/t2")
	public ModelAndView t2(HttpServletRequest request, Model model) {
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("mv/t1");
		//添加现有的model
		modelAndView.addAllObjects(model.asMap());
		modelAndView.addObject("message", "Hello World, Hello Kitty");
		return modelAndView;
	}
	
	 /**
     * ModelAndView默认转发
     * ModelAndView还是可以设置重定向
     */
    @RequestMapping("/t3")
    public ModelAndView T3(String name) {
        if (name!=null) {
        	//重定向到某个地址，而不是视图
            return new ModelAndView("redirect:/mv/t1.do");
        }
        //转发到指定视图。本例pages/mv/t1.jsp
        return new ModelAndView("mv/t1");
    }
    
    /**
     * 跳转到自定义视图
     * 如：http://127.0.0.1:8980/ssm-demo/mv/t4.do?viewName=helloView
     * @param viewName
     * @param request
     * @param response
     * @return		 
     * @date 		2019年10月23日 上午11:02:50
     * @version 	V1.0
     */
    @RequestMapping("/t4")
    public ModelAndView T4(String viewName, HttpServletRequest request, HttpServletResponse response) {
        //转发到指定视图
        return new ModelAndView(viewName);
    }
}