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
	
	/**
	 * 修改密码
	 * @param newPassword 新密码
	 * @param userID  要修改密码的用户ID
	 * @return 更新的记录条数
	 */
	public int updatePassword(@Param("newPassword") String newPassword, @Param("userID")String userID);
	
	
	/**
	 * 修改用户名
	 * @param userID          要修改用户名的用户的ID
	 * @param newUserName     新的用户名
	 * @return                更新记录数
	 */
	public int updateUserName(@Param("userID")String userID, @Param("newUserName")String newUserName);
	
	
	/**
	 * 查找新的用户信息
	 * @param userID  要查找用户的ID
	 * @return 查找到的新的用户信息
	 */
	public User getUser(String userID);
}














