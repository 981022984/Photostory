package com.photostory.service;

import com.photostory.entity.User;

/**
 * ��¼Service�ӿ�
 * @author zuo
 * @time 2018��9��11��17:04:51
 * @vision 1.0
 */
public interface LoginService {
	
	/**
	 * ��֤��¼
	 */
	User validateLogin(String userID, String userPassword);
}
