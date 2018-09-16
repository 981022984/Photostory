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
	
	public User() {
		
	}
	
	public User(String userID, String userPassword, String userName) {
		this.userID = userID;
		this.userPassword = userPassword;
		this.userName = userName;
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
