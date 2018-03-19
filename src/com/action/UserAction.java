package com.action;

import com.opensymphony.xwork2.ActionContext;
import com.po.User;
import com.service.UserService;

public class UserAction {
	// �����û��ύ������
	private String username;
	private String password;
	private String password1;
	private String sex;
	private String[] interest;
	
	// ����ע��Ķ���
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

	// ʵ�ֵ�¼����
	public String login() {
		// ��֤����:1)��
		if (this.getUsername() == null || this.getUsername().equals("")
				|| this.getPassword() == null || this.getPassword().equals("")) {
			ActionContext.getContext().put("mess", "����Ϊ�գ�");
			return "loginError";
		}
		// ����User���󣬵���service���loginService�������ҵ����
		User user = new User();
		user.setUsername(this.username);
		user.setPassword(this.password);

		String strMess = this.userService.loginService(user);
		if (strMess.equals("loginSuccess")) {
			// ���û�������session
			ActionContext.getContext().getSession().put("username",user.getUsername());
			return "loginSuccess";
		}
		return "loginError";
	}
	
	
	//ע��
	public String reg(){
		
		// ��֤���ݣ�1����֤�գ�2�������Ƿ�һ�£�3���Ƿ��Ѿ�����
		if (this.getUsername() == null || this.getUsername().equals("")
				|| this.getPassword() == null || this.getPassword().equals("")
				|| this.getPassword1() == null || this.getPassword1().equals("")
				|| this.getSex() == null || this.getSex().equals("")
				|| this.getInterest() == null || this.getInterest().equals("")) {
			ActionContext.getContext().put("mess", "����Ϊ�գ�");
			return "regError";

		}
		if (!this.getPassword().equals(this.getPassword1())) {
			ActionContext.getContext().put("mess", "���벻һ�£�");
			return "regError";
		}
		
		String Interest = "";
		for (int i = 0; i < this.getInterest().length; i++) {
			Interest = Interest + this.getInterest()[i] + ",";
		}
		// ��Interest��Ϊ�գ�ȥĩβ������
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
	//ע��
	public String exit(){
		ActionContext.getContext().getSession().remove("username");
		return "exitSuccess";
	}

}
