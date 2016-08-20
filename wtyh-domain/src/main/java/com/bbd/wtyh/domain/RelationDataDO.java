package com.bbd.wtyh.domain;

import java.util.Date;

public class RelationDataDO extends BaseDO {
    private Date riskDate;

    private Integer relationPersonNum;

    private Integer companyPersonNum;

    private Integer childCompanyNum;

    private Integer onePersonNum;

    private Integer oneCompanyNum;

    private Integer twoPersonNum;

    private Integer twoCompanyNum;

    private Integer threePersonNum;

    private Integer threeCompanyNum;
    private String childCompanyDetail;

    private String onePersonDetail;

    private String oneCompanyDetail;

    private String twoPersonDetail;

    private String twoCompanyDetail;

    private String threePersonDetail;

    private String threeCompanyDetail;

    private String companyName;

    private String dataVersion;

    private String area;

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName == null ? null : companyName.trim();
    }

    public String getDataVersion() {
        return dataVersion;
    }

    public void setDataVersion(String dataVersion) {
        this.dataVersion = dataVersion == null ? null : dataVersion.trim();
    }

    public String getArea() {
        return area;
    }

    public void setArea(String area) {
        this.area = area == null ? null : area.trim();
    }

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
    public Date getRiskDate() {
        return riskDate;
    }

    public void setRiskDate(Date riskDate) {
        this.riskDate = riskDate;
    }

    public Integer getRelationPersonNum() {
        return relationPersonNum;
    }

    public void setRelationPersonNum(Integer relationPersonNum) {
        this.relationPersonNum = relationPersonNum;
    }

    public Integer getCompanyPersonNum() {
        return companyPersonNum;
    }

    public void setCompanyPersonNum(Integer companyPersonNum) {
        this.companyPersonNum = companyPersonNum;
    }

    public Integer getChildCompanyNum() {
        return childCompanyNum;
    }

    public void setChildCompanyNum(Integer childCompanyNum) {
        this.childCompanyNum = childCompanyNum;
    }

    public Integer getOnePersonNum() {
        return onePersonNum;
    }

    public void setOnePersonNum(Integer onePersonNum) {
        this.onePersonNum = onePersonNum;
    }

    public Integer getOneCompanyNum() {
        return oneCompanyNum;
    }

    public void setOneCompanyNum(Integer oneCompanyNum) {
        this.oneCompanyNum = oneCompanyNum;
    }

    public Integer getTwoPersonNum() {
        return twoPersonNum;
    }

    public void setTwoPersonNum(Integer twoPersonNum) {
        this.twoPersonNum = twoPersonNum;
    }

    public Integer getTwoCompanyNum() {
        return twoCompanyNum;
    }

    public void setTwoCompanyNum(Integer twoCompanyNum) {
        this.twoCompanyNum = twoCompanyNum;
    }

    public Integer getThreePersonNum() {
        return threePersonNum;
    }

    public void setThreePersonNum(Integer threePersonNum) {
        this.threePersonNum = threePersonNum;
    }

    public Integer getThreeCompanyNum() {
        return threeCompanyNum;
    }

    public void setThreeCompanyNum(Integer threeCompanyNum) {
        this.threeCompanyNum = threeCompanyNum;
    }
}