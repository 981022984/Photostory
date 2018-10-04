package com.photostory.dao;

import java.util.HashMap;

import org.apache.ibatis.annotations.Param;

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
	 * @param hashmap ��ѯ�û����˺�����
	 * @return User ���ҵ����û� 
	 */
	public User selectUser(HashMap<String, Object> hashmap);
	
	/**
	 * �����û�ID�Ƿ��Ѿ�����
	 * @param userID
	 * @return ��¼����
	 */
	public int selectUserID(String userID);
	
	/**
	 * �û�ע��
	 * @param userID �û���
	 * @param userPassword ����
	 * @return �����¼������
	 */
	public int addNewUser(@Param("userID")String userID, @Param("userPassword")String userPassword);
	
	/**
	 * �޸�����
	 * @param newPassword ������
	 * @param userID  Ҫ�޸�������û�ID
	 * @return ���µļ�¼����
	 */
	public int updatePassword(@Param("newPassword") String newPassword, @Param("userID")String userID);
	
	
	/**
	 * �޸��û���
	 * @param userID          Ҫ�޸��û������û���ID
	 * @param newUserName     �µ��û���
	 * @return                ���¼�¼��
	 */
	public int updateUserName(@Param("userID")String userID, @Param("newUserName")String newUserName);
	
	
	/**
	 * �����µ��û���Ϣ
	 * @param userID  Ҫ�����û���ID
	 * @return ���ҵ����µ��û���Ϣ
	 */
	public User getUser(String userID);
}














