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
    private float realControlRiskV2;
    //非法融资衍生风险
    private float illegalFinancingRiskV2;
    //短期逐利风险
    private float shortRiskV2;
    //非法融资违规风险
    private float illegalMoneyFinancingRiskV2;
    //人才结构风险
    private float personStructureRiskV2;
    //关联方中心积聚化风险
    private float relationInRiskV2;

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
        return realControlRiskV2;
    }

    public void setReal_control_risk_v2(float realControlRiskV2) {
        this.realControlRiskV2 = realControlRiskV2;
    }

    public float getIllegal_financing_risk_v2() {
        return illegalFinancingRiskV2;
    }

    public void setIllegal_financing_risk_v2(float illegalFinancingRiskV2) {
        this.illegalFinancingRiskV2 = illegalFinancingRiskV2;
    }

    public float getShort_risk_v2() {
        return shortRiskV2;
    }

    public void setShort_risk_v2(float shortRiskV2) {
        this.shortRiskV2 = shortRiskV2;
    }

    public float getIllegal_money_financing_risk_v2() {
        return illegalMoneyFinancingRiskV2;
    }

    public void setIllegal_money_financing_risk_v2(float illegalMoneyFinancingRiskV2) {
        this.illegalMoneyFinancingRiskV2 = illegalMoneyFinancingRiskV2;
    }

    public float getPerson_structure_risk_v2() {
        return personStructureRiskV2;
    }

    public void setPerson_structure_risk_v2(float personStructureRiskV2) {
        this.personStructureRiskV2 = personStructureRiskV2;
    }

    public float getRelation_in_risk_v2() {
        return relationInRiskV2;
    }

    public void setRelation_in_risk_v2(float relationInRiskV2) {
        this.relationInRiskV2 = relationInRiskV2;
    }
}
