package com.photostory.entity;

/**
 * 用户实体
 * @author zuo
 * @time 2018年9月11日16:54:09
 * @vision 1.0
 */
public class User {
	private String userID;
	private String userPassword;
	private String userName;
	private String password2;     //注册时确认密码，修改密码时的新密码
	
	public User() {
		
	}
	
	public User(String userID, String userPassword, String userName) {
		this.userID = userID;
		this.userPassword = userPassword;
		this.userName = userName;
	}

	public String getPassword2() {
		return password2;
	}

	public void setPassword2(String password2) {
		this.password2 = password2;
	}

	public String getUserID() {
		return userID;
	}

	public void setUserID(String userID) {
		this.userID = userID;
	}

	public String getUserPassword() {
		return userPassword;
	}

	public void setUserPassword(String userPassword) {
		this.userPassword = userPassword;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}
	
	
}
