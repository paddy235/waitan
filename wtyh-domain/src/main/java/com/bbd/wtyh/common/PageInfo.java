package com.bbd.wtyh.common;

import java.io.Serializable;

@SuppressWarnings("serial")
public class PageInfo implements Serializable {

	private int pageSize; // 分页大小
	private int pageNo; // 当前页
	private int totalPage; // 总页数
	private int totalCount; // 总记录数
	
	public PageInfo() {}
	
	public PageInfo(int pageSize, int pageNo, int totalPage, int totalCount) {
		this.pageSize = pageSize;
		this.pageNo = pageNo;
		this.totalPage = totalPage;
		this.totalCount = totalCount;
	}

	public int getPageSize() {
		return pageSize;
	}

	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}

	public int getPageNo() {
		return pageNo;
	}

	public void setPageNo(int pageNo) {
		this.pageNo = pageNo;
	}

	public int getTotalPage() {
		return totalPage;
	}

	public void setTotalPage(int totalPage) {
		this.totalPage = totalPage;
	}

	public int getTotalCount() {
		return totalCount;
	}

	public void setTotalCount(int totalCount) {
		this.totalCount = totalCount;
	}

}
