package com.photostory.service;

import java.util.ArrayList;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.photostory.dao.PhotosDao;
import com.photostory.entity.Page;
import com.photostory.entity.Photos;
import com.photostory.unit.DealwithPhotos;

/**
 * ͼƬ����Service�ӿ�ʵ����
 * @author zuo
 * @time 2018��9��20��20:21:01
 * @vision 1.0
 */

@Service
@Transactional
public class PhotosServiceImpl implements PhotosService{
	//ע��Serviceʵ��������	
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
			/*�û��ϴ�ͼƬ�洢λ�ã���ԣ�*/
			String src = TempPhotosServiceImpl.class.getClassLoader().getResource("../../").getPath();
			src = src + tp.getPath(); 
			/*���ź�ͼƬ�洢·������ԣ��������·���е�image�ļ��и�ΪpagePhotos*/
			String dest = src.replace("image", "pagePhotos");  
			try {
				/*��������ͼƬ����*/
				DealwithPhotos.resize(src, dest, 450, 320, true);    			
			}catch (Exception e) {
				e.printStackTrace();
			}
			/*��ȡͼƬ����̶���31λ��Ϊҳ������ͼƬ��·��*/
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
	
	/* (non-Javadoc)
	 * @see com.photostory.service.PhotosService#addGoodPhoto(java.lang.String)
	 */
	public int addGoodPhoto(String pcomment, String pno) {
		int count = Integer.parseInt(pcomment) + 1;
		int k = photosCURD.goodPhoto(""+count, pno);
		return count;
	}
}






