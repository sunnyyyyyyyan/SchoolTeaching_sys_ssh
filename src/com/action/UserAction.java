package com.action;

import com.opensymphony.xwork2.ActionContext;
import com.po.User;
import com.service.UserService;

public class UserAction {
	// 接收用户提交的数据
	private String username;
	private String password;
	private String password1;
	private String sex;
	private String[] interest;
	
	// 接收注入的对象
	private UserService userService;

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

	public String getSex() {
		return sex;
	}

	public void setSex(String sex) {
		this.sex = sex;
	}

	public String[] getInterest() {
		return interest;
	}

	public void setInterest(String[] interest) {
		this.interest = interest;
	}

	// 实现登录功能
	public String login() {
		// 验证数据:1)空
		if (this.getUsername() == null || this.getUsername().equals("")
				|| this.getPassword() == null || this.getPassword().equals("")) {
			ActionContext.getContext().put("mess", "不能为空！");
			return "loginError";
		}
		// 创建User对象，调用service层的loginService方法完成业务处理
		User user = new User();
		user.setUsername(this.username);
		user.setPassword(this.password);

		String strMess = this.userService.loginService(user);
		if (strMess.equals("loginSuccess")) {
			// 将用户名存入session
			ActionContext.getContext().getSession().put("username",user.getUsername());
			return "loginSuccess";
		}
		return "loginError";
	}
	
	
	//注册
	public String reg(){
		
		// 验证数据：1）验证空；2）密码是否一致；3）是否已经存在
		if (this.getUsername() == null || this.getUsername().equals("")
				|| this.getPassword() == null || this.getPassword().equals("")
				|| this.getPassword1() == null || this.getPassword1().equals("")
				|| this.getSex() == null || this.getSex().equals("")
				|| this.getInterest() == null || this.getInterest().equals("")) {
			ActionContext.getContext().put("mess", "不能为空！");
			return "regError";

		}
		if (!this.getPassword().equals(this.getPassword1())) {
			ActionContext.getContext().put("mess", "密码不一致！");
			return "regError";
		}
		
		String Interest = "";
		for (int i = 0; i < this.getInterest().length; i++) {
			Interest = Interest + this.getInterest()[i] + ",";
		}
		// 若Interest不为空，去末尾“，”
		if (!Interest.equals("")) {
			Interest = Interest.substring(0, Interest.length() - 1);
		}

		User usr = new User();
		usr.setUsername(this.username);
		usr.setPassword(this.password);
		usr.setSex(this.sex);
		usr.setInterest(Interest);
		
		String strMess = this.userService.regService(usr);
		
		if (strMess.equals("regSuccess")) {
			return "regSuccess";
		}
		return "regError";
	}
	//注销
	public String exit(){
		ActionContext.getContext().getSession().remove("username");
		return "exitSuccess";
	}

}
