package com.action;

import com.opensymphony.xwork2.ActionContext;
import com.po.User;
import com.service.UserService;

public class UserAction {
	private String username;
	private String password;
	private String password1;
    private String userType;
    private String phone;
    private String email;
	
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

    public String login() {
		if (this.getUsername() == null || this.getUsername().equals("")
				|| this.getPassword() == null || this.getPassword().equals("")) {
			ActionContext.getContext().put("mess", "不能为空");
			return "loginError";
		}
		User user = new User();
		user.setUsername(this.username);
		user.setPassword(this.password);
        user.setUserType(this.userType);
		String strMess = this.userService.loginService(user);
		if (strMess.equals("loginSuccess")) {
			ActionContext.getContext().getSession().put("username",user.getUsername());
			return "loginSuccess";
		}
		return "loginError";
	}
	
	
	public String register(){
		
		if (this.getUsername() == null || this.getUsername().equals("")
				|| this.getPassword() == null || this.getPassword().equals("")
				|| this.getPassword1() == null || this.getPassword1().equals("")
				) {
			ActionContext.getContext().put("mess", "不能为空");
			return "regError";

		}
		if (!this.getPassword().equals(this.getPassword1())) {
			ActionContext.getContext().put("mess", "两次密码不一致");
			return "regError";
		}

		User usr = new User();
		usr.setUsername(this.username);
		usr.setPassword(this.password);
		
		String strMess = this.userService.regService(usr);
		
		if (strMess.equals("regSuccess")) {
			return "regSuccess";
		}
		return "regError";
	}
	//退出
	public String exit(){
		ActionContext.getContext().getSession().remove("username");
		return "exitSuccess";
	}

}
