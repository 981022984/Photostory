package com.photostory.entity;

import java.sql.Timestamp;

/**
 * 用户对图片评论实体
 * @author Administrator
 * @time 2018年9月16日19:37:25
 * @vision 1.0
 */
public class Commend {
	private String pno;       //被评论图片编号
	private String userID;    //评论用户ID
	private Timestamp commTime;    //评论时间
	private String comm;      //评论的内容
	private int goodComm;     //评论点赞人数
	private String uName;      //评论人姓名
	
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
