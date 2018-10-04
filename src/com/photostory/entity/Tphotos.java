package com.photostory.entity;

import java.sql.Timestamp;


/**
 * @author zuo
 * @time 2018年9月13日22:19:02
 * @vision 1.0
 * 临时图片
 */
public class Tphotos {
	private String pno;
	private Timestamp ptime;
	private String userID;
	private String pname;
	private String path;
	private String pstory;
	private String psrc;  //页面使用的路径
	private String ptype;
	private String userName;  //上传图片用户名称

	public Tphotos() {
		
	}
	
	public Tphotos(String pno, String userID,String pname, Timestamp ptime, 
			String pstory, String path, String ptype) {
		this.pno = pno;
		this.userID = userID;
		this.pname = pname;
		this.ptime = ptime;
		this.pstory = pstory;
		this.path = path;
		this.ptype = ptype;
	}
	
	
	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPtype() {
		return ptype;
	}

	public void setPtype(String ptype) {
		this.ptype = ptype;
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

	public Timestamp getPtime() {
		return ptime;
	}

	public void setPtime(Timestamp ptime) {
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
