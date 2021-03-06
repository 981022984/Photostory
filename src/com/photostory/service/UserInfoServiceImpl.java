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

import com.photostory.dao.CommendDao;
import com.photostory.dao.PhotosDao;
import com.photostory.dao.TempPhotosDao;
import com.photostory.dao.UserDao;
import com.photostory.entity.Commend;
import com.photostory.entity.Photos;
import com.photostory.entity.Tphotos;
import com.photostory.entity.User;
import com.photostory.unit.DealwithPhotos;

@Service
public class UserInfoServiceImpl implements UserInfoService{
	@Resource
	private PhotosDao photosCURD;
	
	@Resource
	private UserDao userCURD;
	
	@Resource
	private TempPhotosDao tempPhotosCURD;
	
	@Resource
	private CommendDao commendCURD;
	
	/**
	 * 获取用户上传的图片
	 * @param userID 登录用户的ID
	 * @return 该用户上传的图片 
	 */
	@Override
	public ArrayList<Photos> getUserPhotos(String userID) {
		ArrayList<Photos> list = photosCURD.getUserPhotos(userID);
		return list;
	}

	/**
	 * 修改密码
	 * @param userID            修改密码用户ID
	 * @param oldPassword 		旧密码
	 * @param newPassword1		新密码
	 * @param newPassword2		确认密码
	 * @return                  是否更新成功
	 */
	@Override
	public String updatePassword(String userID, String oldPassword, 
			String newPassword1, String newPassword2) {
		User user = userCURD.getUser(userID);
		if(newPassword1.equals("")) {
			return "请输入新密码！";
		}
		if(!user.getUserPassword().equals(oldPassword)) {
			return "原密码错误，请重新输入！";
		}	
		if(!newPassword1.equals(newPassword2)) {
			return "前后两次密码不匹配，请重新输入！";
		}	
		if(user.getUserPassword().equals(oldPassword) && newPassword1.equals(newPassword2) &&
				userCURD.updatePassword(newPassword1, userID) == 1){
			return "修改密码成功！";	
		}
		return "";
	}

	
	/**
	 * 修改用户名
	 * @param userID          要修改用户名的用户的ID
	 * @param newUserName     新的用户名
	 * @return                修改是否成功
	 */
	@Override
	public boolean updateUserName(String userID, String newUserName) {
		if(userCURD.updateUserName(userID, newUserName) == 1)
			return true;
		else 
			return false;
	}
	
	
	
	/**
	 * 对上传图片路径、名称进行处理
	 * @param file           传入的文件
	 * @param realUploadPath 路径
	 * @return               文件名、数据库存储路径
	 * @throws IOException
	 */
	@Override
	public ArrayList<String> uploadImage(CommonsMultipartFile file,String realUploadPath) throws IOException	{		
		ArrayList<String> list = new ArrayList<String>();
		//如果目录不存在则创建目录		
		File uploadFile=new File(realUploadPath+"/tempImage");		
		if(!uploadFile.exists()){			
			uploadFile.mkdirs();		
		}	
		//修改上传文件名字
		String pno = ""+(Integer.parseInt(tempPhotosCURD.getLastPno())+1);
		String fname = ""+(Integer.parseInt(tempPhotosCURD.getLastPno())+1)+".jpg";
		System.out.println(fname);
		System.out.println(file.getOriginalFilename());
		//创建输入流		
		InputStream inputStream=file.getInputStream();		
		//生成输出地址URL		
		String outputPath=realUploadPath+"/tempImage/"+fname;		
		//创建输出流		
		OutputStream outputStream=new FileOutputStream(outputPath);				
		//设置缓冲区		
		byte[] buffer=new byte[1024];				
		//输入流读入缓冲区，输出流从缓冲区写出		
		while((inputStream.read(buffer))>0){		  
			outputStream.write(buffer);		
		}		
		outputStream.close();				
		//返回原图上传后的相对地址		
		list.add("userPhotos/tempImage/"+fname);
		list.add(pno);
		return list;
	}
	
	
	/**
	 * @param tp  要上传的临时文件对象
	 */
	@Override
	public void insertPhotos(Tphotos tp) {
		tempPhotosCURD.uploadPhotos(tp);
	}
	
	
	/**
	 * 获取对应图片
	 * @param pno  要获取图片的编号
 	 * @return     要获取图片
	 */
	@Override
	public Photos getPhoto(String pno) {
		Photos photo = photosCURD.getPhoto(pno);
		String src = TempPhotosServiceImpl.class.getClassLoader().getResource("../../").getPath();
		src = src + photo.getPath(); 
		/*缩放后图片存储路径（相对），将存放路径中的image文件夹改为pagePhotos*/
		String dest = src.replace("image", "pagePhotos2");  
		try {
			/*工具类中图片缩放*/
			DealwithPhotos.resize(src, dest, 550, 420, true);    			
		}catch (Exception e) {
			e.printStackTrace();
		}
		/*截取图片后面固定的31位作为页面引用图片的路径*/
		String pstr = dest.substring(dest.length()-32,dest.length());
		photo.setPsrc(pstr);
		return photo;
	}
	
	
	/**
	 * 获取对应图片的所有评论
	 * @param pno	要获取图片评论的图片的编号
	 * @return		要获取的评论集合
	 */
	@Override
	public ArrayList<Commend> getCommends(String pno){
		ArrayList<Commend> commends= commendCURD.getCommends(pno);
		return commends;
	}
	
	/**
	 * @param commend  要插入的评论信息
	 */
	@Override
	public void addCommend(Commend commend) {
		commendCURD.addCommend(commend);
	}

	
	/**
	 * 查找新的用户信息
	 * @param userID  要查找用户的ID
	 * @return 查找到的新的用户信息
	 */
	@Override
	public User getUser(String userID) {
		return userCURD.getUser(userID);
	}
}

















