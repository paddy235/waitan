package com.bbd.wtyh.domain;

import java.util.List;

/**
* 企业类型统计
* @author Ian.Su
* @since 2016年8月6日 下午2:42:39
*/

public class CompanyTypeCountDO {
	
	private String type;
	
	private int count;
	
	private List<CompanyTypeCountDO> children;

	
	public String getType() {
		return type;
	}

	public CompanyTypeCountDO setType(String type) {
		this.type = type;
		return this;
	}

	public int getCount() {
		return count;
	}

	public void setCount(int count) {
		this.count = count;
	}
	
	public List<CompanyTypeCountDO> getChildren() {
		return children;
	}

	public void setChildren(List<CompanyTypeCountDO> children) {
		this.children = children;
	}
	
	
	
	
}
