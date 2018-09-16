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
	 * @param model
	 * @return String
	 * ��ʼ������գ����ص�¼���棨���ز���·������ȫ·��Ҫ�������ļ������õ���
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
	public String validateLogin(@ModelAttribute("User") User user,Model model) {
		if(loginService.validateLogin(user.getUserID(), user.getUserPassword())) {
			//��¼�ɹ�
			/*try {
				BufferedImage bufferedImage = ImageIO.read(new FileInputStream("./p1.jpg"));   //���ļ��ж�ȡͼƬ
				model.addAttribute("image1",bufferedImage);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}*/
			model.addAttribute("User",user);
			return "redirect:dealwithPhotos";
		}	
		else {
			System.out.println("δ�ҵ�");
			return "";
		}		
	}
	
	
	
}







