package com.bbd.wtyh.domain;

public class DynamicRiskDataWithBLOBs extends DynamicRiskData {
    private String corePersonList;

    private String controlNum;

    private String agreeCompanyDetail;

    private String companyDetail;

    public String getCorePersonList() {
        return corePersonList;
    }

    public void setCorePersonList(String corePersonList) {
        this.corePersonList = corePersonList == null ? null : corePersonList.trim();
    }

    public String getControlNum() {
        return controlNum;
    }

    public void setControlNum(String controlNum) {
        this.controlNum = controlNum == null ? null : controlNum.trim();
    }

    public String getAgreeCompanyDetail() {
        return agreeCompanyDetail;
    }

    public void setAgreeCompanyDetail(String agreeCompanyDetail) {
        this.agreeCompanyDetail = agreeCompanyDetail == null ? null : agreeCompanyDetail.trim();
    }

    public String getCompanyDetail() {
        return companyDetail;
    }

    public void setCompanyDetail(String companyDetail) {
        this.companyDetail = companyDetail == null ? null : companyDetail.trim();
    }
}