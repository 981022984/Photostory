package com.photostory.entity;

/**
 * 数据页的信息
 * @author zuo 
 * @time 2018年9月20日14:51:57
 * @vision 1.0
 */
public class Page {
	private int startRow = 0;	 //开始查询的行数,从0开始
	private int pageSize = 9;    //页的大小，默认9
	private String queryKey;     //查询关键字
	public Page() {
		
	}
	public int getStartRow() {
		return startRow;
	}
	public void setStartRow(int startRow) {
		this.startRow = startRow;
	}
	public int getPageSize() {
		return pageSize;
	}
	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}
	public String getQueryKey() {
		return queryKey;
	}
	public void setQueryKey(String queryKey) {
		this.queryKey = queryKey;
	}
	
}
