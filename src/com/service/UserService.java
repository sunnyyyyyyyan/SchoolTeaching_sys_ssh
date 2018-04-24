package com.service;

import com.po.User;

public interface UserService {
	public String loginService(User user);    //登录

	public String addService(User user);    //添加
}
