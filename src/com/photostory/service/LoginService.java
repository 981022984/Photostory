package com.photostory.service;


/**
 * 登录Service接口
 * @author zuo
 * @time 2018年9月11日17:04:51
 * @vision 1.0
 */
public interface LoginService {
	
	/**
	 * 验证登录
	 */
	boolean validateLogin(String userID, String userPassword);
}
