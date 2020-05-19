package com.etoak.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;


/**
 * 用于测试简单的参数传递
 * 使用HttpServletRequest接受参数
 * 使用简单的类型 :  基本数据类型  和  string 接收参数
 * @author
 *
 */

@Controller
@RequestMapping("/simple")
public class SimpleController {
	/**
	 * 第一种接受参数的方式  :  使用HttpServletRequest接受参数
	 * 第一种向request域传递值的方式   使用HttpServletRequest
	 * @param request
	 * @return
	 */
	@RequestMapping("/servlet")
	public String servlet(HttpServletRequest request) {
		//接收前端传入的参数name
		String name = request.getParameter("name");
		
		
		//相当于 if(name == null  ||  "".equals(name)){}
		if(StringUtils.isEmpty(name)) {
			name = "World";
		}
		//向request域传值
		request.setAttribute("result","Hello   " + name);
		
		return "param";
	}
	
	/**
	 * 第二种接受参数的方式 : 使用基本数据类型  和  string 接收参数
	 * 第二种向request域传递值的方式   使用ModelAndView
	 * 注解@RequestParam :可以对参数进行限制
	 * required:默认true,表示参数必须传入
	 * defaultValue:
	 * @param id
	 * @param name
	 * @return
	 */
	@RequestMapping(value="/simple", method = {RequestMethod.GET})
	public ModelAndView simple(@RequestParam(required = false , defaultValue = "1")int id, String name) {
		
		System.out.println("id param  -  " + id);
		System.out.println("anme param  -  " + name);
		
		ModelAndView mv = new ModelAndView();
		//向request域传值
		mv.addObject("result", "ModelAndView传值");
		mv.setViewName("param");
		return mv;
		
	}
	
	
	
}
