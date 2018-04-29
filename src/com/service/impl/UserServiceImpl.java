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

	//登录
	@Override
	public String loginService(User user) {
	    System.out.println(user);
		// TODO Auto-generated method stub
		String hql="from User where userId='"+user.getUserId()+"' and password='"+user.getPassword()+"' and userType='"+user.getUserType()+"'";
		List<User> list=this.userDao.getData(hql);
		if(list.size()>0){
			return "loginSuccess";
		}
		return "loginError";
	}

	//添加用户
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

	/*//获取所有用户
    @Override
    public List<User> getAllUserData() {
        String sql = "from User";
        List<User> list = this.userDao.getData(sql);
        return list;
    }*/

    //修改用户信息
	@Override
	public String updateUser(User user) {
		String sql = "update User set username="+user.getUsername()+",password="+user.getPassword()+",phone="+user.getPhone()+",email="+user.getEmail()+" where userId='"+user.getUserId()+"'";
		List<User> list = this.userDao.getData(sql);
		if (list.size()>0){
			this.userDao.updateUser(user);
			return "updateUserSuccess";
		}
		return "updateUserError";
	}

	//获取当前用户信息
	@Override
	public List<User> getUserId(String userId) {
		String sql = "from User where userId="+userId+"'";
		List<User> list = this.userDao.getData(sql);
		return list;
	}

	@Override
	public String deleteUser(String userId) {
		String sql = "from User where userId='"+userId+"'";
		List<User> list = this.userDao.getData(sql);
		User user = list.get(0);
		if (this.userDao.delUser(user)){
			return "deleteUserSuccess";
		}
		return "deleteUserError";
	}

	//获取所有用户
	@Override
	public List<User> getAllUserData(int pageNow, int pageSize) {
		List<User> list = this.userDao.getAllUserData(pageNow,pageSize);
		return list;
	}

	@Override
    public int findAllUserSize() {
        return this.userDao.findAllUserSize();
    }

}
