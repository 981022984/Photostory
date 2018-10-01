package com.photostory.dao;

import java.util.HashMap;

import org.apache.ibatis.annotations.Param;

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
	 * @param hashmap 查询用户的账号密码
	 * @return User 查找到的用户 
	 */
	public User selectUser(HashMap<String, Object> hashmap);
	
	/**
	 * 查找用户ID是否已经存在
	 * @param userID
	 * @return 记录条数
	 */
	public int selectUserID(String userID);
	
	/**
	 * 用户注册
	 * @param userID 用户名
	 * @param userPassword 密码
	 * @return 插入记录的条数
	 */
	public int addNewUser(@Param("userID")String userID, @Param("userPassword")String userPassword);
}
