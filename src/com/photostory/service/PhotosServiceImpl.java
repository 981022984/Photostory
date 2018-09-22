package com.photostory.service;

import java.util.ArrayList;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.photostory.dao.PhotosDao;
import com.photostory.entity.Page;
import com.photostory.entity.Photos;
import com.photostory.entity.Tphotos;
import com.photostory.unit.DealwithPhotos;

/**
 * 图片处理Service接口实现类
 * @author zuo
 * @time 2018年9月20日20:21:01
 * @vision 1.0
 */
@Service
public class PhotosServiceImpl implements PhotosService{
	//注入Service实现类依赖	
	@Resource
	private PhotosDao photosCURD;
	
	
	/* (non-Javadoc)
	 * @see com.photostory.service.PhotosService#getAllPhotos()
	 */
	@Override
	public void getAllPhotos() {
		photosCURD.getAllPhotos();
	}

	@Override
	public ArrayList<Photos> getPhotos(Page page) {
		ArrayList<Photos> photos = new ArrayList<Photos>();
		ArrayList<Photos> destPhotos = new ArrayList<Photos>();
		photos = photosCURD.getPhotos(page);
		
		for(Photos tp:photos) {
			/*用户上传图片存储位置（相对）*/
			String src = TempPhotosServiceImpl.class.getClassLoader().getResource("../../").getPath();
			System.out.println(src);
			src = src + tp.getPath(); 
			/*缩放后图片存储路径（相对），将存放路径中的image文件夹改为pagePhotos*/
			String dest = src.replace("image", "pagePhotos");  
			System.out.println(dest);
			System.out.println(src);
			try {
				/*工具类中图片缩放*/
				DealwithPhotos.resize(src, dest, 380, 270, true);    			
			}catch (Exception e) {
				e.printStackTrace();
			}
			/*截取图片后面固定的31位作为页面引用图片的路径*/
			String pstr = dest.substring(dest.length()-31,dest.length());
			tp.setPsrc(pstr);
			destPhotos.add(tp);
		}
		return destPhotos;
	}

	/* (non-Javadoc)
	 * @see com.photostory.service.PhotosService#getAllPhotosCount()
	 */
	@Override
	public int getAllPhotosCount() {
		int count = photosCURD.getAllPhotos();
		int pages = 0;
		if(count%9 == 0) {
			pages = count / 9;
		}
		else if(count < 9) {
			pages = 1;
		}
		else 
			pages = (count / 9) + 1;
		
		return pages;
	}	
}






