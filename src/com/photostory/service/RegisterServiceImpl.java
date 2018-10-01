package com.photostory.service;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.photostory.dao.UserDao;

/**
 * �û�ע���Service
 * @author zuo
 * @time 2018��9��29��20:37:54
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
			return "��Ϣ��ȫ��";
		else if(userCURD.selectUserID(userID)==1)
			return "�û����Ѵ��ڣ�";
		else if(!password1.equals(password2)) {
			System.out.println(password1);
			System.out.println(password2);
			return "ǰ�����벻һ�£�";
		}	
		else {
			userCURD.addNewUser(userID, password1);
			return "ע��ɹ���������ҳ";
		}
	}
}
