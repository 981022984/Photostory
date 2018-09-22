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
 * Controller,主页的请求处理
 * @author zuo 
 * @tiem 2018年9月20日22:30:34
 * @vision
 */
@Controller
public class MainPageController {
	@Autowired
	private PhotosService PhotosService;      //注入Service接口对象
	
	/**
	 * 获取处理后的图片，生成首页
	 * @param User 已经登录的用户
	 * @param Model 要传送到界面的模型 
	 * @return String 首页路径（需解析）
	 */
	@RequestMapping(value="/dealwithPhotos")
	public String getHomePage(@ModelAttribute("User") User user, Model model) {
		//model.addAttribute("",); 
		Page page = new Page();  //新的页
		int pages = PhotosService.getAllPhotosCount();             //总页数
		ArrayList<Photos> photos = PhotosService.getPhotos(page);  //首页中所有图片
		model.addAttribute("pages",pages);
		model.addAttribute("photos",photos);
		return "/HomePage2";
	}
	/**
	 * 获取当前图片的页数
	 * @param HttpServeletRequest 页面请求数据
	 * @param Model 要传送到界面的模型
	 * @param HttpServletResponse 响应异步请求数据
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
		
		for(int i=0;i<=photos.size()-1;i++) {     //将查找到对应系的班级放在HashMap中，便于前端处理
			map.put(""+i, photos.get(i));
		}
		System.out.println(map);
		response.setContentType("text/html;charset=utf-8");
		response.getWriter().println(mapper.writeValueAsString(map));
	}
}












