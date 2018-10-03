package com.photostory.dao;


import java.util.ArrayList;

import org.apache.ibatis.annotations.Param;

import com.photostory.entity.Page;
import com.photostory.entity.Photos;


/**
 * ��ͼƬ��CURD
 * @author zuo
 * @time 2018��9��20��15:40:14
 * @vision 1.0
 */
public interface PhotosDao {
	/**
	 * ��ѯ���е�ͼƬ��������512�� 
	 */
	public int getAllPhotos();
	
	
	/** 
	 * ��ѯ�ض�ҳ��ͼƬ
	 * @param page ҳ����Ϣ
	 * @return ArrayList<Photos> ÿҳ����ͼƬ
	 */
	public ArrayList<Photos> getPhotos(Page page);
	
	
	/**
	 * �û����ޣ���and���� ����+1
	 * @param pno
	 * @return ��Ӱ���¼����
	 */
	public int goodPhoto(@Param("pcomment")String pcomment ,@Param("pno")String pno);
	
	/**
	 * ��ȡĳһ���û��ϴ���ͼƬ
	 * @param userID �û�ID
	 * @return ��ID�û��ϴ���ͼƬ
	 */
	public ArrayList<Photos> getUserPhotos(String userID);
	
	/**
	 * @param pno Ҫ��ȡ��ͼƬ�ı��
	 * @return    Ҫ��ȡ��ͼƬ
	 */
	public Photos getPhoto(String pno);
}












