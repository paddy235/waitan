package com.bbd.wtyh.domain.CompanyInfoModify;


/**
 * Created by YanWenyuan on 2017/7/14.
 */
public class CompanyInfo {
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

    public static final byte TYPE_WT_30 = 30;//外滩网络借贷
    public static final byte TYPE_WT_31 = 31;//外滩众筹
    public static final byte TYPE_WT_32 = 32;//外滩网银
    public static final byte TYPE_WT_33 = 33;//外滩支付
    public static final byte TYPE_WT_34 = 34;//外滩预付卡
    public static final byte TYPE_WT_35 = 35;//外滩融资租赁

    private Integer companyId;
    private String name; // 公司名
    private String legalPerson; // 法人
    private String registeredCapital;   // 注册资本
    private Integer registeredCapitalType;  //注册资本类型 1:人民币 2:美元
    private Byte industry;    // 行业
    private String currentLevel;  // 当前状态

    // 网络贷款
    private String originalStatus;
    private String platName;

    // 小额贷款、融资担保
    private String outLevel;   // 外部评级 -
    private String innnerLevel;    // 内部评级 - 【小额贷款、融资担保】
    private String liveLevel;  // 现场检查 - 【小额贷款、融资担保】

    public Integer getCompanyId() {
        return companyId;
    }

    public void setCompanyId(Integer companyId) {
        this.companyId = companyId;
    }

    public String getPlatName() {
        return platName;
    }

    public void setPlatName(String platName) {
        this.platName = platName;
    }

    public Integer getRegisteredCapitalType() {
        return registeredCapitalType;
    }

    public void setRegisteredCapitalType(Integer registeredCapitalType) {
        this.registeredCapitalType = registeredCapitalType;
    }

    public String getOriginalStatus() {
        return originalStatus;
    }

    public void setOriginalStatus(String originalStatus) {
        this.originalStatus = originalStatus;
    }

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

    public static String companyTypeCN(Byte industry) {
        if (null == industry) {
            return "";
        }
        switch (industry) {
            case TYPE_P2P_1:
                return "网络借贷";
            case TYPE_XD_2:
                return "小额贷款";
            case TYPE_RZDB_3:
                return "融资担保";
            case TYPE_XXLC_4:
                return "线下理财";
            case TYPE_SMJJ_5:
                return "私募基金";
            case TYPE_ZC_6:
                return "众筹";
            case TYPE_JR_7:
                return "金融";
            case TYPE_QT_8:
                return "其他";
            case TYPE_JYS_9:
                return "交易场所";
            case TYPE_SYBL_10:
                return "商业保理";
            case TYPE_YFK_11:
                return "预付卡";
            case TYPE_DD_12:
                return "典当";
            case TYPE_RZZL_13:
                return "融资租赁";
            case TYPE_WT_30:
                return "外滩网络借贷";
            case TYPE_WT_31:
                return "外滩众筹";
            case TYPE_WT_32:
                return "外滩网银";
            case TYPE_WT_33:
                return "外滩支付";
            case TYPE_WT_34:
                return "外滩预付卡";
            case TYPE_WT_35:
                return "外滩融资租赁";
            default:
                return "";

        }
    }

    public static Byte companyType(String industry) {
        if (null == industry) {
            return null;
        }
        switch (industry) {
            case "网络借贷":
                return TYPE_P2P_1;
            case "小额贷款":
                return TYPE_XD_2;
            case "融资担保":
                return TYPE_RZDB_3;
            case "线下理财":
                return TYPE_XXLC_4;
            case "私募基金":
                return TYPE_SMJJ_5;
            case "众筹":
                return TYPE_ZC_6;
            case "金融":
                return TYPE_JR_7;
            case "其他":
                return TYPE_QT_8;
            case "交易场所":
                return TYPE_JYS_9;
            case "商业保理":
                return TYPE_SYBL_10;
            case "预付卡":
                return TYPE_YFK_11;
            case "典当":
                return TYPE_DD_12;
            case "融资租赁":
                return TYPE_RZZL_13;
            case "外滩网络借贷":
                return TYPE_WT_30;
            case "外滩众筹":
                return TYPE_WT_31;
            case "外滩网银":
                return TYPE_WT_32;
            case "外滩支付":
                return TYPE_WT_33;
            case "外滩预付卡":
                return TYPE_WT_34;
            case "外滩融资租赁":
                return TYPE_WT_35;
            case "外滩线下理财企业"://源数据是这样
                return TYPE_XXLC_4;
            default:
                return null;

        }
    }
}
