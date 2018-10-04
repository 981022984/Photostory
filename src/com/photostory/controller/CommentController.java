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
 * ͼƬ�������Controller
 * @author zuo
 * @time 2018��10��3��08:46:58
 * @version 1.0
 */
@Controller
public class CommentController {
	@Autowired
	private UserInfoService userInfoService;
	
	@Autowired
	private PhotosService photosService;
	
	/**
	 * @param request    ��ȡ�û�ѡȡ�鿴��ͼƬ���
	 * @param session    ��ȡ��¼�û�
	 * @param model      ��ǰ�����Model
	 * @return   		 ������ͼView
	 */
	@RequestMapping(value="/comment")
	public String toComment(HttpServletRequest request, HttpSession session, Model model) {
		String pno = request.getParameter("pno");
		String userID = request.getParameter("userID");      //Ҫ�ύ���۵��û���ID
		Photos photo = userInfoService.getPhoto(pno);
		User user1 = userInfoService.getUser(photo.getUserID());    //�ϴ�ͼƬ���û�
		User user2 = userInfoService.getUser(userID);               //Ҫ�ύ���۵��û�
		ArrayList<Commend> commends = userInfoService.getCommends(pno);
		model.addAttribute("user1",user1);                 //�ϴ�ͼƬ���û�
		model.addAttribute("user2",user2);                 //Ҫ�ύ���۵��û�
		model.addAttribute("photo",photo);
		model.addAttribute("commends",commends);
		return "Comment";
	}
	
	@RequestMapping(value="/submitComment",produces="text/html;charset=utf-8")
	@ResponseBody
	public String submitComment(HttpServletRequest request, HttpSession session) {
		String userID = request.getParameter("userID");   	//�����û���ID
		String pno = request.getParameter("pno");	      	//�����۵�ͼƬ
		String comm = request.getParameter("commend");    	//������Ϣ
		String pcomment = request.getParameter("pcomment"); //��ȡ��ǰ������
		Date d = new Date();		                     	//�����ϴ�ʱ��
		Timestamp timeStamep = new Timestamp(d.getTime());
		Commend commend = new Commend(pno, userID, timeStamep, comm);     
		userInfoService.addCommend(commend);       //���۳־û�
		photosService.addGoodPhoto(pcomment, pno); //������+1
		
		return "���۳ɹ���";
	}
}




