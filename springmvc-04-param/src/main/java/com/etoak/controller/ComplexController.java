package com.etoak.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.etoak.bean.Student;



/**
 * 测试Java bean 接收参数
 * 测试数组接收参数
 * 测试List接收参数
 * 测试Map接收参数
 * @author 
 *
 */
@Controller
@RequestMapping("/complex")
public class ComplexController {
	
	/**
	    *第三种接受参数的方式  :  使用Model接受参数
	 * 第三种向request域传递值的方式   使用Model
	 * @param student
	 * @param model
	 * @return
	 */
		//接收get请求:@RequestMapping的method属性指定
		//get请求:@GetMapping
	@GetMapping("/bean")
	public String bean(Student student,Model model) {
		System.out.println(student);
		
		model.addAttribute("result2","使用Model传值");
		
		// 请求转发到/simple/simple(这个请求在SimpleController中)
		return "forward:/simple/simple?id=321";
	}
	
	
}
