package com.service.impl;

import java.util.List;

import org.apache.log4j.Logger;

import com.dao.UserDao;
import com.opensymphony.xwork2.ActionContext;
import com.po.User;
import com.service.UserService;

public class UserServiceImpl implements UserService {
    private static Logger logger =  Logger.getLogger(UserServiceImpl.class);
    
	private UserDao userDao;
	
	
	public UserDao getUserDao() {
		return userDao;
	}

	public void setUserDao(UserDao userDao) {
		this.userDao = userDao;
	}

	@Override
	public String loginService(User user) {
	    System.out.println(user);
		// TODO Auto-generated method stub
		String hql="from User where userId='"+user.getUserId()+"' and password='"+user.getPassword()+"'";
		List<User> list=this.userDao.getData(hql);
		if(list.size()>0){
			return "loginSuccess";
		}
		ActionContext.getContext().put("mess","学/编号或密码不正确！");
		return "loginError";
	}

	@Override
	public String addService(User user) {
		// TODO Auto-generated method stub
		String sql = "from User where userId='" + user.getUserId() + "'";
		List<User> list = this.userDao.getData(sql);
		if (list.size() > 0) {
			ActionContext.getContext().put("addMess","用户已存在！");
			return "addError";
		}
		if (userDao.addUser(user)) {
			ActionContext.getContext().put("addMess","添加成功！");
			return "addSuccess";
		}
		ActionContext.getContext().put("addMess", "添加失败！");
		return "addError";
	}

    @Override
    public List<User> getAllUserData() {
        String sql = "from User";
        List<User> list = userDao.getData(sql);
        return list;
    }

	@Override
	public String updateUser(User user) {
		if (this.userDao.updateUser(user)){
			return "updateUserSuccess";
		}
		return "updateUserError";
	}

	@Override
	public List<User> getUserId(String id) {
		String sql = "from User where id="+id;
		List<User> list = this.userDao.getData(sql);
		return list;
	}

    /*@Override
    public int findAUserSize() {
        return this.userDao.findAUserSize();
    }*/

}
