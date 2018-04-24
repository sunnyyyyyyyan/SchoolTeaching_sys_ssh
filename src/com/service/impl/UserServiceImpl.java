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
		String hql="from User where username='"+user.getUsername()+"' and userType='"+user.getUserType()+"' and password='"+user.getPassword()+"'";
		List<User> list=this.userDao.getData(hql);
		if(list.size()>0){
			return "loginSuccess";
		}
		ActionContext.getContext().put("mess", "用户名或密码或用户类型不正确");
		return "loginError";
	}

	@Override
	public String regService(User user) {
		// TODO Auto-generated method stub
		String hql = "from User where username='" + user.getUsername() + "'";
		//UserDao userDao = new UserDao();
		List<User> list = this.userDao.getData(hql);
		if (list.size() > 0) {
			ActionContext.getContext().put("mess", "用户已存在");
			return "regError";
		}
		if (userDao.addUser(user)) {
			return "regSuccess";
		}
		ActionContext.getContext().put("mess", "注册失败");
		return "regError";
	}
	

}
