package com.photostory.dao;

import java.util.HashMap;

import com.photostory.entity.Admin;

/**
 * ����ԱCURD������Ӧ�ӿ�
 * @author Administrator
 * @time 2018��9��16��20:45:52
 * @vision 1.0
 */
public interface AdminMapper {
	public Admin getAdmin(HashMap<String, String> map);
}
