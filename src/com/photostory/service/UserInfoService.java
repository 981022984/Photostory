package com.photostory.service;

import java.io.IOException;
import java.util.ArrayList;

import org.springframework.web.multipart.commons.CommonsMultipartFile;

import com.photostory.entity.Commend;
import com.photostory.entity.Photos;
import com.photostory.entity.Tphotos;

/**
 * �û���Ϣ����Service
 * @author zuo
 * @time 2018��9��30��22:21:12
 * @version 1.0
 */
public interface UserInfoService {
	/**
	 * ��ȡ�û��ϴ���ͼƬ
	 * @param userID ��¼�û���ID
	 * @return ���û��ϴ���ͼƬ 
	 */
	public ArrayList<Photos> getUserPhotos(String userID);
	
	/**
	 * @param userID            �޸������û�ID
	 * @param oldPassword 		������
	 * @param newPassword1		������
	 * @param newPassword2		ȷ������
	 * @return                  �Ƿ���³ɹ�
	 */
	public String updatePassword(String userID, String oldPassword, String newPassword1, String newPassword2);
	
	/**
	 * �޸��û���
	 * @param userID          Ҫ�޸��û������û���ID
	 * @param newUserName     �µ��û���
	 * @return                �޸��Ƿ�ɹ�
	 */
	public boolean updateUserName(String userID, String newUserName);
	
	
	
	
	/**
	 * ���ϴ�ͼƬ·�������ƽ��д���
	 * @param file           ������ļ�
	 * @param realUploadPath ·��
	 * @return               �ļ��������ݿ�洢·��
	 * @throws IOException
	 */
	public ArrayList<String> uploadImage(CommonsMultipartFile file,String realUploadPath)throws IOException;

	
	/**
	 * @param tp  Ҫ�ϴ�����ʱ�ļ�����
	 */
	public void insertPhotos(Tphotos tp);
	
	
	/**
	 * ��ȡ��ӦͼƬ
	 * @param pno  Ҫ��ȡͼƬ�ı��
 	 * @return     Ҫ��ȡͼƬ
	 */
	public Photos getPhoto(String pno);
	
	
	/**
	 * ��ȡ��ӦͼƬ����������
	 * @param pno	Ҫ��ȡͼƬ���۵�ͼƬ�ı��
	 * @return		Ҫ��ȡ�����ۼ���
	 */
	public ArrayList<Commend> getCommends(String pno);
	
	
	/**
	 * @param commend  Ҫ�����������Ϣ
	 */
	public void addCommend(Commend commend);
}








