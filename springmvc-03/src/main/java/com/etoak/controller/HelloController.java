package com.etoak.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping("/hello")
public class HelloController {
	
	@RequestMapping("/index")
	public String index(HttpServletRequest request) {
		//获取前端请求的参数
		String name = request.getParameter("name");
		System.out.println("Param name -  " + name);
		
		//向request域传值
		request.setAttribute("result","Hello  " + name);
		
		return "hello/index";
	}
	

}
