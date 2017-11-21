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

public class SubIndexDO {

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
    //上海非正常户认定
    private int V1;
    //上海用人单位欠缴社会保险费
    private int V2;
    //上海失信曝光
    private int V3;
    //上海市场监管类行政处罚
    private int V4;

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

    public int getV1() {
        return V1;
    }

    public void setV1(int v1) {
        V1 = v1;
    }

    public int getV2() {
        return V2;
    }

    public void setV2(int v2) {
        V2 = v2;
    }

    public int getV3() {
        return V3;
    }

    public void setV3(int v3) {
        V3 = v3;
    }

    public int getV4() {
        return V4;
    }

    public void setV4(int v4) {
        V4 = v4;
    }
}
