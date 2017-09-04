package com.bbd.wtyh.domain.dto;

/**
 * 公司批量修改DTO
 *
 * @author Created by LiYao on 2017-09-04 10:14.
 */
public class CoBatchModifyDTO {

    /** 公司名称 */
    private String companyName;
    /** 信用代码 */
    private String creditCode;
    /** 注册号 */
    private String regNum;
    /** 行业类别 */
    private String companyType;
    /** 行业类别 */
    private String riskLevel;
    /** 外部评级 */
    private String outLevel;
    /** 内部评级 */
    private String innerLevel;
    /** 现场检查 */
    private String liveLevel;

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public String getCreditCode() {
        return creditCode;
    }

    public void setCreditCode(String creditCode) {
        this.creditCode = creditCode;
    }

    public String getRegNum() {
        return regNum;
    }

    public void setRegNum(String regNum) {
        this.regNum = regNum;
    }

    public String getCompanyType() {
        return companyType;
    }

    public void setCompanyType(String companyType) {
        this.companyType = companyType;
    }

    public String getRiskLevel() {
        return riskLevel;
    }

    public void setRiskLevel(String riskLevel) {
        this.riskLevel = riskLevel;
    }

    public String getOutLevel() {
        return outLevel;
    }

    public void setOutLevel(String outLevel) {
        this.outLevel = outLevel;
    }

    public String getInnerLevel() {
        return innerLevel;
    }

    public void setInnerLevel(String innerLevel) {
        this.innerLevel = innerLevel;
    }

    public String getLiveLevel() {
        return liveLevel;
    }

    public void setLiveLevel(String liveLevel) {
        this.liveLevel = liveLevel;
    }
}
