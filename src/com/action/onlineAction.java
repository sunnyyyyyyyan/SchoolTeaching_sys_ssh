package com.action;

import java.util.List;

import com.opensymphony.xwork2.ActionContext;
import com.po.Online;
import com.service.onlineService;

public class onlineAction {
	private Integer id;
	private String username;
	private String textname;
	private String title;
	private String message;
	private onlineService onlineService;
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getTextname() {
		return textname;
	}
	public void setTextname(String textname) {
		this.textname = textname;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public onlineService getOnlineService() {
		return onlineService;
	}
	public void setOnlineService(onlineService onlineService) {
		this.onlineService = onlineService;
	}
	
	public String online(){
		String username=(String)ActionContext.getContext().getSession().get("username");
		if(username==null){ //没有登录
			ActionContext.getContext().put("online", "请先登录");					
			return "login";
		}
		
		if(textname==null||textname.equals("")||
				title==null||title.equals("")||
				message==null||message.equals("")){
			ActionContext.getContext().put("online", "不能为空！");
			return "error";
		}
		
		Online online=new Online();
		online.setId(id);
		online.setUsername(username);
		online.setTextname(textname);
		online.setTitle(title);
		online.setMessage(message);
		
		String Mess=this.onlineService.onlineText(online);
		if(Mess.equals("success")){
			ActionContext.getContext().put("online", Mess);
			return "online";
		}
		return "error";
	}
	
	public String getOnlineByName(){
		String username=(String)ActionContext.getContext().getSession().get("username");
		System.out.println(username);
		if(username==null){ //没有登录
			ActionContext.getContext().put("online", "请先登录");					
			return "login";
		}
		List<Online> list=this.onlineService.getOnline(username);
		ActionContext.getContext().put("getOnline", list);
		return "getOnline";
	}
}
