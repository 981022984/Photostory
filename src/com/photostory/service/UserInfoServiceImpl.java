package com.photostory.service;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.HashMap;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.web.multipart.commons.CommonsMultipartFile;

import com.photostory.dao.PhotosDao;
import com.photostory.dao.TempPhotosDao;
import com.photostory.dao.UserDao;
import com.photostory.entity.Photos;
import com.photostory.entity.Tphotos;
import com.photostory.entity.User;

@Service
public class UserInfoServiceImpl implements UserInfoService{
	@Resource
	private PhotosDao photosCURD;
	
	@Resource
	private UserDao userCURD;
	
	@Resource
	private TempPhotosDao tempPhotosCURD;
	
	/**
	 * ��ȡ�û��ϴ���ͼƬ
	 * @param userID ��¼�û���ID
	 * @return ���û��ϴ���ͼƬ 
	 */
	@Override
	public ArrayList<Photos> getUserPhotos(String userID) {
		ArrayList<Photos> list = photosCURD.getUserPhotos(userID);
		return list;
	}

	/**
	 * �޸�����
	 * @param userID            �޸������û�ID
	 * @param oldPassword 		������
	 * @param newPassword1		������
	 * @param newPassword2		ȷ������
	 * @return                  �Ƿ���³ɹ�
	 */
	@Override
	public String updatePassword(String userID, String oldPassword, 
			String newPassword1, String newPassword2) {
		HashMap<String, Object> map = new HashMap<String, Object>();
		map.put("userID", userID);
		map.put("userPassword",oldPassword);
		User user = userCURD.selectUser(map);
		if(newPassword1.equals("")) {
			return "�����������룡";
		}
		if(!user.getUserPassword().equals(oldPassword)) {
			return "ԭ����������������룡";
		}	
		if(!newPassword1.equals(newPassword2)) {
			return "ǰ���������벻ƥ�䣬���������룡";
		}	
		if(user.getUserPassword().equals(oldPassword) && newPassword1.equals(newPassword2) &&
				userCURD.updatePassword(newPassword1, userID) == 1){
			return "�޸�����ɹ���";	
		}
		return "";
	}

	
	/**
	 * �޸��û���
	 * @param userID          Ҫ�޸��û������û���ID
	 * @param newUserName     �µ��û���
	 * @return                �޸��Ƿ�ɹ�
	 */
	@Override
	public boolean updateUserName(String userID, String newUserName) {
		if(userCURD.updateUserName(userID, newUserName) == 1)
			return true;
		else 
			return false;
	}
	
	
	
	/**
	 * ���ϴ�ͼƬ·�������ƽ��д���
	 * @param file           ������ļ�
	 * @param realUploadPath ·��
	 * @return               �ļ��������ݿ�洢·��
	 * @throws IOException
	 */
	@Override
	public ArrayList<String> uploadImage(CommonsMultipartFile file,String realUploadPath) throws IOException	{		
		ArrayList<String> list = new ArrayList<String>();
		//���Ŀ¼�������򴴽�Ŀ¼		
		File uploadFile=new File(realUploadPath+"/tempImage");		
		if(!uploadFile.exists()){			
			uploadFile.mkdirs();		
		}	
		//�޸��ϴ��ļ�����
		String pno = ""+(Integer.parseInt(tempPhotosCURD.getLastPno())+1);
		String fname = ""+(Integer.parseInt(tempPhotosCURD.getLastPno())+1)+".jpg";
		System.out.println(fname);
		System.out.println(file.getOriginalFilename());
		//����������		
		InputStream inputStream=file.getInputStream();		
		//���������ַURL		
		String outputPath=realUploadPath+"/tempImage/"+fname;		
		//���������		
		OutputStream outputStream=new FileOutputStream(outputPath);				
		//���û�����		
		byte[] buffer=new byte[1024];				
		//���������뻺������������ӻ�����д��		
		while((inputStream.read(buffer))>0){		  
			outputStream.write(buffer);		
		}		
		outputStream.close();				
		//����ԭͼ�ϴ������Ե�ַ		
		list.add("userPhotos/tempImage/"+fname);
		list.add(pno);
		return list;
	}
	
	
	@Override
	public void insertPhotos(Tphotos tp) {
		tempPhotosCURD.uploadPhotos(tp);
	}
}

















