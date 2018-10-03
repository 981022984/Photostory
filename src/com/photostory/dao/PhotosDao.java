package com.photostory.dao;


import java.util.ArrayList;

import org.apache.ibatis.annotations.Param;

import com.photostory.entity.Page;
import com.photostory.entity.Photos;


/**
 * 对图片的CURD
 * @author zuo
 * @time 2018年9月20日15:40:14
 * @vision 1.0
 */
public interface PhotosDao {
	/**
	 * 查询所有的图片，并缓存512张 
	 */
	public int getAllPhotos();
	
	
	/** 
	 * 查询特定页的图片
	 * @param page 页的信息
	 * @return ArrayList<Photos> 每页所有图片
	 */
	public ArrayList<Photos> getPhotos(Page page);
	
	
	/**
	 * 用户点赞，赞and评论 总数+1
	 * @param pno
	 * @return 受影响记录条数
	 */
	public int goodPhoto(@Param("pcomment")String pcomment ,@Param("pno")String pno);
	
	/**
	 * 获取某一个用户上传的图片
	 * @param userID 用户ID
	 * @return 该ID用户上传的图片
	 */
	public ArrayList<Photos> getUserPhotos(String userID);
	
	/**
	 * @param pno 要获取的图片的编号
	 * @return    要获取的图片
	 */
	public Photos getPhoto(String pno);
}












