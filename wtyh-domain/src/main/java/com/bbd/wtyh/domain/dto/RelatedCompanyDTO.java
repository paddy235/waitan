package com.bbd.wtyh.domain.dto;

/**
 * 小贷和融担的股东行业风险里面的关联企业
 * Created by Marco on 2016/9/2.
 */
public class RelatedCompanyDTO {

    private String companyName;
    private Integer riskLevel;

    public RelatedCompanyDTO(String companyName, Integer riskLevel) {
        this.companyName = companyName;
        this.riskLevel = riskLevel;
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public Integer getRiskLevel() {
        return riskLevel;
    }

    public void setRiskLevel(Integer riskLevel) {
        this.riskLevel = riskLevel;
    }
}
