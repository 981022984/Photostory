package com.photostory.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashMap;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.codehaus.jackson.JsonGenerationException;
import org.codehaus.jackson.map.JsonMappingException;
import org.codehaus.jackson.map.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.photostory.entity.Page;
import com.photostory.entity.Photos;
import com.photostory.entity.User;
import com.photostory.service.PhotosService;
import com.photostory.service.RegisterService;
import com.photostory.unit.UserValidator;


/**
 * Controller,��ҳ��������
 * @author zuo 
 * @tiem 2018��9��20��22:30:34
 * @vision
 */
@Controller
public class MainPageController {
	@Autowired
	private PhotosService photosService;      //ע��Service�ӿڶ���
	
	@Autowired
	private RegisterService registerService;
	
	//ע��У��������
	@Autowired         
	@Qualifier("UserValidator")
	private UserValidator userV;
           
	
	/**
	 * ��ȡ������ͼƬ��������ҳ
	 * @param User �Ѿ���¼���û�
	 * @param Model Ҫ���͵������ģ�� 
	 * @return String ��ҳ·�����������
	 */
	@RequestMapping(value="/dealwithPhotos")
	public String getHomePage(@ModelAttribute("User") User user, Model model) {
		//model.addAttribute("",); 
		Page page = new Page();  //�µ�ҳ
		int pages = photosService.getAllPhotosCount();             //��ҳ��
		ArrayList<Photos> photos = photosService.getPhotos(page);  //��ҳ������ͼƬ
		model.addAttribute("pages",pages);
		model.addAttribute("photos",photos);
		return "HomePage2";
	}
	/**
	 * ��ȡ��ǰͼƬ��ҳ��
	 * @param HttpServeletRequest ҳ����������
	 * @param Model Ҫ���͵������ģ��
	 * @param HttpServletResponse ��Ӧ�첽��������
	 * @throws IOException 
	 * @throws JsonMappingException 
	 * @throws JsonGenerationException 
	 */
	@ResponseBody
	@RequestMapping(value="/newPhotos")
	public void getPagePhotos(HttpServletRequest request, Model model, HttpServletResponse response) 
			throws JsonGenerationException, JsonMappingException, IOException {
		
		String currentPage = request.getParameter("currentPage");   //��ȡ��ǰҳ��
		int pageNo = Integer.parseInt(currentPage);
		System.out.println("----"+pageNo);
		Page page = new Page(pageNo);      //�����µ�ҳ
		System.out.println("----"+page.getStartRow());
		
		ArrayList<Photos> photos = photosService.getPhotos(page);
		ObjectMapper mapper = new ObjectMapper();
		HashMap<String, Photos> map = new HashMap<String, Photos>();
		
		for(int i=0;i<=photos.size()-1;i++) {   
			System.out.println(photos.get(i).getPcomment());
			map.put(""+i, photos.get(i));
		}
		System.out.println(map);
		response.setContentType("text/html;charset=utf-8");
		response.getWriter().println(mapper.writeValueAsString(map));
	}
	
	/**
	 * ���޹���
	 * @param request ��ȡ����
	 * @return ���޺��޵�����
	 */
	@ResponseBody
	@RequestMapping(value="/goodPhoto")
	public String goodPhoto(HttpServletRequest request) {
		String pno = request.getParameter("pno");    //��ȡͼƬ���
		String pcomment = request.getParameter("pcomment");  //��ȡ���۵�����
		System.out.println(pcomment);
		int x = photosService.addGoodPhoto(pcomment,pno);
		return ""+x;
	}
	
	/**
	 * ��תע�����
	 * @param Model Ҫ���͵������ģ��
	 * @return ע��������ͼ
	 */
	@RequestMapping(value="/register")
	public String registerUser(Model model) {
		model.addAttribute("User",new User());
		return "/Register";
	}
	
	/**
	 * �û�ע��
	 * @param request  ��ȡע��ʱȷ������
	 * @param session  ����ע��ɹ��û��ĵ�¼��Ϣ
	 * @param model    ������ǰ�˽���
	 * @param response ����Ϣ��ǰ�˽���
	 * @param user     ��ȡǰ��Ҫע����û���Ϣ
	 * @param Errors   ������Ϣ
	 */
	@RequestMapping(value="/newUser")
	public String addNewUser(HttpServletRequest request, HttpSession session, Model model,
			HttpServletResponse response, @ModelAttribute("User") User user, Errors errors) {
		model.addAttribute("User",user);
		String password = request.getParameter("password");
		user.setPassword2(password);
		userV.validate(user, errors);  //У��������
		response.setContentType("text/html;charset=UTF-8");
		if(errors.hasErrors()) {    //У��ûͨ��
			return "Register";
		}
		else {		
			String str = registerService.addUser(user.getUserID(), user.getUserPassword(), password);
			return "redirect:dealwithPhotos";
		}
	}
	
	//
}












