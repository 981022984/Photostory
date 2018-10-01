package com.photostory.service;

/**
 * 用户注册接口
 * @author zuo
 * @time 2018年9月29日20:24:35
 * @version 1.0
 */
public interface RegisterService {
	
	
	/**
	 * @param userID 用户名
	 * @param password1 密码
	 * @param password2 确认密码
	 */
	public String addUser(String userID, String password1, String password2);
}
