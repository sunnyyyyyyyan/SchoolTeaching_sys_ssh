package com.po;

public class Online {
	private Integer id;
	private String username;
	private String textname;
	private String title;
	private String message;
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
	
	public Online() {
		super();
	}
	public Online(Integer id, String username, String textname, String title,
			String message) {
		super();
		this.id = id;
		this.username = username;
		this.textname = textname;
		this.title = title;
		this.message = message;
	}
	
}
