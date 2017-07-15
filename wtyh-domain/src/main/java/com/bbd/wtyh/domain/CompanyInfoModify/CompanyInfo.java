package com.bbd.wtyh.domain.CompanyInfoModify;

import com.bbd.wtyh.domain.CompanyDO;

/**
 * Created by YanWenyuan on 2017/7/14.
 */
public class CompanyInfo{
    // 公司类型
    // 1:P2P 2:小贷 3:融资担保 4:线下理财 5:私募基金 6:众筹
    // 7:金融 8:其他 9:交易所 10:商业保理 11.预付卡 12.典当 13融资租赁
    public static final byte TYPE_P2P_1 = 1;
    public static final byte TYPE_XD_2 = 2;
    public static final byte TYPE_RZDB_3 = 3;
    public static final byte TYPE_XXLC_4 = 4;
    public static final byte TYPE_SMJJ_5 = 5;
    public static final byte TYPE_ZC_6 = 6;
    public static final byte TYPE_JR_7 = 7;
    public static final byte TYPE_QT_8 = 8;
    public static final byte TYPE_JYS_9 = 9;
    public static final byte TYPE_SYBL_10 = 10;
    public static final byte TYPE_YFK_11 = 11;
    public static final byte TYPE_DD_12 = 12;
    public static final byte TYPE_RZZL_13 = 13;

    private String name; // 公司名
    private String legalPerson; // 法人
    private String registeredCapital;   // 注册资本
    private Byte industry;    // 行业
    private String currentLevel;  // 当前状态
    private String outLevel;   // 外部评级 - 小额贷款、融资担保
    private String innnerLevel;    // 内部评级 - 小额贷款、融资担保
    private String liveLevel;  // 现场检查 - 小额贷款、融资担保

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLegalPerson() {
        return legalPerson;
    }

    public void setLegalPerson(String legalPerson) {
        this.legalPerson = legalPerson;
    }

    public String getRegisteredCapital() {
        return registeredCapital;
    }

    public void setRegisteredCapital(String registeredCapital) {
        this.registeredCapital = registeredCapital;
    }

    public Byte getIndustry() {
        return industry;
    }

    public void setIndustry(Byte industry) {
        this.industry = industry;
    }

    public String getCurrentLevel() {
        return currentLevel;
    }

    public void setCurrentLevel(String currentLevel) {
        this.currentLevel = currentLevel;
    }

    public String getOutLevel() {
        return outLevel;
    }

    public void setOutLevel(String outLevel) {
        this.outLevel = outLevel;
    }

    public String getInnnerLevel() {
        return innnerLevel;
    }

    public void setInnnerLevel(String innnerLevel) {
        this.innnerLevel = innnerLevel;
    }

    public String getLiveLevel() {
        return liveLevel;
    }

    public void setLiveLevel(String liveLevel) {
        this.liveLevel = liveLevel;
    }
}
