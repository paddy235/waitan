package com.bbd.wtyh.domain;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.Table;

@Table(name = "exchange_company")
public class ExchangeCompanyDO extends BaseDO {
    @Id
    @Column(name = "company_id")
    private Integer companyId;

    @Column(name = "approve_department")
    private String approveDepartment;

    @Column(name = "supervise_department")
    private String superviseDepartment;

    @Column(name = "status")
    private Byte status;

    @Column(name = "website")
    private String website;

    @Column(name = "type")
    private Byte type;

//------在表中不存在的成员
    //企业名称
    private String companyName;

    // 风险等级
    private String riskLevel;

    /**
     * 设立途径
     * “企业自行设立”-> status的2
     * “2013年通过清理整联办验收” ->status的5
     * “市政府及市相关主管单位批复设立” ->status的1(其他地方有反向对应到3、4)
     */
    private String establishWay;

    /**
     * 数据来源
     * “金融办”->type的1，“BBD”-> type的2
     */
    private String dataSrc;


    public Integer getCompanyId() {
        return companyId;
    }

    public void setCompanyId(Integer companyId) {
        this.companyId = companyId;
    }

    public String getApproveDepartment() {
        return approveDepartment;
    }

    public void setApproveDepartment(String approveDepartment) {
        this.approveDepartment = approveDepartment == null ? null : approveDepartment.trim();
    }

    public String getSuperviseDepartment() {
        return superviseDepartment;
    }

    public void setSuperviseDepartment(String superviseDepartment) {
        this.superviseDepartment = superviseDepartment == null ? null : superviseDepartment.trim();
    }

    public Byte getStatus() {
        return status;
    }

    public void setStatus(Byte status) {
        this.status = status;
    }

    public String getWebsite() {
        return website;
    }

    public void setWebsite(String website) {
        this.website = website;
    }

    public Byte getType() {
        return type;
    }

    public void setType(Byte type) {
        this.type = type;
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public String getRiskLevel() {
        return riskLevel;
    }

    public void setRiskLevel(String riskLevel) {
        this.riskLevel = riskLevel;
    }

    public String getEstablishWay() {
        return establishWay;
    }

    public void setEstablishWay(String establishWay) {
        this.establishWay = establishWay;
    }

    public String getDataSrc() {
        return dataSrc;
    }

    public void setDataSrc(String dataSrc) {
        this.dataSrc = dataSrc;
    }
}