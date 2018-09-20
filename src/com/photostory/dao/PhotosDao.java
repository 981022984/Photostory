package com.photostory.dao;


import com.photostory.entity.Page;


/**
 * ��ͼƬ��CURD
 * @author zuo
 * @time 2018��9��20��15:40:14
 * @vision 1.0
 */
public interface PhotosDao {
	/**
	 * ��ѯ���е�ͼƬ��������12�� 
	 */
	public void getAllPhotos();
	
	
	/** 
	 * ��ѯ�ض�ҳ��ͼƬ
	 * @param page ҳ����Ϣ
	 * @return ArrayList<Photos> ÿҳ����ͼƬ
	 */
	public void getPhotos(Page page);
}












