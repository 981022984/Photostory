package com.photostory.entity;

import java.util.Date;

/**
 * �û���ͼƬ����ʵ��
 * @author Administrator
 * @time 2018��9��16��19:37:25
 * @vision 1.0
 */
public class Commend {
	private String pno;       //������ͼƬ���
	private String userID;    //�����û�ID
	private Date commTime;    //����ʱ��
	private String comm;      //���۵�����
	private int goodComm;     //���۵�������
	
	public Commend() {
		
	}

	public String getPno() {
		return pno;
	}

	public void setPno(String pno) {
		this.pno = pno;
	}

	public String getUserID() {
		return userID;
	}

	public void setUserID(String userID) {
		this.userID = userID;
	}

	public Date getCommTime() {
		return commTime;
	}

	public void setCommTime(Date commTime) {
		this.commTime = commTime;
	}

	public String getComm() {
		return comm;
	}

	public void setComm(String comm) {
		this.comm = comm;
	}

	public int getGoodComm() {
		return goodComm;
	}

	public void setGoodComm(int goodComm) {
		this.goodComm = goodComm;
	}
	
}
