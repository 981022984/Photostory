package com.photostory.service;

import java.util.ArrayList;

import com.photostory.entity.Page;
import com.photostory.entity.Photos;

/**
 * ͼƬ����service�ӿ�
 * @author zuo
 * @time 2018��9��20��20:19:49
 * @vision 1.0
 */
public interface PhotosService {
	/**
	 * ��ȡ����ͼƬ������ 
	 */
	public void getAllPhotos();
	
	
	/**
	 * @param page ҳ������
	 * @return һҳ�еĵ�ͼƬ
	 */
	public ArrayList<Photos> getPhotos(Page page);
	
	
	/**
	 * @return int ����ͼƬ����
	 */
	public int getAllPhotosCount();
}
