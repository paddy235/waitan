package com.bbd.wtyh.domain;

public class CompanyCreditDetailDO extends BaseDO {
	
   
	private Integer companyId;

    private float companyRiskInfo;

    public Integer getCompanyId() {
        return companyId;
    }

    public void setCompanyId(Integer companyId) {
        this.companyId = companyId;
    }

    public float getCompanyRiskInfo() {
        return companyRiskInfo;
    }

    public void setCompanyRiskInfo(float companyRiskInfo) {
        this.companyRiskInfo = companyRiskInfo;
    }
}