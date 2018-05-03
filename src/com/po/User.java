package com.po;

public class User {
	private Integer id;
	private String userId;
	private String username;
	private String password;
	private String userType;
	private String phone;
	private String email;

	private String subjectNo;
	private String subjectName;

	public User() {
	}

	public User(String userId, String username, String subjectNo, String subjectName) {
		this.userId = userId;
		this.username = username;
		this.subjectNo = subjectNo;
		this.subjectName = subjectName;
	}

	public String getSubjectName() {
		return subjectName;
	}

	public void setSubjectName(String subjectName) {
		this.subjectName = subjectName;
	}

	public String getSubjectNo() {
		return subjectNo;
	}

	public void setSubjectNo(String subjectNo) {
		this.subjectNo = subjectNo;
	}

	public Integer getId() {
		return id;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
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
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
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

    @Override
    public String toString() {
        return "User [id=" + id + ", userId=" + userId + ", username=" + username + ", password=" + password
                + ", userType=" + userType + ", phone=" + phone + ", email=" + email + "]";
    }
}
