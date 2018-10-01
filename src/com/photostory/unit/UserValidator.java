package com.photostory.unit;

import org.springframework.stereotype.Repository;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import com.photostory.entity.User;

import org.springframework.validation.ValidationUtils;




/**
 * 校验器，校验用户注册时的输入信息是否合法（只实现了注册部分的校验）
 * @author zuo
 * @time 2018年9月30日09:50:26
 * @version 1.0
 */
@Repository("UserValidator")
public class UserValidator implements Validator{
	
	@Override
	public boolean supports(Class<?> clazz) {
		//User是否与指定clazz类相同，或者其中一个为另一个的子类或接口实现
		return User.class.isAssignableFrom(clazz);
	}
	
	@Override
	public void validate(Object targe,Errors errors) {
		//ValidationUtils.rejectIfEmpty(errors, "userID", null, "*用户名不能为空");
		//ValidationUtils.rejectIfEmpty(errors, "userPassword", null, "*密码不能为空");
		
		User user = (User)targe;
		char[] userID = user.getUserID().toCharArray();
		if(user.getUserID().length() < 6) {
			errors.rejectValue("userID", null, "用户名最少6位");
		}
		else if(user.getUserID().length() > 16) {
			errors.rejectValue("userID", null, "用户名最多16位");
		}
		else{
			for(char c:userID) {    
				if((c>'A' && c<'Z') || (c>'a' && c<'z') || (c>'0' && c<'9'))   //用户名为数字或字符
					continue;
				else {
					errors.rejectValue("userID", null, "只能为数字、字母");break;
				}	
			}
		}
		if(user.getUserPassword().length() < 6) {
			errors.rejectValue("userPassword", null, "密码最少6位");
		}
		else if(user.getUserPassword().length() > 47){
			errors.rejectValue("userPassword", null, "密码最多47位");
		} 
		else if(!user.getPassword2().equals(user.getUserPassword())){  //前后密码不相等
			errors.rejectValue("userPassword", null, "前后密码不一致");
		}
	}
}





