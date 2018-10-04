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
 * 功能：实现登录部分的控制器
 * @author zuo
 * @time 2018年9月11日16:28:10
 * @vision 1.0
 */
@Controller
public class LoginController {
	@Autowired
	private LoginService loginService;
	

	/**
	 * 初始请求接收，返回登录界面（返回部分路径，完全路径要由配置文件解析得到）
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
	 * 登录请求处理，登录成功则返回处理控制
	 */
	@RequestMapping(value = "/validateLogin")
	public String validateLogin(@ModelAttribute("User") User user,Model model,HttpSession session) {
		user = loginService.validateLogin(user.getUserID(), user.getUserPassword());
		if(user != null) {
			//登录成功
			session.setAttribute(user.getUserID(), user);      //保存已登录的用户的ID
			model.addAttribute("User",user);
			return "redirect:dealwithPhotos?userID="+user.getUserID();
		}	
		else {
			System.out.println("未找到");
			return "";
		}		
	}
	
	
	
}







