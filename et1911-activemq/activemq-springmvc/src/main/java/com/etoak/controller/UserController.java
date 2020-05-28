package com.etoak.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.etoak.service.UserService;
import com.etoak.user.User;

@Controller
@RequestMapping("/user")
public class UserController {
	
	@Autowired
	UserService userService;
	
	@PostMapping("/reg")
	public String addUser(User user) {
		
		
		 userService.addUser(user);
		 return "redirect:/user/toReg";
	}
	
	@RequestMapping("/toReg")
	public String toReg() {
		
		return "reg";
	}
	

}
