package com.bbd.wtyh.domain;


/**
* 企业统计信息
* @author Ian.Su
* @since 2016年8月13日 上午11:58:23
*/
public class CompanyCountDO {
	
	private String name;
	private Double sum;
	private Integer count;
	

	
	public String getName() {
		return name;
	}

	
	public void setName(String name) {
		this.name = name;
	}
	

	
	public Double getSum() {
		return sum;
	}

	
	public void setSum(Double sum) {
		this.sum = sum;
	}
	

	public Integer getCount() {
		return count;
	}
	

	public void setCount(Integer count) {
		this.count = count;
	}
	
	
}
