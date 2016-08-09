package com.bbd.wtyh.web.relationVO;

public class RelatedCompanyVO {

	private BasicDataVO basicData;//公司基本信息
	
	private int lawsuitCount; //诉讼记录条数
	
	private boolean buyFlag;	 //订单是否购买

	public BasicDataVO getBasicData() {
		return basicData;
	}

	public void setBasicData(BasicDataVO basicData) {
		this.basicData = basicData;
	}

	public int getLawsuitCount() {
		return lawsuitCount;
	}

	public void setLawsuitCount(int lawsuitCount) {
		this.lawsuitCount = lawsuitCount;
	}

	public boolean isBuyFlag() {
		return buyFlag;
	}

	public void setBuyFlag(boolean buyFlag) {
		this.buyFlag = buyFlag;
	}
	
	
}
