package com.service;

import com.po.User;

import java.util.List;

public interface UserService {
	public String loginService(User user);    //登录

	public String addService(User user);    //添加

	/*public List<User> getAllUserData();		//查询所有用户*/

	public String updateUser(User user);	//修改用户信息

	public List<User> getUserId(String userId);	//根据userId查询一条用户信息

	public String deleteUser(String userId);	//根据userId删除一条

	public List<User> getSubjectNameByTeacherIdData(String userId);

	public List<User> getAllUserData(int pageNow, int pageSize);
	public int findAllUserSize();
}
