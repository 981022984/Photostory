package com.photostory.service;

import java.util.ArrayList;

import com.photostory.entity.Photos;

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
}
