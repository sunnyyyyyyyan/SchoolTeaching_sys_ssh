package com.service;

import com.po.User;

import java.util.List;

public interface UserService {
	public String loginService(User user);    //登录

	public String addService(User user);    //添加

	public List<User> getAllUserData(int pageNow, int pageSize);
	public int findAUserSize();
}
