package com.photostory.service;

import java.util.ArrayList;

import com.photostory.entity.Page;
import com.photostory.entity.Photos;

/**
 * 图片处理service接口
 * @author zuo
 * @time 2018年9月20日20:19:49
 * @vision 1.0
 */
public interface PhotosService {
	/**
	 * 获取所有图片并缓存 
	 */
	public void getAllPhotos();
	
	
	/**
	 * @param page 页的配置
	 * @return 一页中的的图片
	 */
	public ArrayList<Photos> getPhotos(Page page);
	
	
	/**
	 * @return int 所有图片总数
	 */
	public int getAllPhotosCount();
}
