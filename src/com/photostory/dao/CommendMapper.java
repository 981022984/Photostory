package com.photostory.dao;

import java.util.ArrayList;

import com.photostory.entity.Commend;

/**
 * 评论CURD操作对应的映射接口
 * @author zuo
 * @time 2018年9月17日11:24:37
 * @vision 1.0
 */
public interface CommendMapper {
	
	/**
	 * @param pno
	 * @return 图片所有评论集合
	 */
	public ArrayList<Commend> getCommends(String pno);
}
