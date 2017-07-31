package com.bbd.wtyh.web.EasyExportExcel;

import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

/**
 * Created by YanWenyuan on 2017/7/18.
 */
public class ExportCondition {
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

    private Byte industry;    // 行业
    private String currentLevel;  // 当前状态
    // 网络贷款
    private String originalStatus;
    // 小额贷款、融资担保
    private String outLevel;   // 外部评级
    private String innnerLevel;    // 内部评级
    private String liveLevel;  // 现场检查

    private String registeredCapitalMin;   // 注册资本
    private String registeredCapitalMax;   // 注册资本
    private Integer registeredCapitalType;  //注册资本类型 1:人民币 2:美元
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date registeredDateMin;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date registeredDateMax;
    private Integer areaId;

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

    public String getOriginalStatus() {
        return originalStatus;
    }

    public void setOriginalStatus(String originalStatus) {
        this.originalStatus = originalStatus;
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

    public String getRegisteredCapitalMin() {
        return registeredCapitalMin;
    }

    public void setRegisteredCapitalMin(String registeredCapitalMin) {
        this.registeredCapitalMin = registeredCapitalMin;
    }

    public String getRegisteredCapitalMax() {
        return registeredCapitalMax;
    }

    public void setRegisteredCapitalMax(String registeredCapitalMax) {
        this.registeredCapitalMax = registeredCapitalMax;
    }

    public Integer getRegisteredCapitalType() {
        return registeredCapitalType;
    }

    public void setRegisteredCapitalType(Integer registeredCapitalType) {
        this.registeredCapitalType = registeredCapitalType;
    }

    public Date getRegisteredDateMin() {
        return registeredDateMin;
    }

    public void setRegisteredDateMin(Date registeredDateMin) {
        this.registeredDateMin = registeredDateMin;
    }

    public Date getRegisteredDateMax() {
        return registeredDateMax;
    }

    public void setRegisteredDateMax(Date registeredDateMax) {
        this.registeredDateMax = registeredDateMax;
    }

    public Integer getAreaId() {
        return areaId;
    }

    public void setAreaId(Integer areaId) {
        this.areaId = areaId;
    }
}
