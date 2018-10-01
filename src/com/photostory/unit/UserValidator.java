package com.photostory.unit;

import org.springframework.stereotype.Repository;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import com.photostory.entity.User;

import org.springframework.validation.ValidationUtils;




/**
 * У������У���û�ע��ʱ��������Ϣ�Ƿ�Ϸ���ֻʵ����ע�Ჿ�ֵ�У�飩
 * @author zuo
 * @time 2018��9��30��09:50:26
 * @version 1.0
 */
@Repository("UserValidator")
public class UserValidator implements Validator{
	
	@Override
	public boolean supports(Class<?> clazz) {
		//User�Ƿ���ָ��clazz����ͬ����������һ��Ϊ��һ���������ӿ�ʵ��
		return User.class.isAssignableFrom(clazz);
	}
	
	@Override
	public void validate(Object targe,Errors errors) {
		//ValidationUtils.rejectIfEmpty(errors, "userID", null, "*�û�������Ϊ��");
		//ValidationUtils.rejectIfEmpty(errors, "userPassword", null, "*���벻��Ϊ��");
		
		User user = (User)targe;
		char[] userID = user.getUserID().toCharArray();
		if(user.getUserID().length() < 6) {
			errors.rejectValue("userID", null, "�û�������6λ");
		}
		else if(user.getUserID().length() > 16) {
			errors.rejectValue("userID", null, "�û������16λ");
		}
		else{
			for(char c:userID) {    
				if((c>'A' && c<'Z') || (c>'a' && c<'z') || (c>'0' && c<'9'))   //�û���Ϊ���ֻ��ַ�
					continue;
				else {
					errors.rejectValue("userID", null, "ֻ��Ϊ���֡���ĸ");break;
				}	
			}
		}
		if(user.getUserPassword().length() < 6) {
			errors.rejectValue("userPassword", null, "��������6λ");
		}
		else if(user.getUserPassword().length() > 47){
			errors.rejectValue("userPassword", null, "�������47λ");
		} 
		else if(!user.getPassword2().equals(user.getUserPassword())){  //ǰ�����벻���
			errors.rejectValue("userPassword", null, "ǰ�����벻һ��");
		}
	}
}





