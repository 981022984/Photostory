package com.photostory.service;

import java.util.HashMap;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.photostory.dao.userMapperCURD;
import com.photostory.entity.User;

@Service
public class LoginServiceImpl implements LoginService{

	/* 
	 * 重写接口的登录验证方法
	 */
	@Resource(name="userCURD")
	private userMapperCURD userCURD;
	
	@Override
	public boolean validateLogin(String userID, String userPassword) {
		User user;
		HashMap<String, Object>map = new HashMap<String, Object>();
		map.put("userID",userID);
		map.put("userPassword",userPassword);
		user = userCURD.selectUser(map);
		if(user==null)
			return false;
		else 
			return true;
	}
	
}
