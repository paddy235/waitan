package com.bbd.wtyh.domain.vo;

import java.math.BigDecimal;
import java.util.Date;

/**
 * Created by Administrator on 2016/8/16 0016.
 */
public class OrderPO {
    private Integer id;
    private String waterId;
    private Date buyTime;
    private String surveyFirmName;
    private String buyStaut;
    private String customerProvince;
    private BigDecimal balance;
    private BigDecimal money;
    private String customerId;
    private String level;
    private String modify;
    private String nodeCount;
    private String group1;
    private String group2;
    private String lawsuitCount;
    private String payUser;

    private BigDecimal orgBalance;

    private Integer investmentRel; // 投资关联
    private Integer shareholderRel; // 股东关联
    private Integer forTheBid; // 招标、中标总数
    private BigDecimal regCapital; // 注册资本
    private String updateMark; // 是否有更新（0：否；1：是）
    private String checkMark; // 是否已查看（0：否；1：是）
    private String signMark; // 是否已标记（0：否；1：是）
    private String removeMark; // 是否已移除（0：否；1：是）
    private Date insertDate; // 订单加入时间
    private String registeredNo; // 注册号
    private String socialNo; // 统一社会信用代码
    private String formerName; // 曾用名（多个用“、”分隔）
    private String cacheStatus; //文件缓存状态

    private String regCapitalStr;

    private Date deadlines;
    private String classificationName;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getWaterId() {
        return waterId;
    }

    public void setWaterId(String waterId) {
        this.waterId = waterId;
    }

    public Date getBuyTime() {
        return buyTime;
    }

    public void setBuyTime(Date buyTime) {
        this.buyTime = buyTime;
    }

    public String getSurveyFirmName() {
        return surveyFirmName;
    }

    public void setSurveyFirmName(String surveyFirmName) {
        this.surveyFirmName = surveyFirmName;
    }

    public String getBuyStaut() {
        return buyStaut;
    }

    public void setBuyStaut(String buyStaut) {
        this.buyStaut = buyStaut;
    }

    public String getCustomerProvince() {
        return customerProvince;
    }

    public void setCustomerProvince(String customerProvince) {
        this.customerProvince = customerProvince;
    }

    public BigDecimal getBalance() {
        return balance;
    }

    public void setBalance(BigDecimal balance) {
        this.balance = balance;
    }

    public BigDecimal getMoney() {
        return money;
    }

    public void setMoney(BigDecimal money) {
        this.money = money;
    }

    public String getCustomerId() {
        return customerId;
    }

    public void setCustomerId(String customerId) {
        this.customerId = customerId;
    }

    public String getLevel() {
        return level;
    }

    public void setLevel(String level) {
        this.level = level;
    }

    public String getModify() {
        return modify;
    }

    public void setModify(String modify) {
        this.modify = modify;
    }

    public String getNodeCount() {
        return nodeCount;
    }

    public void setNodeCount(String nodeCount) {
        this.nodeCount = nodeCount;
    }

    public String getGroup1() {
        return group1;
    }

    public void setGroup1(String group1) {
        this.group1 = group1;
    }

    public String getGroup2() {
        return group2;
    }

    public void setGroup2(String group2) {
        this.group2 = group2;
    }

    public String getLawsuitCount() {
        return lawsuitCount;
    }

    public void setLawsuitCount(String lawsuitCount) {
        this.lawsuitCount = lawsuitCount;
    }

    public BigDecimal getOrgBalance() {
        return orgBalance;
    }

    public void setOrgBalance(BigDecimal orgBalance) {
        this.orgBalance = orgBalance;
    }

    public Integer getInvestmentRel() {
        return investmentRel;
    }

    public void setInvestmentRel(Integer investmentRel) {
        this.investmentRel = investmentRel;
    }

    public Integer getShareholderRel() {
        return shareholderRel;
    }

    public void setShareholderRel(Integer shareholderRel) {
        this.shareholderRel = shareholderRel;
    }

    public Integer getForTheBid() {
        return forTheBid;
    }

    public void setForTheBid(Integer forTheBid) {
        this.forTheBid = forTheBid;
    }

    public BigDecimal getRegCapital() {
        return regCapital;
    }

    public void setRegCapital(BigDecimal regCapital) {
        this.regCapital = regCapital;
    }

    public String getUpdateMark() {
        return updateMark;
    }

    public void setUpdateMark(String updateMark) {
        this.updateMark = updateMark;
    }

    public String getCheckMark() {
        return checkMark;
    }

    public void setCheckMark(String checkMark) {
        this.checkMark = checkMark;
    }

    public String getSignMark() {
        return signMark;
    }

    public void setSignMark(String signMark) {
        this.signMark = signMark;
    }

    public String getRemoveMark() {
        return removeMark;
    }

    public void setRemoveMark(String removeMark) {
        this.removeMark = removeMark;
    }

    public Date getInsertDate() {
        return insertDate;
    }

    public void setInsertDate(Date insertDate) {
        this.insertDate = insertDate;
    }

    public String getRegisteredNo() {
        return registeredNo;
    }

    public void setRegisteredNo(String registeredNo) {
        this.registeredNo = registeredNo;
    }

    public String getSocialNo() {
        return socialNo;
    }

    public void setSocialNo(String socialNo) {
        this.socialNo = socialNo;
    }

    public String getFormerName() {
        return formerName;
    }

    public void setFormerName(String formerName) {
        this.formerName = formerName;
    }

    public String getCacheStatus() {
        return cacheStatus;
    }

    public void setCacheStatus(String cacheStatus) {
        this.cacheStatus = cacheStatus;
    }

    public String getRegCapitalStr() {
        return regCapitalStr;
    }

    public void setRegCapitalStr(String regCapitalStr) {
        this.regCapitalStr = regCapitalStr;
    }

    public Date getDeadlines() {
        return deadlines;
    }

    public void setDeadlines(Date deadlines) {
        this.deadlines = deadlines;
    }

    public String getClassificationName() {
        return classificationName;
    }

    public void setClassificationName(String classificationName) {
        this.classificationName = classificationName;
    }

    public String getPayUser() {
        return payUser;
    }

    public void setPayUser(String payUser) {
        this.payUser = payUser;
    }
}
