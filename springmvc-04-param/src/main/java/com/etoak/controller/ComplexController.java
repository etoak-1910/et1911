package com.etoak.controller;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.util.CollectionUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

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
	
	
	/**
	 * *第四种接受参数的方式  :  使用ModelMap接受参数
	 * 第四种向request域传递值的方式   使用ModelMap
	 * @param hobby
	 * @param modelMap
	 * @return
	 */
	
	@PostMapping("/array")
	public String array(String[] hobby,ModelMap modelMap) {
		for(String hobbyStr : hobby) {
			System.out.println("hobby  -  " + hobbyStr);
		}
		
		//传参
		modelMap.addAttribute("result","使用ModelMap传值");
		return "param";
		
	}
	
	/**
	 * *第五种接受参数的方式  :  使用Map接受参数
	 * 第五种向request域传递值的方式   使用Map
	 * @param student
	 * @param map
	 * @return
	 */
	@PostMapping("/list")
	public String list(Student student,Map<String, Object> map) {
		List<String> hobbyList = student.getHobbyList();
		
		//当他不为空时遍历
		if(!CollectionUtils.isEmpty(hobbyList)) {
			hobbyList.forEach(x -> System.out.println(x));
		}
		//传参
		map.put("result","使用map传值");
		return "param";
		
	}
	
	
	/**
	 * *第六种接受参数的方式  :  使用map封装的JavaBean中接受参数
	 * 第六种向request域传递值的方式   使用Map
	 * @param student
	 * @return
	 */
	@PostMapping(value = "/map", produces = {"text/plain"})
	@ResponseBody // 可以返回 json xml 纯文本
	public String map(Student student) {
		
		System.out.println(student.getStuMap());
		
		return "success";
		
		
	}
	
	
}
