package com.photostory.entity;

import java.util.Date;

/**
 * @author zuo
 * @time 2018年9月13日22:19:02
 * @vision 1.0
 * 临时图片
 */
public class Tphotos {
	private String pno;
	private Date ptime;
	private String userID;
	private String pname;
	private String path;
	private String pstory;
	private String psrc;  //页面使用的路径
	

	public Tphotos() {
		
	}
	
	public String getPsrc() {
		return psrc;
	}

	public void setPsrc(String psrc) {
		this.psrc = psrc;
	}
	
	public String getPno() {
		return pno;
	}

	public void setPno(String pno) {
		this.pno = pno;
	}

	public Date getPtime() {
		return ptime;
	}

	public void setPtime(Date ptime) {
		this.ptime = ptime;
	}

	public String getUserID() {
		return userID;
	}

	public void setUserID(String userID) {
		this.userID = userID;
	}

	public String getPname() {
		return pname;
	}

	public void setPname(String pname) {
		this.pname = pname;
	}

	public String getPath() {
		return path;
	}

	public void setPath(String path) {
		this.path = path;
	}

	public String getPstory() {
		return pstory;
	}

	public void setPstory(String pstory) {
		this.pstory = pstory;
	}
}
