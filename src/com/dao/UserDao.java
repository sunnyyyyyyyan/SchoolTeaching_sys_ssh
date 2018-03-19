package com.dao;

import java.util.List;

import com.po.User;

public interface UserDao {
	//²éÑ¯£¬Ìí¼Ó£¬É¾³ı£¬ĞŞ¸Ä
	public List<User> getData(String hql);
	public boolean addUser(User user);
	public boolean delUser(User user);
	public boolean updateUser(User user);
}
