package com.photostory.entity;

import java.sql.Timestamp;

/**
 * �û���ͼƬ����ʵ��
 * @author Administrator
 * @time 2018��9��16��19:37:25
 * @vision 1.0
 */
public class Commend {
	private String pno;       //������ͼƬ���
	private String userID;    //�����û�ID
	private Timestamp commTime;    //����ʱ��
	private String comm;      //���۵�����
	private int goodComm;     //���۵�������
	private String uName;      //����������
	
	public Commend() {
		
	}
	
	public Commend(String pno, String userID, Timestamp commTime, String comm) {
		this.pno = pno;
		this.userID = userID;
		this.commTime = commTime;
		this.comm = comm;
	}

	public String getuName() {
		return uName;
	}


	public void setuName(String uName) {
		this.uName = uName;
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

	public Timestamp getCommTime() {
		return commTime;
	}

	public void setCommTime(Timestamp commTime) {
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
