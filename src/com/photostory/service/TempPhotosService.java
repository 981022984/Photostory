package com.photostory.service;

import java.util.ArrayList;
import java.util.HashMap;

import com.photostory.entity.Tphotos;

/**
 * @author zuo
 * @time 2018��9��14��08:22:50
 * @vision 1.0
 * ��ʱͼƬ����Service�ӿ�
 */
public interface TempPhotosService {
	/**
	 * @return HashMap<ͼƬ��ţ� ͼƬǰ��ʹ��·��> hashMap
	 */
	public HashMap<String, String> getTempPhotos();
	
	/**
	 * @return ����ͼƬ������Ϣ
	 */
	public ArrayList<Tphotos> getTphotos();
}
