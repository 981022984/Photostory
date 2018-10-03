package com.photostory.controller;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.photostory.entity.Commend;
import com.photostory.entity.Photos;
import com.photostory.service.UserInfoService;

/**
 * 图片评论相关Controller
 * @author zuo
 * @time 2018年10月3日08:46:58
 * @version 1.0
 */
@Controller
public class CommentController {
	@Autowired
	private UserInfoService userInfoService;
	
	
	/**
	 * @param request    获取用户选取查看的图片编号
	 * @param session    获取登录用户
	 * @param model      向前端添加Model
	 * @return   		 返回视图View
	 */
	@RequestMapping(value="/comment")
	public String toComment(HttpServletRequest request, HttpSession session, Model model) {
		String pno = request.getParameter("pno");
		Photos photo = userInfoService.getPhoto(pno);
		ArrayList<Commend> commends = userInfoService.getCommends(pno);
		model.addAttribute("photo",photo);
		model.addAttribute("commends",commends);
		return "Comment";
	}
	
	@RequestMapping(value="/submitComment")
	@ResponseBody
	public String submitComment(HttpServletRequest request, HttpSession session) {
		String comm = request.getParameter("commend");
		Date d = new Date();		                     //图片上传时间
		Timestamp timeStamep = new Timestamp(d.getTime());
		Commend commend = new Commend("10004", "1415242", timeStamep, comm);     //模拟一条评论信息
		userInfoService.addCommend(commend);
		return "12";
	}
}




