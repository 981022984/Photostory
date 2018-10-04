package com.photostory.service;

import com.photostory.entity.User;

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
	User validateLogin(String userID, String userPassword);
}
