package com.photostory.service;

/**
 * �û�ע��ӿ�
 * @author zuo
 * @time 2018��9��29��20:24:35
 * @version 1.0
 */
public interface RegisterService {
	
	
	/**
	 * @param userID �û���
	 * @param password1 ����
	 * @param password2 ȷ������
	 */
	public String addUser(String userID, String password1, String password2);
}
