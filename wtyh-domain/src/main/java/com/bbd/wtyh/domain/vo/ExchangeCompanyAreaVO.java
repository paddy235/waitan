package com.bbd.wtyh.domain.vo;

import java.io.Serializable;

@SuppressWarnings("serial")
public class ExchangeCompanyAreaVO implements Serializable {

	/**
	 * 地区名称
	 */
	private String name;

	/**
	 * 统计值
	 */
	private Long count;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Long getCount() {
		return count;
	}

	public void setCount(Long count) {
		this.count = count;
	}
}
