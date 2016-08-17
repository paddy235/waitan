package com.bbd.data.mapper;

import java.util.Date;

/**
 * Created by wangchenge on 2016/8/17 0017.
 */
public class OrderTable {

    private Integer id;
    private String waterId;
    private Date buyTime;
    private String surveyFirmName;
    private String buyStaut;
    private String customerProvince;
    private String balance;
    private String money;
    private String customerId;
    private String level;
    private String modify;
    private String nodeCount;
    private int group1;
    private int group2;
    private int addChance;
    private String registeredNo; // 注册号
    private String socialNo; // 统一社会信用代码
    private String cacheStatus;
    private int forTheBid;
    private Date deadlines;
    private int buyType;//购买类型：0：增送 1：购买 2：共享 3：升级 4：续费

    public int getBuyType() {
        return buyType;
    }

    public void setBuyType(int buyType) {
        this.buyType = buyType;
    }

    public Integer getId() {
        return this.id;
    }

    public void setId(Integer id) {
        this.id = id;
    }


    public String getWaterId() {
        return this.waterId;
    }

    public void setWaterId(String waterId) {
        this.waterId = waterId;
    }


    public Date getBuyTime() {
        return this.buyTime;
    }

    public void setBuyTime(Date buyTime) {
        this.buyTime = buyTime;
    }


    public String getSurveyFirmName() {
        return this.surveyFirmName;
    }

    public void setSurveyFirmName(String surveyFirmName) {
        this.surveyFirmName = surveyFirmName;
    }


    public String getBuyStaut() {
        return this.buyStaut;
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

    public String getBalance() {
        return this.balance;
    }

    public void setBalance(String balance) {
        this.balance = balance;
    }


    public String getMoney() {
        return this.money;
    }

    public void setMoney(String money) {
        this.money = money;
    }


    public String getCustomerId() {
        return this.customerId;
    }

    public void setCustomerId(String customerId) {
        this.customerId = customerId;
    }


    public String getLevel() {
        return this.level;
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

    public int getGroup1() {
        return group1;
    }

    public void setGroup1(int group1) {
        this.group1 = group1;
    }

    public int getGroup2() {
        return group2;
    }

    public void setGroup2(int group2) {
        this.group2 = group2;
    }

    public int getAddChance() {
        return addChance;
    }

    public void setAddChance(int addChance) {
        this.addChance = addChance;
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

    public String getCacheStatus() {
        return cacheStatus;
    }

    public void setCacheStatus(String cacheStatus) {
        this.cacheStatus = cacheStatus;
    }

    public int getForTheBid() {
        return forTheBid;
    }

    public void setForTheBid(int forTheBid) {
        this.forTheBid = forTheBid;
    }

    public Date getDeadlines() {
        return deadlines;
    }

    public void setDeadlines(Date deadlines) {
        this.deadlines = deadlines;
    }
}
