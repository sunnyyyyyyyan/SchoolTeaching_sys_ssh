package com.action;

import com.opensymphony.xwork2.ActionContext;
import com.po.PageShow;
import com.po.User;
import com.service.UserService;

import java.util.List;

public class UserAction {
	private String id;
    private String userId;
	private String username;
	private String password;
	private String password1;
    private String userType;
    private String phone;
    private String email;

    private int pageNow=1;//当前页
    private int pageSize=15;//总条数
    private int totalPage;//总页数
	private UserService userService;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
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

	public int getPageNow() {
		return pageNow;
	}

	public void setPageNow(int pageNow) {
		this.pageNow = pageNow;
	}

	public int getPageSize() {
		return pageSize;
	}

	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}

	public int getTotalPage() {
		return totalPage;
	}

	public void setTotalPage(int totalPage) {
		this.totalPage = totalPage;
	}

	public UserService getUserService() {
		return userService;
	}

	public void setUserService(UserService userService) {
		this.userService = userService;
	}

	//登录
    public String login() {
		if (this.getUserId() == null || this.getUserId().equals("")) {
			ActionContext.getContext().put("loginMess", "编号不能为空！");
			return "loginError";
		}
		if (this.getPassword() == null || this.getPassword().equals("")){
			ActionContext.getContext().put("loginMess", "密码不能为空！");
			return "loginError";
		}
		if (this.getUserType()==null||this.getUserType().equals("")){
			ActionContext.getContext().put("loginMess", "身份请选择！");
			return "loginError";
		}
		User user = new User();
		user.setUserId(this.userId);
		user.setUserType(this.userType);
		user.setPassword(this.password);
		String strMess = this.userService.loginService(user);
		if (strMess.equals("loginSuccess")) {
			ActionContext.getContext().getSession().put("userId",user.getUserId());
			ActionContext.getContext().getSession().put("userType",user.getUserType());
			return "loginSuccess";
		}
		ActionContext.getContext().put("loginMess","编号或密码或身份不正确！");
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

	//用户列表
	public String showAllUser(){
        List<User> list = this.userService.getAllUserData(this.pageNow,this.pageSize);
        if (list.size()>0) {
			ActionContext.getContext().put("allUser", list);
			PageShow page=new PageShow(pageNow, this.userService.findAllUserSize(), pageSize);
			ActionContext.getContext().put("userPage", page);
			return "showAllUserSuccess";
		}
		return "showAllUserError";
    }

    //单条删除用户列表
	public String deleteUser(){
        String strMess = this.userService.deleteUser(this.userId);
        if (strMess.equals("deleteUserSuccess")){
            ActionContext.getContext().put("deleteUserMess","删除成功！");
            showAllUser();
            return "deleteUserSuccess";
        }
        ActionContext.getContext().put("deleteUserMess","删除失败！");
		return "deleteUserError";
	}

    //根据用户id获取个人信息
	public String getUserid(){
		System.out.println(this.userId);
		List<User> list = this.userService.getUserId(this.userId);
		ActionContext.getContext().put("user",list);
		return "getUserIdSuccess";
	}


    //修改用户信息
    public String updateUser(){

        if (this.getUsername()==null&&this.getUsername().equals("")&&
                this.getPassword()==null&&this.getPassword().equals("")&&
                this.getPhone()==null&&this.getPhone().equals("")&&
                this.getEmail()==null&&this.getEmail().equals("")){
            ActionContext.getContext().put("updateMess","无修改！");
            return "updateUserError";
        }
		if(password.equals(password1)==false){
			ActionContext.getContext().put("updateMess","两次密码输入不一致！");
			return "updateUserError";
		}
		User user = new User();
		user.setUsername(this.username);
		user.setPassword(this.password);
		user.setPhone(this.phone);
		user.setEmail(this.email);
		String strMess = this.userService.updateUser(user);
		if (strMess.equals("updateUserSuccess")) {
			ActionContext.getContext().put("updateMess","修改成功！");
			return "updateUserSuccess";
		}
		ActionContext.getContext().put("updateMess","修改失败！");
		return "updateUserError";
	}

}
