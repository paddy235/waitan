package com.bbd.wtyh.domain.vo;

import java.util.List;


public class DynamicRiskVO {
	
	private double bbdTimeRiskIndex; // BBD时序风险
	
	private double steadyOperationRisk; //稳态运营风险
	
	private int curPersonNum; //当前自然人节点数
	
	private int curCompanyNum;// 当前企业法人节点数
	
	private int curSumNum;// 当前总节点数
	
	private int cprPersonNum; //比较自然人节点数
	
	private int cprCompanyNum;// 比较企业法人节点数
	
	private int cprSumNum;// 比较总节点数
	
	private double coreCapitalOperationRisk; //核心资本运营风险
	
	private List<String> curCorePersonList; //当前核心自然人名单
	
	private List<String> curControlNum; //当前控制节点数（各个核心自然人的控制节点数）
	
	private List<String> cprCorePersonList; //比较核心自然人名单
	
	private List<String> cprControlNum; //比较控制节点数（各个核心自然人的控制节点数）
	
	private double sustainableRisk;// 可持续风险
	
	private int curAgreeActNum; // 当前利益一致行动法人数量
	
	private float curAgreeActProp; // 当前利益一致行动法人数量占关联企业数量总和的比
	
	private List<String> curAgreeComDet; // 当前利益一致行动法人明细
	
	private int cprAgreeActNum; // 比较利益一致行动法人数量
	
	private float cprAgreeActProp; // 比较利益一致行动法人数量占关联企业数量总和的比
	
	private List<String> cprAgreeComDet; // 比较利益一致行动法人明细
	
	private double foamRisk; // 泡沫风险
	
	private int  curOneTwoComapnyNum; // 当前一度二度关联法人数量
	
	private float curOneTwoCompanyProp; //当前一度二度关联法人占比

	private int  cprOneTwoComapnyNum; //比较一度二度关联法人数量
	
	private float cprOneTwoCompanyProp; //比较一度二度关联法人占比

	private double pyramidSellingRisk;//传销风险
	
	private int curThreePersonNum; //当前三度关联方自然人数量
	
	private float curThreePersonProp; //当前三度关联方自然人占比

	private int cprThreePersonNum; //比较三度关联方自然人数量
	
	private float cprThreePersonProp; //比较三度关联方自然人占比

	private double illegalFundRaisingRisk;//非法集资违规风险
	
	private int curTypeSumNum; //当前投资，咨询，贸易，租赁和保理类公司数量
	
	private float curTypeSumProp;//当前投资，咨询，贸易，租赁和保理类公司占比
	
	private List<String> curCompanyDetail;//当前公司明细

	private int cprTypeSumNum; //比较投资，咨询，贸易，租赁和保理类公司数量
	
	private float cprTypeSumProp;//比较投资，咨询，贸易，租赁和保理类公司占比
	
	private List<String> cprCompanyDetail;//比较公司明细

	private double steadyStateOperationRisk;//稳态运行风险
	
	private List<String> curAreaList; //当前地域积聚top4省份或直辖市名单	
	
	private List<String> curAreaCompanyNum; //当前地域积聚top4省份或直辖市的企业数量
	
	private List<String> cprAreaList; //比较地域积聚top4省份或直辖市名单	
	
	private List<String> cprAreaCompanyNum; //比较地域积聚top4省份或直辖市的企业数量

	public double getBbdTimeRiskIndex() {
		return bbdTimeRiskIndex;
	}

	public void setBbdTimeRiskIndex(double bbdTimeRiskIndex) {
		this.bbdTimeRiskIndex = bbdTimeRiskIndex;
	}

	public double getSteadyOperationRisk() {
		return steadyOperationRisk;
	}

	public void setSteadyOperationRisk(double steadyOperationRisk) {
		this.steadyOperationRisk = steadyOperationRisk;
	}

	public int getCurPersonNum() {
		return curPersonNum;
	}

	public void setCurPersonNum(int curPersonNum) {
		this.curPersonNum = curPersonNum;
	}

	public int getCurCompanyNum() {
		return curCompanyNum;
	}

	public void setCurCompanyNum(int curCompanyNum) {
		this.curCompanyNum = curCompanyNum;
	}

