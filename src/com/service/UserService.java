package com.service;

import com.po.User;

public interface UserService {
	public String loginService(User user); 	//登录
	public String regService(User user); 	//注册
}
