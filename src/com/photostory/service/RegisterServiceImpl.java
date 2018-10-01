package com.photostory.service;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.photostory.dao.UserDao;

/**
 * 用户注册的Service
 * @author zuo
 * @time 2018年9月29日20:37:54
 * @version 1.0
 */
@Service
public class RegisterServiceImpl implements RegisterService{
	@Resource
	private UserDao userCURD;

	/* (non-Javadoc)
	 * @see com.photostory.service.Register#addUser(java.lang.String, java.lang.String, java.lang.String)
	 */
	@Override
	public String addUser(String userID, String password1, String password2) {
		if(userID.equals("") || password1.equals("") || password2.equals(""))
			return "信息不全！";
		else if(userCURD.selectUserID(userID)==1)
			return "用户名已存在！";
		else if(!password1.equals(password2)) {
			System.out.println(password1);
			System.out.println(password2);
			return "前后密码不一致！";
		}	
		else {
			userCURD.addNewUser(userID, password1);
			return "注册成功，进入首页";
		}
	}
}
