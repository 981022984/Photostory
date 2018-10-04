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
import com.photostory.entity.User;
import com.photostory.service.PhotosService;
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
	
	@Autowired
	private PhotosService photosService;
	
	/**
	 * @param request    获取用户选取查看的图片编号
	 * @param session    获取登录用户
	 * @param model      向前端添加Model
	 * @return   		 返回视图View
	 */
	@RequestMapping(value="/comment")
	public String toComment(HttpServletRequest request, HttpSession session, Model model) {
		String pno = request.getParameter("pno");
		String userID = request.getParameter("userID");      //要提交评论的用户的ID
		Photos photo = userInfoService.getPhoto(pno);
		User user1 = userInfoService.getUser(photo.getUserID());    //上传图片的用户
		User user2 = userInfoService.getUser(userID);               //要提交评论的用户
		ArrayList<Commend> commends = userInfoService.getCommends(pno);
		model.addAttribute("user1",user1);                 //上传图片的用户
		model.addAttribute("user2",user2);                 //要提交评论的用户
		model.addAttribute("photo",photo);
		model.addAttribute("commends",commends);
		return "Comment";
	}
	
	@RequestMapping(value="/submitComment",produces="text/html;charset=utf-8")
	@ResponseBody
	public String submitComment(HttpServletRequest request, HttpSession session) {
		String userID = request.getParameter("userID");   	//评论用户的ID
		String pno = request.getParameter("pno");	      	//被评论的图片
		String comm = request.getParameter("commend");    	//评论信息
		String pcomment = request.getParameter("pcomment"); //获取当前评赞数
		Date d = new Date();		                     	//评论上传时间
		Timestamp timeStamep = new Timestamp(d.getTime());
		Commend commend = new Commend(pno, userID, timeStamep, comm);     
		userInfoService.addCommend(commend);       //评论持久化
		photosService.addGoodPhoto(pcomment, pno); //评赞数+1
		
		return "评论成功！";
	}
}




