package com.photostory.dao;

import java.util.ArrayList;

import com.photostory.entity.Tphotos;

/**
 * @author zuo
 * @time 2018��9��13��22:47:46
 * @vision 1.0
 * ��ʱͼƬCURD�Ķ�Ӧ�ӿ�
 */
public interface TempPhotosDao {
	/**
	 * ��ȡ������ʱͼƬ��������Ϣ
	 * @return ������ʱͼƬ
	 */
	public ArrayList<Tphotos> getAllTempPhotos();
	
	
	/**
	 * ��ȡ������ʱͼƬ����
	 * @return ������ʱͼƬ
	 */
	public ArrayList<Tphotos> getAllTempPhotos2();
	
	
	/**
	 * ��ѯ���һ��ͼƬ���
	 * @return  ͼƬ���
	 */
	public String getLastPno();
	
	/**
	 * �û��ϴ������ͼƬ
	 * @param tp  ��ʱͼƬ
	 * @return  �����¼����
	 */
	public void uploadPhotos(Tphotos tp);
}
