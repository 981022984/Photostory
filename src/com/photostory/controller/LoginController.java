package com.photostory.controller;

import java.awt.image.BufferedImage;
import java.io.FileInputStream;
import java.io.IOException;

import javax.imageio.ImageIO;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import com.photostory.entity.User;
import com.photostory.service.LoginService;
import com.photostory.test.TestDealwithPhotos;
import com.photostory.unit.DealwithPhotos;

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
	 * @param model
	 * @return String
	 * 初始请求接收，返回登录界面（返回部分路径，完全路径要由配置文件解析得到）
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
	public String validateLogin(@ModelAttribute("User") User user,Model model) {
		if(loginService.validateLogin(user.getUserID(), user.getUserPassword())) {
			//登录成功
			/*try {
				BufferedImage bufferedImage = ImageIO.read(new FileInputStream("./p1.jpg"));   //从文件中读取图片
				model.addAttribute("image1",bufferedImage);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}*/
			model.addAttribute("User",user);
			return "redirect:dealwithPhotos";
		}	
		else {
			System.out.println("未找到");
			return "";
		}		
	}
	
	
	
}







