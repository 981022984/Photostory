package com.photostory.entity;

/**
 * �û��ϴ�����ͨ����˵�ͼƬ
 * @author Administrator
 * @time 2018��9��16��19:06:41
 * @vision 1.0
 */
public class Photos extends Tphotos{
	private String adminID;    //���ͼƬ����ԱID
	private int pcommend;      //����ͼƬ����
	
	public Photos() {
		
	}
	public String getAdminID() {
		return adminID;
	}
	public void setAdminID(String adminID) {
		this.adminID = adminID;
	}
	public int getPcommend() {
		return pcommend;
	}
	public void setPcommend(int pcommend) {
		this.pcommend = pcommend;
	}
}
