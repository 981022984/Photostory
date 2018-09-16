package com.photostory.service;

import java.util.ArrayList;
import java.util.HashMap;

import com.photostory.entity.Tphotos;

/**
 * @author zuo
 * @time 2018年9月14日08:22:50
 * @vision 1.0
 * 临时图片处理Service接口
 */
public interface TempPhotosService {
	/**
	 * @return HashMap<图片编号， 图片前端使用路径> hashMap
	 */
	public HashMap<String, String> getTempPhotos();
	
	/**
	 * @return 所有图片部分信息
	 */
	public ArrayList<Tphotos> getTphotos();
}
