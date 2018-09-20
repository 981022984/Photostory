package com.photostory.dao;

import java.util.ArrayList;

import com.photostory.entity.Page;
import com.photostory.entity.Photos;

/**
 * ��ͼƬ��CURD
 * @author zuo
 * @time 2018��9��20��15:40:14
 * @vision 1.0
 */
public interface PhotosMapper {
	/**
	 * ��ѯ���е�ͼƬ��������12�� 
	 */
	public void getAllPhotos();
	
	
	/** 
	 * ��ѯ�ض�ҳ��ͼƬ
	 * @param page ҳ����Ϣ
	 * @return ArrayList<Photos> ÿҳ����ͼƬ
	 */
	public ArrayList<Photos> getPhotos(Page page);
}












