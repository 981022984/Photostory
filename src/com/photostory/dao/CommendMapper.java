package com.photostory.dao;

import java.util.ArrayList;

import com.photostory.entity.Commend;

/**
 * ����CURD������Ӧ��ӳ��ӿ�
 * @author zuo
 * @time 2018��9��17��11:24:37
 * @vision 1.0
 */
public interface CommendMapper {
	
	/**
	 * @param pno
	 * @return ͼƬ�������ۼ���
	 */
	public ArrayList<Commend> getCommends(String pno);
}
