package com.photostory.service;

import java.util.ArrayList;
import java.util.HashMap;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.photostory.dao.TempPhotosDao;
import com.photostory.entity.Tphotos;
import com.photostory.unit.DealwithPhotos;

/**
 * @author zuo
 * @time 2018年9月14日08:24:42
 * @vision 1.0
 * 临时图片处理Service接口实现类
 */
@Service
public class TempPhotosServiceImpl implements TempPhotosService{
	
	@Resource
	private TempPhotosDao tempPhotosCURD;

	
	/* (non-Javadoc)
	 * @see com.photostory.service.TempPhotosService#getTempPhotos()
	 */
	@Override
	public HashMap<String, String> getTempPhotos() {
		ArrayList<Tphotos> list = new ArrayList<Tphotos>();
		HashMap<String, String> map = new HashMap<String, String>();
		list = tempPhotosCURD.getAllTempPhotos();      //获取图片
		for(Tphotos tp:list) {
			/*  "TempPhotosServiceImpl.class.getClassLoader().getResource("../../userPhotos/image/10001.jpg").getPath()"   
			         用户上传图片存储位置（相对）,其中../../userPhotos/image/10001.jpg为数据库中存储的的路径
			   "../../userPhotos/pagePhotos/10001.jpg"  缩放后图片存储路径（相对）
			   "./userPhotos/pagePhotos/10001.jpg"          页面引用图片路径（相对）  
		      	图片路径问题  
			*/
			/*用户上传图片存储位置（相对）*/
			String src = TempPhotosServiceImpl.class.getClassLoader().getResource(tp.getPath()).getPath();      
			/*缩放后图片存储路径（相对），将存放路径中的image文件夹改为pagePhotos*/
			String dest = src.replace("image", "pagePhotos");   
			try {
				/*工具类中图片缩放*/
				DealwithPhotos.resize(src, dest, 380, 270, true);    			
			}catch (Exception e) {
				e.printStackTrace();
			}
			/*截取图片后面固定的31位作为页面引用图片的路径*/
			String pstr = dest.substring(dest.length()-31,dest.length());  
			map.put(tp.getPno(), pstr);
		}
		return map;
	}

	/* (non-Javadoc)
	 * @see com.photostory.service.TempPhotosService#getTphotos()
	 */
	@Override
	public ArrayList<Tphotos> getTphotos() {
		ArrayList<Tphotos> list = new ArrayList<Tphotos>();
		ArrayList<Tphotos> destList = new ArrayList<Tphotos>();
		list = tempPhotosCURD.getAllTempPhotos2();
		for(Tphotos tp:list) {
			/*用户上传图片存储位置（相对）*/
			String src = TempPhotosServiceImpl.class.getClassLoader().getResource("../../").getPath();
			System.out.println(src);
			src = src + tp.getPath(); 
			/*缩放后图片存储路径（相对），将存放路径中的image文件夹改为pagePhotos*/
			String dest = src.replace("image", "pagePhotos");  
			System.out.println(dest);
			try {
				/*工具类中图片缩放*/
				DealwithPhotos.resize(src, dest, 380, 270, true);    			
			}catch (Exception e) {
				e.printStackTrace();
			}
			/*截取图片后面固定的31位作为页面引用图片的路径*/
			String pstr = dest.substring(dest.length()-31,dest.length());
			tp.setPsrc(pstr);
			destList.add(tp);
		}
		return destList;
	}
	
	
	
}
