package com.photostory.dao;

import java.util.HashMap;


import com.photostory.entity.User;

/**
 * userMapper映射文件中CURD语句的对应接口
 * @author zuo
 * @time 2018年9月11日21:09:46
 * @vision 1.0
 */
public interface UserDao {
	
	
	/**
	 * 验证登录用户是否存在
	 * @param hashmap
	 * @return User
	 */
	public User selectUser(HashMap<String, Object> hashmap);
}
