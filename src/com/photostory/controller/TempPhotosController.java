package com.photostory.controller;

import java.util.ArrayList;
import java.util.HashMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import com.photostory.entity.Tphotos;
import com.photostory.entity.User;
import com.photostory.service.TempPhotosService;

/**
 * @author zuo
 * @time 2018��9��14��08:45:52
 * @vision 1.0
 * ������ʱͼƬ��Controller
 */

@Controller
public class TempPhotosController {
	@Autowired
	private TempPhotosService tempPhotosService;      //ע��Service�ӿڶ���
	
	/**
	 * @param 
	 * @return String ��ҳ·�����������
	 * �����̨ͼƬ��������ҳ
	 */
	@RequestMapping(value="/dealwithPhotos")
	public String getHomePage(@ModelAttribute("User") User user,Model model) {
		//model.addAttribute("",); 
		ArrayList<Tphotos> list = tempPhotosService.getTphotos();
		model.addAttribute("list",list);
		return "/HomePage2";
	}
	
}






