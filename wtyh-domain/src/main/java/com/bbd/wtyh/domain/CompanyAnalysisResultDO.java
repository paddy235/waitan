package com.bbd.wtyh.domain;

public class CompanyAnalysisResultDO extends BaseDO {
    private Integer companyId;

    private Byte analysisResult;

    public Integer getCompanyId() {
        return companyId;
    }

    public void setCompanyId(Integer companyId) {
        this.companyId = companyId;
    }

    public Byte getAnalysisResult() {
        return analysisResult;
    }

    public void setAnalysisResult(Byte analysisResult) {
        this.analysisResult = analysisResult;
    }
}