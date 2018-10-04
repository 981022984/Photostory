package com.photostory.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.codehaus.jackson.map.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.commons.CommonsMultipartFile;

import com.photostory.entity.Photos;
import com.photostory.entity.Tphotos;
import com.photostory.entity.User;
import com.photostory.service.UserInfoService;

/**
 * �û���Ϣ����������
 * @author zuo
 * @time 2018��9��30��17:08:52
 * @version 1.0
 */
@Controller
public class UserInfoController {
	@Autowired
	private UserInfoService userInfoService;
	
	/**
	 * ��ת�û���Ϣ����
	 * @param model
	 * @return �û���Ϣ����
	 */
	@RequestMapping(value="/userInfo")
	public String userInfo(Model model, HttpSession session ,HttpServletRequest request) {
		String userID = request.getParameter("ID");
		if(userID == null) {
			userID = request.getParameter("userID");
		}
		else {
			userID = request.getParameter("ID");
			User user = userInfoService.getUser(userID);
			session.setAttribute(userID, user);
		} 
		User user = (User) session.getAttribute(userID);
		ArrayList<Photos> list = userInfoService.getUserPhotos(user.getUserID());  
		model.addAttribute("User",user);
		model.addAttribute("list",list);
		return "UserInformations";
	}
	
	
	/**
	 * �޸�����
	 * @param request
	 * @param response
	 * @throws IOException 
	 */
	@RequestMapping(value="/uploadPassword")
	@ResponseBody
	public void uploadPassword(HttpServletRequest request, HttpServletResponse response) 
			throws IOException  {
		String oldPassword = request.getParameter("oldPassword");
		String newPassword1 = request.getParameter("newPassword1");
		String newPassword2 = request.getParameter("newPassword2");
		String userID = request.getParameter("ID");
		String news = userInfoService.updatePassword(userID, oldPassword, newPassword1, newPassword2);
		
		ObjectMapper mapper = new ObjectMapper();
		HashMap<String, String> map = new HashMap<String, String>();
		map.put("news", news);
		response.setContentType("text/html;charset=utf-8");
		response.getWriter().println(mapper.writeValueAsString(map));
	}
	
	
	/**
	 * �޸��û���
	 * @param request
	 * @param response
	 * @throws IOException  
	 */
	@RequestMapping(value="/uploadUserName",produces="text/html;charset=utf-8")
	@ResponseBody
	public void uploadUserName(HttpServletRequest request, HttpServletResponse response) 
			throws IOException {
		String newUserName = request.getParameter("newUserName");	
		String userID = request.getParameter("ID");
		userInfoService.updateUserName(userID, newUserName);
		
		/*����json����*/
		ObjectMapper mapper = new ObjectMapper();
		HashMap<String, String> map = new HashMap<String, String>();
		map.put("newUserName", newUserName);
		response.setContentType("text/html;charset=utf-8");
		response.getWriter().println(mapper.writeValueAsString(map));
	}
	
	
	/**
	 * �ϴ�ͼƬ����
	 * @param file     �ϴ���ͼƬ
	 * @param request
	 * @return 
	 * @throws IOException  
	 */
	@RequestMapping(value="/uploadPhotos")
	public String GenerateImage(@RequestParam("photo")CommonsMultipartFile file,@RequestParam("userNo") String userID,
			HttpServletRequest request,HttpSession session) throws IOException	{//�ϴ�ͼƬ���û�ID					
		//�������·����ȡ����·����ͼƬ�ϴ���λ	��Ԫ������	
		String realUploadPath=request.getServletContext().getRealPath("/")+"userPhotos";
		System.out.println(realUploadPath);
		//��ȡ�ϴ���ԭͼ����Ե�ַ��ͼƬ���		
		ArrayList<String> list=userInfoService.uploadImage(file, realUploadPath);	
		
		String pname = request.getParameter("PhotoName");  //��ȡ�ϴ�ͼƬ
		/*System.out.println(pname);*/
		String pstory = request.getParameter("PhotoStory"); //��ȡ�ϴ�ͼƬ�Ĺ���
		/*System.out.println(pstory);*/
		String ptype = request.getParameter("type");     //��ȡ�ϴ�ͼƬ������

		
		Date d = new Date();		                     //ͼƬ�ϴ�ʱ��
		Timestamp timeStamep = new Timestamp(d.getTime());
		/*System.out.println(timeStamep);*/
		userInfoService.insertPhotos(new Tphotos(list.get(1), userID, pname, timeStamep, pstory, list.get(0), ptype));
		return "redirect:userInfo?userID="+userID;
	}	
}















