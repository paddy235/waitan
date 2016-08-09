package com.bbd.wtyh.web.relationVO;

import java.util.List;

public class BasicDataVO {
	// 工商注册资料
	private EnterpriseDataVO enterpriseData;
	// 董事VO
	private List<ManagementInfoVO> dsvo;
	// 监事VO
	private List<ManagementInfoVO> jsvo;
	// 高级管理VO
	private List<ManagementInfoVO> jlvo ;
	// 股东信息
	private List<ShareholderDataVO> shareholderDatas;
	
	public List<ManagementInfoVO> getDsvo() {
		return dsvo;
	}

	public void setDsvo(List<ManagementInfoVO> dsvo) {
		this.dsvo = dsvo;
	}

	public List<ManagementInfoVO> getJsvo() {
		return jsvo;
	}

	public void setJsvo(List<ManagementInfoVO> jsvo) {
		this.jsvo = jsvo;
	}

	public List<ManagementInfoVO> getJlvo() {
		return jlvo;
	}

	public void setJlvo(List<ManagementInfoVO> jlvo) {
		this.jlvo = jlvo;
	}

	public EnterpriseDataVO getEnterpriseData() {
		return enterpriseData;
	}

	public void setEnterpriseData(EnterpriseDataVO enterpriseData) {
		this.enterpriseData = enterpriseData;
	}

	public List<ShareholderDataVO> getShareholderDatas() {
		return shareholderDatas;
	}

	public void setShareholderDatas(List<ShareholderDataVO> shareholderDatas) {
		this.shareholderDatas = shareholderDatas;
	}

}
