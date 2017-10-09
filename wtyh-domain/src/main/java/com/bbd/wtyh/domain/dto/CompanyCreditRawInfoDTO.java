package com.bbd.wtyh.domain.dto;

/**
 */
public class CompanyCreditRawInfoDTO {



	/** 信息所属单位 */
	private String xxssdw;

	/** 信息类别 */
	private String xxlb;

	/** 原始正文 */
	private String content;


	/**
	 * 获取 信息所属单位
	 *
	 * @return xxssdw 信息所属单位
	 */
	public String getXxssdw() {
		return xxssdw;
	}

	/**
	 * 设置 信息所属单位
	 *
	 * @param xxssdw 信息所属单位
	 */
	public void setXxssdw(String xxssdw) {
		this.xxssdw = xxssdw;
	}

	/**
	 * 获取 信息类别
	 *
	 * @return xxlb 信息类别
	 */
	public String getXxlb() {
		return xxlb;
	}

	/**
	 * 设置 信息类别
	 *
	 * @param xxlb 信息类别
	 */
	public void setXxlb(String xxlb) {
		this.xxlb = xxlb;
	}

	/**
	 * 获取 原始正文
	 *
	 * @return content 原始正文
	 */
	public String getContent() {
		return content;
	}

	/**
	 * 设置 原始正文
	 *
	 * @param content 原始正文
	 */
	public void setContent(String content) {
		this.content = content;
	}


}