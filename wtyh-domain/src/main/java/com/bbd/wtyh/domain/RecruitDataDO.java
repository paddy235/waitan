package com.bbd.wtyh.domain;

public class RecruitDataDO extends BaseDO {

    private String recruitDetail;

    private String companyName;

    private String dataVersion;



    public String getDataVersion() {
        return dataVersion;
    }

    public void setDataVersion(String dataVersion) {
        this.dataVersion = dataVersion == null ? null : dataVersion.trim();
    }
    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName == null ? null : companyName.trim();
    }

    public String getRecruitDetail() {
        return recruitDetail;
    }

    public void setRecruitDetail(String recruitDetail) {
        this.recruitDetail = recruitDetail == null ? null : recruitDetail.trim();
    }
}