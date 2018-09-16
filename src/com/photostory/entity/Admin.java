package com.photostory.entity;

/**
 * 管理员实体
 * @author Administrator
 * @time 2018年9月16日19:23:37
 * @vision 1.0
 */
public class Admin {
	private String adminID;
	private String adminPassword;
	
	public Admin() {
		
	}

	public String getAdminID() {
		return adminID;
	}

	public void setAdminID(String adminID) {
		this.adminID = adminID;
	}

	public String getAdminPassword() {
		return adminPassword;
	}

	public void setAdminPassword(String adminPassword) {
		this.adminPassword = adminPassword;
	}
	
}
