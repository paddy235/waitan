package com.bbd.wtyh.domain;

import com.bbd.wtyh.util.CalculateUtils;

public class CompanyCreditInformationDO extends BaseDO {
	
   
	private Integer id;

    private String companyId;

    @Override
    public Integer getId() {
        return id;
    }

    @Override
    public void setId(Integer id) {
        this.id = id;
    }

    public String getCompanyId() {
        return companyId;
    }

    public void setCompanyId(String companyId) {
        this.companyId = companyId;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    private String content;

}