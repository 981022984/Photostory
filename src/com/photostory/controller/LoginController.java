package com.photostory.controller;



import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import com.photostory.entity.User;
import com.photostory.service.LoginService;


/**
 * ���ܣ�ʵ�ֵ�¼���ֵĿ�����
 * @author zuo
 * @time 2018��9��11��16:28:10
 * @vision 1.0
 */
@Controller
public class LoginController {
	@Autowired
	private LoginService loginService;
	

	/**
	 * ��ʼ������գ����ص�¼���棨���ز���·������ȫ·��Ҫ�������ļ������õ���
	 * @param model
	 * @return String
	 */
	@RequestMapping(value = "/firstLogin")
	public String loginFirst(Model model) {
		model.addAttribute("User", new User());
		return "/login";
	}
	
	/**
	 * @param user
	 * @return String
	 * ��¼��������¼�ɹ��򷵻ش������
	 */
	@RequestMapping(value = "/validateLogin")
	public String validateLogin(@ModelAttribute("User") User user,Model model,HttpSession session) {
		user = loginService.validateLogin(user.getUserID(), user.getUserPassword());
		if(user != null) {
			//��¼�ɹ�
			session.setAttribute(user.getUserID(), user);      //�����ѵ�¼���û���ID
			model.addAttribute("User",user);
			return "redirect:dealwithPhotos?userID="+user.getUserID();
		}	
		else {
			System.out.println("δ�ҵ�");
			return "";
		}		
	}
	
	
	
}