	public int getCurSumNum() {
		return curSumNum;
	}

	public void setCurSumNum(int curSumNum) {
		this.curSumNum = curSumNum;
	}

	public int getCprPersonNum() {
		return cprPersonNum;
	}

	public void setCprPersonNum(int cprPersonNum) {
		this.cprPersonNum = cprPersonNum;
	}

	public int getCprCompanyNum() {
		return cprCompanyNum;
	}

	public void setCprCompanyNum(int cprCompanyNum) {
		this.cprCompanyNum = cprCompanyNum;
	}

	public int getCprSumNum() {
		return cprSumNum;
	}

	public void setCprSumNum(int cprSumNum) {
		this.cprSumNum = cprSumNum;
	}

	public double getCoreCapitalOperationRisk() {
		return coreCapitalOperationRisk;
	}

	public void setCoreCapitalOperationRisk(double coreCapitalOperationRisk) {
		this.coreCapitalOperationRisk = coreCapitalOperationRisk;
	}

	public List<String> getCurCorePersonList() {
		return curCorePersonList;
	}

	public void setCurCorePersonList(List<String> curCorePersonList) {
		this.curCorePersonList = curCorePersonList;
	}

	public List<String> getCurControlNum() {
		return curControlNum;
	}

	public void setCurControlNum(List<String> curControlNum) {
		this.curControlNum = curControlNum;
	}

	public List<String> getCprCorePersonList() {
		return cprCorePersonList;
	}

	public void setCprCorePersonList(List<String> cprCorePersonList) {
		this.cprCorePersonList = cprCorePersonList;
	}

	public List<String> getCprControlNum() {
		return cprControlNum;
	}

	public void setCprControlNum(List<String> cprControlNum) {
		this.cprControlNum = cprControlNum;
	}

	public double getSustainableRisk() {
		return sustainableRisk;
	}

	public void setSustainableRisk(double sustainableRisk) {
		this.sustainableRisk = sustainableRisk;
	}

	public int getCurAgreeActNum() {
		return curAgreeActNum;
	}

	public void setCurAgreeActNum(int curAgreeActNum) {
		this.curAgreeActNum = curAgreeActNum;
	}

	public float getCurAgreeActProp() {
		return curAgreeActProp;
	}

	public void setCurAgreeActProp(float curAgreeActProp) {
		this.curAgreeActProp = curAgreeActProp;
	}

	public List<String> getCurAgreeComDet() {
		return curAgreeComDet;
	}

	public void setCurAgreeComDet(List<String> curAgreeComDet) {
		this.curAgreeComDet = curAgreeComDet;
	}

	public int getCprAgreeActNum() {
		return cprAgreeActNum;
	}

	public void setCprAgreeActNum(int cprAgreeActNum) {
		this.cprAgreeActNum = cprAgreeActNum;
	}

	public float getCprAgreeActProp() {
		return cprAgreeActProp;
	}

	public void setCprAgreeActProp(float cprAgreeActProp) {
		this.cprAgreeActProp = cprAgreeActProp;
	}

	public List<String> getCprAgreeComDet() {
		return cprAgreeComDet;
	}

	public void setCprAgreeComDet(List<String> cprAgreeComDet) {
		this.cprAgreeComDet = cprAgreeComDet;
	}

	public double getFoamRisk() {
		return foamRisk;
	}

	public void setFoamRisk(double foamRisk) {
		this.foamRisk = foamRisk;
	}

	public int getCurOneTwoComapnyNum() {
		return curOneTwoComapnyNum;
	}

	public void setCurOneTwoComapnyNum(int curOneTwoComapnyNum) {
		this.curOneTwoComapnyNum = curOneTwoComapnyNum;
	}

	public float getCurOneTwoCompanyProp() {
		return curOneTwoCompanyProp;
	}

	public void setCurOneTwoCompanyProp(float curOneTwoCompanyProp) {
		this.curOneTwoCompanyProp = curOneTwoCompanyProp;
	}

	public int getCprOneTwoComapnyNum() {
		return cprOneTwoComapnyNum;
	}

