package com.photostory.controller;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.codehaus.jackson.JsonGenerationException;
import org.codehaus.jackson.map.JsonMappingException;
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
	public String userInfo(Model model,HttpSession session) {
		ArrayList<Photos> list = userInfoService.getUserPhotos("1415241");
		model.addAttribute("User",new User("1415241","999999","����"));
		model.addAttribute("list",list);
		return "UserInformations";
	}
	
	
	/**
	 * �޸�����
	 * @param request
	 * @param response
	 * @throws IOException 
	 * @throws JsonMappingException 
	 * @throws JsonGenerationException 
	 * @throws UnsupportedEncodingException 
	 */
	@RequestMapping(value="/uploadPassword")
	@ResponseBody
	public void uploadPassword(HttpServletRequest request, HttpServletResponse response) 
			throws IOException  {
		String oldPassword = request.getParameter("oldPassword");
		String newPassword1 = request.getParameter("newPassword1");
		String newPassword2 = request.getParameter("newPassword2");
		String news = userInfoService.updatePassword("1415241", oldPassword, newPassword1, newPassword2);
		
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
		System.out.println(newUserName);
		userInfoService.updateUserName("1415241", newUserName);
		
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
	public void GenerateImage(@RequestParam("photo")CommonsMultipartFile file,
			HttpServletRequest request,HttpSession session) throws IOException	{					
		//�������·����ȡ����·����ͼƬ�ϴ���λ	��Ԫ������	
		String realUploadPath=request.getServletContext().getRealPath("/")+"userPhotos";
		System.out.println(realUploadPath);
		//��ȡ�ϴ���ԭͼ����Ե�ַ��ͼƬ���		
		ArrayList<String> list=userInfoService.uploadImage(file, realUploadPath);	
		
		String pname = request.getParameter("PhotoName");  //��ȡ�ϴ�ͼƬ
		System.out.println(pname);
		String pstory = request.getParameter("PhotoStory"); //��ȡ�ϴ�ͼƬ�Ĺ���
		System.out.println(pstory);
		String ptype = request.getParameter("type");     //��ȡ�ϴ�ͼƬ������
		System.out.println(ptype);
		
		Date d = new Date();		                     //ͼƬ�ϴ�ʱ��
		Timestamp timeStamep = new Timestamp(d.getTime());
		System.out.println(timeStamep);
		userInfoService.insertPhotos(new Tphotos(list.get(1),"1415241",pname, timeStamep, pstory, list.get(0), ptype));   //ģ���ϴ�ͼƬ��Ϣ
	}	
}















