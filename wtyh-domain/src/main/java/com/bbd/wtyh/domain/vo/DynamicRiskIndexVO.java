package com.bbd.wtyh.domain.vo;

import java.util.Date;
import java.util.List;


public class DynamicRiskIndexVO {

	private String companyName; // 公司名称
	private String dataVersion; // 数据版本
	private Date riskDate; // 风险时间
	private float bbdTimeRiskIndex; // BBD时序风险
	private int personNum; //自然人节点总数
	private int companyNum;//企业法人节点总数
	private int sumNum;//总节点数
	private String corePerList; //核心自然人名单
	private String controlNum; //控制节点数（各个核心自然人控制节点数）
	private int agreeActNum; // 利益一致行动法人数量
	private float agreeActProp; // 利益一致行动法人数量占关联企业数量总和的比
	private String agreeComDet; // 利益一致行动法人明细
	private int oneTwoCompanyNum;//一度二度关联法人数量
	private float oneTwoCompanyProp;//一度二度关联法人占比
	private int threePersonNum;//三度关联自然人数量
	private float threePersonProp; //三度关联自然人占比
	private int typeSumNum; // 投资，咨询，贸易，租赁和保理类公司数量
	private float typeSumProp; // 投资，咨询，贸易，租赁和保理类公司占比
	private String companyDetail; // 公司明细
	private String areaList; // 关联企业分布最多的四个省份或直辖市，企业数量和
	private String areaCompanyNum; //地域积聚top4省份或直辖市的企业数量
	public String getCompanyName() {
		return companyName;
	}
	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}
	public String getDataVersion() {
		return dataVersion;
	}
	public void setDataVersion(String dataVersion) {
		this.dataVersion = dataVersion;
	}
	public Date getRiskDate() {
		return riskDate;
	}
	public void setRiskDate(Date riskDate) {
		this.riskDate = riskDate;
	}
	public float getBbdTimeRiskIndex() {
		return bbdTimeRiskIndex;
	}
	public void setBbdTimeRiskIndex(float bbdTimeRiskIndex) {
		this.bbdTimeRiskIndex = bbdTimeRiskIndex;
	}
	public int getPersonNum() {
		return personNum;
	}
	public void setPersonNum(int personNum) {
		this.personNum = personNum;
	}
	public int getCompanyNum() {
		return companyNum;
	}
	public void setCompanyNum(int companyNum) {
		this.companyNum = companyNum;
	}
	public int getSumNum() {
		return sumNum;
	}
	public void setSumNum(int sumNum) {
		this.sumNum = sumNum;
	}
	public String getCorePerList() {
		return corePerList;
	}
	public void setCorePerList(String corePerList) {
		this.corePerList = corePerList;
	}
	public String getControlNum() {
		return controlNum;
	}
	public void setControlNum(String controlNum) {
		this.controlNum = controlNum;
	}
	public int getAgreeActNum() {
		return agreeActNum;
	}
	public void setAgreeActNum(int agreeActNum) {
		this.agreeActNum = agreeActNum;
	}
	public float getAgreeActProp() {
		return agreeActProp;
	}
	public void setAgreeActProp(float agreeActProp) {
		this.agreeActProp = agreeActProp;
	}
	public String getAgreeComDet() {
		return agreeComDet;
	}
	public void setAgreeComDet(String agreeComDet) {
		this.agreeComDet = agreeComDet;
	}
	public int getOneTwoCompanyNum() {
		return oneTwoCompanyNum;
	}
	public void setOneTwoCompanyNum(int oneTwoCompanyNum) {
		this.oneTwoCompanyNum = oneTwoCompanyNum;
	}
	public float getOneTwoCompanyProp() {
		return oneTwoCompanyProp;
	}
	public void setOneTwoCompanyProp(float oneTwoCompanyProp) {
		this.oneTwoCompanyProp = oneTwoCompanyProp;
	}
	public int getThreePersonNum() {
		return threePersonNum;
	}
	public void setThreePersonNum(int threePersonNum) {
		this.threePersonNum = threePersonNum;
	}
	public float getThreePersonProp() {
		return threePersonProp;
	}
	public void setThreePersonProp(float threePersonProp) {
		this.threePersonProp = threePersonProp;
	}
	public int getTypeSumNum() {
		return typeSumNum;
	}
	public void setTypeSumNum(int typeSumNum) {
		this.typeSumNum = typeSumNum;
	}
	public float getTypeSumProp() {
		return typeSumProp;
	}
	public void setTypeSumProp(float typeSumProp) {
		this.typeSumProp = typeSumProp;
	}
	public String getCompanyDetail() {
		return companyDetail;
	}
	public void setCompanyDetail(String companyDetail) {
		this.companyDetail = companyDetail;
	}
	public String getAreaList() {
		return areaList;
	}
	public void setAreaList(String areaList) {
		this.areaList = areaList;
	}
	public String getAreaCompanyNum() {
		return areaCompanyNum;
	}
	public void setAreaCompanyNum(String areaCompanyNum) {
		this.areaCompanyNum = areaCompanyNum;
	}
	
}
