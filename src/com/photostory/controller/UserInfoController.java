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
 * 用户信息操作控制器
 * @author zuo
 * @time 2018年9月30日17:08:52
 * @version 1.0
 */
@Controller
public class UserInfoController {
	@Autowired
	private UserInfoService userInfoService;
	
	/**
	 * 跳转用户信息界面
	 * @param model
	 * @return 用户信息界面
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
	 * 修改密码
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
	 * 修改用户名
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
		
		/*返回json数据*/
		ObjectMapper mapper = new ObjectMapper();
		HashMap<String, String> map = new HashMap<String, String>();
		map.put("newUserName", newUserName);
		response.setContentType("text/html;charset=utf-8");
		response.getWriter().println(mapper.writeValueAsString(map));
	}
	
	
	/**
	 * 上传图片处理
	 * @param file     上传的图片
	 * @param request
	 * @return 
	 * @throws IOException  
	 */
	@RequestMapping(value="/uploadPhotos")
	public String GenerateImage(@RequestParam("photo")CommonsMultipartFile file,@RequestParam("userNo") String userID,
			HttpServletRequest request,HttpSession session) throws IOException	{//上传图片的用户ID					
		//根据相对路径获取绝对路径，图片上传后位	于元数据中	
		String realUploadPath=request.getServletContext().getRealPath("/")+"userPhotos";
		System.out.println(realUploadPath);
		//获取上传后原图的相对地址、图片编号		
		ArrayList<String> list=userInfoService.uploadImage(file, realUploadPath);	
		
		String pname = request.getParameter("PhotoName");  //获取上传图片
		/*System.out.println(pname);*/
		String pstory = request.getParameter("PhotoStory"); //获取上传图片的故事
		/*System.out.println(pstory);*/
		String ptype = request.getParameter("type");     //获取上传图片的类型

		
		Date d = new Date();		                     //图片上传时间
		Timestamp timeStamep = new Timestamp(d.getTime());
		/*System.out.println(timeStamep);*/
		userInfoService.insertPhotos(new Tphotos(list.get(1), userID, pname, timeStamep, pstory, list.get(0), ptype));
		return "redirect:userInfo?userID="+userID;
	}	
}















