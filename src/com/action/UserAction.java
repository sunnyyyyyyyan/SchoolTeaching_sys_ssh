package com.action;

import com.opensymphony.xwork2.ActionContext;
import com.po.User;
import com.service.UserService;

public class UserAction {
    private String userId;
	private String username;
	private String password;
	private String password1;
    private String userType;
    private String phone;
    private String email;
	
	private UserService userService;

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public UserService getUserService() {
		return userService;
	}

	public void setUserService(UserService userService) {
		this.userService = userService;
	}

	
	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getPassword1() {
		return password1;
	}

	public void setPassword1(String password1) {
		this.password1 = password1;
	}

    public String getUserType() {
        return userType;
    }

    public void setUserType(String userType) {
        this.userType = userType;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    //登录
    public String login() {
		if (this.getUserId() == null || this.getUserId().equals("")
				|| this.getPassword() == null || this.getPassword().equals("")) {
			ActionContext.getContext().put("mess", "不能为空");
			return "loginError";
		}
		User user = new User();
		user.setUserId(this.userId);
		user.setPassword(this.password);
		String strMess = this.userService.loginService(user);
		if (strMess.equals("loginSuccess")) {
			ActionContext.getContext().getSession().put("userId",user.getUserId());
			return "loginSuccess";
		}
		return "loginError";
	}

	//退出
	public String exit(){
		ActionContext.getContext().getSession().remove("userId");
		return "exitSuccess";
	}

	//添加
	public String addUser(){
		
		if (this.getUserId() == null || this.getUserId().equals("")||
				this.getUsername() == null || this.getUsername().equals("")
				|| this.getPassword() == null || this.getPassword().equals("")
				){
			ActionContext.getContext().put("addMess", "*不能为空！");
			return "addError";
		}
		User user = new User();
		user.setUserId(this.userId);
		user.setUsername(this.username);
		user.setPassword(this.password);
		user.setUserType(this.userType);
		user.setPhone(this.phone);
		user.setEmail(this.email);
		String strMess = this.userService.addService(user);
		if (strMess.equals("addSuccess")) {
			return "addSuccess";
		}
		return "addError";
	}


}
