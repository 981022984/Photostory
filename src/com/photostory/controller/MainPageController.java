package com.photostory.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.codehaus.jackson.JsonGenerationException;
import org.codehaus.jackson.map.JsonMappingException;
import org.codehaus.jackson.map.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.photostory.dao.PhotosDao;
import com.photostory.entity.Page;
import com.photostory.entity.Photos;
import com.photostory.entity.User;
import com.photostory.service.PhotosService;


/**
 * Controller,��ҳ��������
 * @author zuo 
 * @tiem 2018��9��20��22:30:34
 * @vision
 */
@Controller
public class MainPageController {
	@Autowired
	private PhotosService PhotosService;      //ע��Service�ӿڶ���
	
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
		int pages = PhotosService.getAllPhotosCount();             //��ҳ��
		ArrayList<Photos> photos = PhotosService.getPhotos(page);  //��ҳ������ͼƬ
		model.addAttribute("pages",pages);
		model.addAttribute("photos",photos);
		return "/HomePage2";
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
		
		String currentPage = request.getParameter("currentPage");
		int pageNo = Integer.parseInt(currentPage);
		System.out.println("----"+pageNo);
		Page page = new Page(pageNo);
		System.out.println("----"+page.getStartRow());
		
		ArrayList<Photos> photos = PhotosService.getPhotos(page);
		ObjectMapper mapper = new ObjectMapper();
		HashMap<String, Photos> map = new HashMap<String, Photos>();
		
		for(int i=0;i<=photos.size()-1;i++) {     //�����ҵ���Ӧϵ�İ༶����HashMap�У�����ǰ�˴���
			map.put(""+i, photos.get(i));
		}
		System.out.println(map);
		response.setContentType("text/html;charset=utf-8");
		response.getWriter().println(mapper.writeValueAsString(map));
	}
}












