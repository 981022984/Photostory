package com.photostory.entity;

/**
 * 用户上传的且通过审核的图片
 * @author Administrator
 * @time 2018年9月16日19:06:41
 * @vision 1.0
 */
public class Photos extends Tphotos{
	private String adminID;    //审核图片管理员ID
	private int pcomment;      //评论、点赞图片人数
	
	public Photos() {
		
	}
	public String getAdminID() {
		return adminID;
	}
	public void setAdminID(String adminID) {
		this.adminID = adminID;
	}
	public int getPcomment() {
		return pcomment;
	}
	public void setPcomment(int pcomment) {
		this.pcomment = pcomment;
	}
}
