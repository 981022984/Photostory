package com.photostory.service;

import java.util.ArrayList;

import com.photostory.entity.Photos;

/**
 * 用户信息操作Service
 * @author zuo
 * @time 2018年9月30日22:21:12
 * @version 1.0
 */
public interface UserInfoService {
	/**
	 * 获取用户上传的图片
	 * @param userID 登录用户的ID
	 * @return 该用户上传的图片 
	 */
	public ArrayList<Photos> getUserPhotos(String userID);
}
