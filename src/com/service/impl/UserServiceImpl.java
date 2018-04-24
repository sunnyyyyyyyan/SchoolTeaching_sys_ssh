package com.service.impl;

import java.util.List;

import com.dao.UserDao;
import com.opensymphony.xwork2.ActionContext;
import com.po.User;
import com.service.UserService;

public class UserServiceImpl implements UserService {
	private UserDao userDao;
	
	
	public UserDao getUserDao() {
		return userDao;
	}

	public void setUserDao(UserDao userDao) {
		this.userDao = userDao;
	}

	@Override
	public String loginService(User user) {
		// TODO Auto-generated method stub
		String hql="from User where userId='"+user.getUserId()+"' and password='"+user.getPassword()+"'";
		List<User> list=this.userDao.getData(hql);
		if(list.size()>0){
			return "loginSuccess";
		}
		ActionContext.getContext().put("mess","用户名或密码不正确");
		return "loginError";
	}

	@Override
	public String addService(User user) {
		// TODO Auto-generated method stub
		String sql = "from User where userId='" + user.getUserId() + "'";
		List<User> list = this.userDao.getData(sql);
		if (list.size() > 0) {
			ActionContext.getContext().put("mess","用户已存在");
			return "addError";
		}
		if (userDao.addUser(user)) {
			return "addSuccess";
		}
		ActionContext.getContext().put("mess", "添加失败");
		return "addError";
	}

}
