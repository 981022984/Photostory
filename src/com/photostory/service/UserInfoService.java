package com.photostory.service;

import java.io.IOException;
import java.util.ArrayList;

import org.springframework.web.multipart.commons.CommonsMultipartFile;

import com.photostory.entity.Commend;
import com.photostory.entity.Photos;
import com.photostory.entity.Tphotos;

/**
 * 用户信息操作Service
 * @author zuo
 * @time 2018年9月30日22:21:12
 * @version 1.0
 */
public interface UserInfoService {
	/**
	 * 获取用户上传的图片
	 * @param userID 登录用户的ID
	 * @return 该用户上传的图片 
	 */
	public ArrayList<Photos> getUserPhotos(String userID);
	
	/**
	 * @param userID            修改密码用户ID
	 * @param oldPassword 		旧密码
	 * @param newPassword1		新密码
	 * @param newPassword2		确认密码
	 * @return                  是否更新成功
	 */
	public String updatePassword(String userID, String oldPassword, String newPassword1, String newPassword2);
	
	/**
	 * 修改用户名
	 * @param userID          要修改用户名的用户的ID
	 * @param newUserName     新的用户名
	 * @return                修改是否成功
	 */
	public boolean updateUserName(String userID, String newUserName);
	
	
	
	
	/**
	 * 对上传图片路径、名称进行处理
	 * @param file           传入的文件
	 * @param realUploadPath 路径
	 * @return               文件名、数据库存储路径
	 * @throws IOException
	 */
	public ArrayList<String> uploadImage(CommonsMultipartFile file,String realUploadPath)throws IOException;

	
	/**
	 * @param tp  要上传的临时文件对象
	 */
	public void insertPhotos(Tphotos tp);
	
	
	/**
	 * 获取对应图片
	 * @param pno  要获取图片的编号
 	 * @return     要获取图片
	 */
	public Photos getPhoto(String pno);
	
	
	/**
	 * 获取对应图片的所有评论
	 * @param pno	要获取图片评论的图片的编号
	 * @return		要获取的评论集合
	 */
	public ArrayList<Commend> getCommends(String pno);
	
	
	/**
	 * @param commend  要插入的评论信息
	 */
	public void addCommend(Commend commend);
}








