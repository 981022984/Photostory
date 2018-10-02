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
 * @time 2018��9��14��08:24:42
 * @vision 1.0
 * ��ʱͼƬ����Service�ӿ�ʵ����
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
		list = tempPhotosCURD.getAllTempPhotos();      //��ȡͼƬ
		for(Tphotos tp:list) {
			/*  "TempPhotosServiceImpl.class.getClassLoader().getResource("../../userPhotos/image/10001.jpg").getPath()"   
			         �û��ϴ�ͼƬ�洢λ�ã���ԣ�,����../../userPhotos/image/10001.jpgΪ���ݿ��д洢�ĵ�·��
			   "../../userPhotos/pagePhotos/10001.jpg"  ���ź�ͼƬ�洢·������ԣ�
			   "./userPhotos/pagePhotos/10001.jpg"          ҳ������ͼƬ·������ԣ�  
		      	ͼƬ·������  
			*/
			/*�û��ϴ�ͼƬ�洢λ�ã���ԣ�*/
			String src = TempPhotosServiceImpl.class.getClassLoader().getResource(tp.getPath()).getPath();      
			/*���ź�ͼƬ�洢·������ԣ��������·���е�image�ļ��и�ΪpagePhotos*/
			String dest = src.replace("image", "pagePhotos");   
			try {
				/*��������ͼƬ����*/
				DealwithPhotos.resize(src, dest, 380, 270, true);    			
			}catch (Exception e) {
				e.printStackTrace();
			}
			/*��ȡͼƬ����̶���31λ��Ϊҳ������ͼƬ��·��*/
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
			/*�û��ϴ�ͼƬ�洢λ�ã���ԣ�*/
			String src = TempPhotosServiceImpl.class.getClassLoader().getResource("../../").getPath();
			System.out.println(src);
			src = src + tp.getPath(); 
			/*���ź�ͼƬ�洢·������ԣ��������·���е�image�ļ��и�ΪpagePhotos*/
			String dest = src.replace("image", "pagePhotos");  
			System.out.println(dest);
			try {
				/*��������ͼƬ����*/
				DealwithPhotos.resize(src, dest, 380, 270, true);    			
			}catch (Exception e) {
				e.printStackTrace();
			}
			/*��ȡͼƬ����̶���31λ��Ϊҳ������ͼƬ��·��*/
			String pstr = dest.substring(dest.length()-31,dest.length());
			tp.setPsrc(pstr);
			destList.add(tp);
		}
		return destList;
	}
	
	
	
}
