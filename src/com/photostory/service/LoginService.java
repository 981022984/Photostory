package com.photostory.service;


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
	boolean validateLogin(String userID, String userPassword);
}
