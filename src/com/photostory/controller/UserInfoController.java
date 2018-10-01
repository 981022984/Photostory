package com.photostory.controller;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.photostory.entity.Photos;
import com.photostory.service.UserInfoService;

/**
 * 用户信息操作控制器
 * @author zuo
 * @time 2018年9月30日17:08:52
 * @version 1.0
 */
@Controller
public class UserInfoController {
	@Autowired
	private UserInfoService userInfoService;
	
	@RequestMapping(value="/userInfo")
	public String userInfo(Model model) {
		ArrayList<Photos> list = userInfoService.getUserPhotos("1415241");
		model.addAttribute("list",list);
		return "UserInformations";
	}
}
