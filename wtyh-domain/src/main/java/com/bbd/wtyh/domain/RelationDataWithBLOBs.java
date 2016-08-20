package com.bbd.wtyh.domain;

public class RelationDataWithBLOBs extends RelationData {
    private String childCompanyDetail;

    private String onePersonDetail;

    private String oneCompanyDetail;

    private String twoPersonDetail;

    private String twoCompanyDetail;

    private String threePersonDetail;

    private String threeCompanyDetail;

    public String getChildCompanyDetail() {
        return childCompanyDetail;
    }

    public void setChildCompanyDetail(String childCompanyDetail) {
        this.childCompanyDetail = childCompanyDetail == null ? null : childCompanyDetail.trim();
    }

    public String getOnePersonDetail() {
        return onePersonDetail;
    }

    public void setOnePersonDetail(String onePersonDetail) {
        this.onePersonDetail = onePersonDetail == null ? null : onePersonDetail.trim();
    }

    public String getOneCompanyDetail() {
        return oneCompanyDetail;
    }

    public void setOneCompanyDetail(String oneCompanyDetail) {
        this.oneCompanyDetail = oneCompanyDetail == null ? null : oneCompanyDetail.trim();
    }

    public String getTwoPersonDetail() {
        return twoPersonDetail;
    }

    public void setTwoPersonDetail(String twoPersonDetail) {
        this.twoPersonDetail = twoPersonDetail == null ? null : twoPersonDetail.trim();
    }

    public String getTwoCompanyDetail() {
        return twoCompanyDetail;
    }

    public void setTwoCompanyDetail(String twoCompanyDetail) {
        this.twoCompanyDetail = twoCompanyDetail == null ? null : twoCompanyDetail.trim();
    }

    public String getThreePersonDetail() {
        return threePersonDetail;
    }

    public void setThreePersonDetail(String threePersonDetail) {
        this.threePersonDetail = threePersonDetail == null ? null : threePersonDetail.trim();
    }

    public String getThreeCompanyDetail() {
        return threeCompanyDetail;
    }

    public void setThreeCompanyDetail(String threeCompanyDetail) {
        this.threeCompanyDetail = threeCompanyDetail == null ? null : threeCompanyDetail.trim();
    }
}