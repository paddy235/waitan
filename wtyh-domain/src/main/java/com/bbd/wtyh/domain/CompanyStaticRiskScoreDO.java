package com.bbd.wtyh.domain;

/**
 * 线下理财企业信息指标实体类
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

public class CompanyStaticRiskScoreDO {

    //公司id
    private Integer companyId;
    //公司名称
    private String name;
    //实际控制人风险
    private float real_control_risk_v2;
    //非法融资衍生风险
    private float illegal_financing_risk_v2;
    //短期逐利风险
    private float short_risk_v2;
    //非法融资违规风险
    private float illegal_money_financing_risk_v2;
    //人才结构风险
    private float person_structure_risk_v2;
    //关联方中心积聚化风险
    private float relation_in_risk_v2;

    public Integer getCompanyId() {
        return companyId;
    }

    public void setCompanyId(Integer companyId) {
        this.companyId = companyId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public float getReal_control_risk_v2() {
        return real_control_risk_v2;
    }

    public void setReal_control_risk_v2(float real_control_risk_v2) {
        this.real_control_risk_v2 = real_control_risk_v2;
    }

    public float getIllegal_financing_risk_v2() {
        return illegal_financing_risk_v2;
    }

    public void setIllegal_financing_risk_v2(float illegal_financing_risk_v2) {
        this.illegal_financing_risk_v2 = illegal_financing_risk_v2;
    }

    public float getShort_risk_v2() {
        return short_risk_v2;
    }

    public void setShort_risk_v2(float short_risk_v2) {
        this.short_risk_v2 = short_risk_v2;
    }

    public float getIllegal_money_financing_risk_v2() {
        return illegal_money_financing_risk_v2;
    }

    public void setIllegal_money_financing_risk_v2(float illegal_money_financing_risk_v2) {
        this.illegal_money_financing_risk_v2 = illegal_money_financing_risk_v2;
    }

    public float getPerson_structure_risk_v2() {
        return person_structure_risk_v2;
    }

    public void setPerson_structure_risk_v2(float person_structure_risk_v2) {
        this.person_structure_risk_v2 = person_structure_risk_v2;
    }

    public float getRelation_in_risk_v2() {
        return relation_in_risk_v2;
    }

    public void setRelation_in_risk_v2(float relation_in_risk_v2) {
        this.relation_in_risk_v2 = relation_in_risk_v2;
    }
}
