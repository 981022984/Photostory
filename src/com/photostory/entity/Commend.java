package com.photostory.entity;

import java.util.Date;

/**
 * 用户对图片评论实体
 * @author Administrator
 * @time 2018年9月16日19:37:25
 * @vision 1.0
 */
public class Commend {
	private String pno;       //被评论图片编号
	private String userID;    //评论用户ID
	private Date commTime;    //评论时间
	private String comm;      //评论的内容
	private int goodComm;     //评论点赞人数
	
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