	public void setCprOneTwoComapnyNum(int cprOneTwoComapnyNum) {
		this.cprOneTwoComapnyNum = cprOneTwoComapnyNum;
	}

	public float getCprOneTwoCompanyProp() {
		return cprOneTwoCompanyProp;
	}

	public void setCprOneTwoCompanyProp(float cprOneTwoCompanyProp) {
		this.cprOneTwoCompanyProp = cprOneTwoCompanyProp;
	}

	public double getPyramidSellingRisk() {
		return pyramidSellingRisk;
	}

	public void setPyramidSellingRisk(double pyramidSellingRisk) {
		this.pyramidSellingRisk = pyramidSellingRisk;
	}

	public int getCurThreePersonNum() {
		return curThreePersonNum;
	}

	public void setCurThreePersonNum(int curThreePersonNum) {
		this.curThreePersonNum = curThreePersonNum;
	}

	public float getCurThreePersonProp() {
		return curThreePersonProp;
	}

	public void setCurThreePersonProp(float curThreePersonProp) {
		this.curThreePersonProp = curThreePersonProp;
	}

	public int getCprThreePersonNum() {
		return cprThreePersonNum;
	}

	public void setCprThreePersonNum(int cprThreePersonNum) {
		this.cprThreePersonNum = cprThreePersonNum;
	}

	public float getCprThreePersonProp() {
		return cprThreePersonProp;
	}

	public void setCprThreePersonProp(float cprThreePersonProp) {
		this.cprThreePersonProp = cprThreePersonProp;
	}


	public double getIllegalFundRaisingRisk() {
		return illegalFundRaisingRisk;
	}

	public void setIllegalFundRaisingRisk(double illegalFundRaisingRisk) {
		this.illegalFundRaisingRisk = illegalFundRaisingRisk;
	}

	public int getCurTypeSumNum() {
		return curTypeSumNum;
	}

	public void setCurTypeSumNum(int curTypeSumNum) {
		this.curTypeSumNum = curTypeSumNum;
	}

	public float getCurTypeSumProp() {
		return curTypeSumProp;
	}

	public void setCurTypeSumProp(float curTypeSumProp) {
		this.curTypeSumProp = curTypeSumProp;
	}

	public List<String> getCurCompanyDetail() {
		return curCompanyDetail;
	}

	public void setCurCompanyDetail(List<String> curCompanyDetail) {
		this.curCompanyDetail = curCompanyDetail;
	}

	public int getCprTypeSumNum() {
		return cprTypeSumNum;
	}

	public void setCprTypeSumNum(int cprTypeSumNum) {
		this.cprTypeSumNum = cprTypeSumNum;
	}

	public float getCprTypeSumProp() {
		return cprTypeSumProp;
	}

	public void setCprTypeSumProp(float cprTypeSumProp) {
		this.cprTypeSumProp = cprTypeSumProp;
	}

	public List<String> getCprCompanyDetail() {
		return cprCompanyDetail;
	}

	public void setCprCompanyDetail(List<String> cprCompanyDetail) {
		this.cprCompanyDetail = cprCompanyDetail;
	}

	public double getSteadyStateOperationRisk() {
		return steadyStateOperationRisk;
	}

	public void setSteadyStateOperationRisk(double steadyStateOperationRisk) {
		this.steadyStateOperationRisk = steadyStateOperationRisk;
	}

	public List<String> getCurAreaList() {
		return curAreaList;
	}

	public void setCurAreaList(List<String> curAreaList) {
		this.curAreaList = curAreaList;
	}

	public List<String> getCurAreaCompanyNum() {
		return curAreaCompanyNum;
	}

	public void setCurAreaCompanyNum(List<String> curAreaCompanyNum) {
		this.curAreaCompanyNum = curAreaCompanyNum;
	}

	public List<String> getCprAreaList() {
		return cprAreaList;
	}

	public void setCprAreaList(List<String> cprAreaList) {
		this.cprAreaList = cprAreaList;
	}

	public List<String> getCprAreaCompanyNum() {
		return cprAreaCompanyNum;
	}

	public void setCprAreaCompanyNum(List<String> cprAreaCompanyNum) {
		this.cprAreaCompanyNum = cprAreaCompanyNum;
	}
	
	
}
