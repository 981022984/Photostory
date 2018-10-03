package com.photostory.dao;

import java.util.ArrayList;

import com.photostory.entity.Commend;

/**
 * ����CURD������Ӧ��ӳ��ӿ�
 * @author zuo
 * @time 2018��9��17��11:24:37
 * @vision 1.0
 */
public interface CommendDao {
	
	/**
	 * @param pno   ͼƬ���
	 * @return ͼƬ�������ۼ���
	 */
	public ArrayList<Commend> getCommends(String pno);
	
	/**
	 * @param commend Ҫ�����������Ϣ
	 */
	public void addCommend(Commend commend);
}