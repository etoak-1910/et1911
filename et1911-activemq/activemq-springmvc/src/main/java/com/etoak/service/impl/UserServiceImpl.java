package com.etoak.service.impl;

import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.etoak.mapper.UserMapper;
import com.etoak.service.UserService;
import com.etoak.user.User;


@Service
public class UserServiceImpl implements UserService{
	@Autowired
	UserMapper userMapper;
	@Override
	public int addUser(User user) {
		String userId = UUID.randomUUID().toString().replaceAll("-", "");
		user.setUserId(userId);
		return userMapper.addUser(user);
	}

}
