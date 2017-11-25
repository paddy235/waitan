package com.bbd.wtyh.domain;

/**
 * 线下理财企业信息子指标实体类
 * Created by puyuan on 2017/11/16
 * c.company_id ,
 c.name ,
 s.real_control_risk_v2 ,
 s.illegal_financing_risk_v2 ,
 s.short_risk_v2 ,
 s.illegal_money_financing_risk_v2 ,
 s.person_structure_risk_v2 ,
 s.relation_in_risk_v2
 */

public class BbdSubIndexDO {
    //实际控制人风险指标
    private float real_control_risk;

    //非法融资衍生风险指标
    private float illegal_financing_risk;

    //短期逐利风险指标
    private float short_risk;

    //非法融资违规风险指标
    private float illegal_money_financing_risk;

    //人才结构风险指标
    private float person_structure_risk;

    //关联方中心积聚化风险
    private float relation_in_risk;

    //最新的时间
    private String newDataVersion;

    //公司名称
    private  String companyName;

    public String getNewDataVersion() {
        return newDataVersion;
    }

    public void setNewDataVersion(String newDataVersion) {
        this.newDataVersion = newDataVersion;
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public float getReal_control_risk() {
        return real_control_risk;
    }

    public void setReal_control_risk(float real_control_risk) {
        this.real_control_risk = real_control_risk;
    }

    public float getIllegal_financing_risk() {
        return illegal_financing_risk;
    }

    public void setIllegal_financing_risk(float illegal_financing_risk) {
        this.illegal_financing_risk = illegal_financing_risk;
    }

    public float getShort_risk() {
        return short_risk;
    }

    public void setShort_risk(float short_risk) {
        this.short_risk = short_risk;
    }

    public float getIllegal_money_financing_risk() {
        return illegal_money_financing_risk;
    }

    public void setIllegal_money_financing_risk(float illegal_money_financing_risk) {
        this.illegal_money_financing_risk = illegal_money_financing_risk;
    }

    public float getPerson_structure_risk() {
        return person_structure_risk;
    }

    public void setPerson_structure_risk(float person_structure_risk) {
        this.person_structure_risk = person_structure_risk;
    }

    public float getRelation_in_risk() {
        return relation_in_risk;
    }

    public void setRelation_in_risk(float relation_in_risk) {
        this.relation_in_risk = relation_in_risk;
    }
}
