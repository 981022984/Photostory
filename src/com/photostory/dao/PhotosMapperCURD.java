package com.photostory.dao;

import java.util.ArrayList;

import javax.annotation.Resource;

import org.apache.ibatis.session.SqlSessionFactory;

import com.photostory.entity.Page;
import com.photostory.entity.Photos;

/**
 * ��ͼƬCURD������ʵ����
 * @author Administrator
 * @time 2018��9��20��15:45:19
 * @vision 1.0
 */
public class PhotosMapperCURD implements PhotosMapper{
	@Resource(name="sqlSessionFactory")
	private SqlSessionFactory sqlSessionFactory;
	
	/* (non-Javadoc)
	 * @see com.photostory.dao.PhotosMapper#getAllPhotos()
	 */
	@Override
	public void getAllPhotos() {
		
		
	}
	
	

	/* (non-Javadoc)
	 * @see com.photostory.dao.PhotosMapper#getPhotos(com.photostory.entity.Page)
	 */
	@Override
	public ArrayList<Photos> getPhotos(Page page) {
		
		return null;
	}
	
}
