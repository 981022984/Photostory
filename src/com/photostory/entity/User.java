package com.photostory.entity;

/**
 * �û�ʵ��
 * @author zuo
 * @time 2018��9��11��16:54:09
 * @vision 1.0
 */
public class User {
	private String userID;
	private String userPassword;
	private String userName;
	private String password2;     //ע��ʱȷ�����룬�޸�����ʱ��������
	
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
