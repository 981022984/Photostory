package com.photostory.dao;

import java.util.HashMap;


import com.photostory.entity.User;

/**
 * userMapperӳ���ļ���CURD���Ķ�Ӧ�ӿ�
 * @author zuo
 * @time 2018��9��11��21:09:46
 * @vision 1.0
 */
public interface UserDao {
	
	
	/**
	 * ��֤��¼�û��Ƿ����
	 * @param hashmap
	 * @return User
	 */
	public User selectUser(HashMap<String, Object> hashmap);
}
