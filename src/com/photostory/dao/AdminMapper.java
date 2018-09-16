package com.photostory.dao;

import java.util.HashMap;

import com.photostory.entity.Admin;

/**
 * 管理员CURD操作对应接口
 * @author Administrator
 * @time 2018年9月16日20:45:52
 * @vision 1.0
 */
public interface AdminMapper {
	public Admin getAdmin(HashMap<String, String> map);
}
