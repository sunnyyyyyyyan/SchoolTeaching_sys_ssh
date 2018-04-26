package com.dao;

import java.util.List;

import com.po.User;

public interface UserDao {
	//增删改查
	public List<User> getData(String hql);
	public boolean addUser(User user);
	public boolean delUser(User user);
	public boolean updateUser(User user);

	//查询所有用户列表
	/*public List<User> getAllUserData(int pageNow, int pageSize);
	public int findAUserSize();*/
}
