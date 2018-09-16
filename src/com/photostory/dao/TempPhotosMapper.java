package com.photostory.dao;

import java.util.ArrayList;

import com.photostory.entity.Tphotos;

/**
 * @author zuo
 * @time 2018年9月13日22:47:46
 * @vision 1.0
 * 临时图片CURD的对应接口
 */
public interface TempPhotosMapper {
	/**
	 * 获取所有临时图片的所有信息
	 * @return 所有临时图片
	 */
	public ArrayList<Tphotos> getAllTempPhotos();
	
	
	/**
	 * 获取所有临时图片部分
	 * @return 所有临时图片
	 */
	public ArrayList<Tphotos> getAllTempPhotos2();
}
