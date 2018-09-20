package com.photostory.dao;


import com.photostory.entity.Page;


/**
 * 对图片的CURD
 * @author zuo
 * @time 2018年9月20日15:40:14
 * @vision 1.0
 */
public interface PhotosDao {
	/**
	 * 查询所有的图片，并缓存12张 
	 */
	public void getAllPhotos();
	
	
	/** 
	 * 查询特定页的图片
	 * @param page 页的信息
	 * @return ArrayList<Photos> 每页所有图片
	 */
	public void getPhotos(Page page);
}












