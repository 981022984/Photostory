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
 * Controller,主页的请求处理
 * @author zuo 
 * @tiem 2018年9月20日22:30:34
 * @vision
 */
@Controller
public class MainPageController {
	@Autowired
	private PhotosService photosService;      //注入Service接口对象
	
	@Autowired
	private RegisterService registerService;
	
	//注入校验器对象
	@Autowired         
	@Qualifier("UserValidator")
	private UserValidator userV;
           
	
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
		int pages = photosService.getAllPhotosCount();             //总页数
		ArrayList<Photos> photos = photosService.getPhotos(page);  //首页中所有图片
		model.addAttribute("pages",pages);
		model.addAttribute("photos",photos);
		return "HomePage2";
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
		
		String currentPage = request.getParameter("currentPage");   //获取当前页数
		int pageNo = Integer.parseInt(currentPage);
		System.out.println("----"+pageNo);
		Page page = new Page(pageNo);      //生成新的页
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
	 * 点赞功能
	 * @param request 获取请求
	 * @return 点赞后赞的数量
	 */
	@ResponseBody
	@RequestMapping(value="/goodPhoto")
	public String goodPhoto(HttpServletRequest request) {
		String pno = request.getParameter("pno");    //获取图片编号
		String pcomment = request.getParameter("pcomment");  //获取评论点赞数
		System.out.println(pcomment);
		int x = photosService.addGoodPhoto(pcomment,pno);
		return ""+x;
	}
	
	/**
	 * 跳转注册界面
	 * @param Model 要传送到界面的模型
	 * @return 注册界面的视图
	 */
	@RequestMapping(value="/register")
	public String registerUser(Model model) {
		model.addAttribute("User",new User());
		return "/Register";
	}
	
	/**
	 * 用户注册
	 * @param request  获取注册时确认密码
	 * @param session  保存注册成功用户的登录信息
	 * @param model    传对象到前端界面
	 * @param response 传消息到前端界面
	 * @param user     获取前端要注册的用户信息
	 * @param Errors   错误信息
	 */
	@RequestMapping(value="/newUser")
	public String addNewUser(HttpServletRequest request, HttpSession session, Model model,
			HttpServletResponse response, @ModelAttribute("User") User user, Errors errors) {
		model.addAttribute("User",user);
		String password = request.getParameter("password");
		user.setPassword2(password);
		userV.validate(user, errors);  //校验器调用
		response.setContentType("text/html;charset=UTF-8");
		if(errors.hasErrors()) {    //校验没通过
			return "Register";
		}
		else {		
			String str = registerService.addUser(user.getUserID(), user.getUserPassword(), password);
			return "redirect:dealwithPhotos";
		}
	}
	
	//
}












