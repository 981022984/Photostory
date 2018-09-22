package com.photostory.entity;

/**
 * ����ҳ����Ϣ
 * @author zuo 
 * @time 2018��9��20��14:51:57
 * @vision 1.0
 */
public class Page {
	private int startRow = 0;	 //��ʼ��ѯ������,��0��ʼ
	private int pageSize = 9;    //ҳ�Ĵ�С��Ĭ��9
	private String queryKey;     //��ѯ�ؼ��� ����һ������
	private static String pcomment = "pcomment";      //���������ֶ�,�˴�Ϊ��������
	
	public Page() {
		
	}
	
	public Page(int startRow) {
		this.startRow = (startRow-1)*9;
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
	public String getPcomment() {
		return pcomment;
	}
	public void setPcomment(String pcomment) {
		this.pcomment = pcomment;
	}
}
