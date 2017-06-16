package com.bbd.wtyh.domain;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.math.BigDecimal;
import java.util.Date;

@SuppressWarnings("serial")
public class CompanyDO extends BaseDO implements Comparable {

	// 公司类型 1:P2P 2:小贷 3:融资担保 4:线下理财 5:私募基金 6:众筹 7:金融 8:其他 9:交易所 10:商业保理 11.预付卡
	// 12.典当 13融资租赁
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

	private Integer companyId;

	private String name = "";

	private String legalPerson = "";

	private Integer areaId;

	private String address = "";

	private Integer registeredCapital;

	private Integer registeredCapitalType;

	@JsonFormat(pattern = "yyyy-MM-dd", timezone = "GMT+8")
	private Date registeredDate;

	private Byte companyType;

	@SuppressWarnings("unused")
	private String comTypeCN = "";

	private Byte status;

	private Byte background;

	@SuppressWarnings("unused")
	private String backgroundCN = "";

	private String registeredType = "";

	private String businessType = "";

	private BigDecimal staticRisk;

	private Date exposureDate;

	private Integer analysisResult;

	// 公司风险等级
	private Integer riskLevel;

	// 平台名称
	private String platName = "";

	private String creditCode;

	private String organizationCode;

	public String getPlatName() {
		return platName;
	}

	public void setPlatName(String platName) {
		this.platName = platName;
	}

	public void setBackgroundCN(String backgroundCN) {
		this.backgroundCN = backgroundCN;
	}

	public Date getExposureDate() {
		return exposureDate;
	}

	public void setExposureDate(Date exposureDate) {
		this.exposureDate = exposureDate;
	}

	public Integer getAnalysisResult() {
		return analysisResult;
	}

	public void setAnalysisResult(Integer analysisResult) {
		this.analysisResult = analysisResult;
	}

	public String getBackgroundCN() {
		if (null == background) {
			return "";
		}
		return CompanyBackgroundDO.Bg.getBg(this.background).CN;
	}

	public static String companyTypeCN(Byte companyType) {
		if (null == companyType) {
			return "";
		}
		switch (companyType) {
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
		default:
			return "";
		}
	}

	public static byte companyType(String name) {
		if (null == name) {
			return -1;
		}
		switch (name) {
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
			default:
				return -1;
		}
	}

	public String getComTypeCN() {
		return companyTypeCN(this.companyType);
	}

	public String getRegisteredType() {
		return registeredType;
	}

	public void setRegisteredType(String registeredType) {
		this.registeredType = registeredType;
	}

	public void setComTypeCN(String comTypeCN) {
		this.comTypeCN = comTypeCN;
	}

	public Byte getBackground() {
		return background;
	}

	public void setBackground(Byte background) {
		this.background = background;
	}

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
		this.name = name == null ? null : name.trim();
	}

	public String getLegalPerson() {
		return legalPerson;
	}

	public void setLegalPerson(String legalPerson) {
		this.legalPerson = legalPerson == null ? "" : legalPerson.trim();
	}

	public Integer getAreaId() {
		return areaId;
	}

	public void setAreaId(Integer areaId) {
		this.areaId = areaId;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address == null ? null : address.trim();
	}

	public Integer getRegisteredCapital() {
		return registeredCapital;
	}

	public void setRegisteredCapital(Integer registeredCapital) {
		this.registeredCapital = registeredCapital;
	}

	public Date getRegisteredDate() {
		return registeredDate;
	}

	public void setRegisteredDate(Date registeredDate) {
		this.registeredDate = registeredDate;
	}

	public Byte getCompanyType() {
		return companyType;
	}

	public void setCompanyType(Byte companyType) {
		this.companyType = companyType;
	}

	public Integer getRegisteredCapitalType() {
		return registeredCapitalType;
	}

	public void setRegisteredCapitalType(Integer registeredCapitalType) {
		this.registeredCapitalType = registeredCapitalType;
	}

	public Byte getStatus() {
		return status;
	}

	public void setStatus(Byte status) {
		this.status = status;
	}

	public String getBusinessType() {
		return businessType;
	}

	public void setBusinessType(String businessType) {
		this.businessType = businessType;
	}

	public Integer getRiskLevel() {
		return riskLevel;
	}

	public void setRiskLevel(Integer riskLevel) {
		this.riskLevel = riskLevel;
	}

	public BigDecimal getStaticRisk() {
		if (null != staticRisk) {
			return staticRisk.divide(BigDecimal.ONE, 1, BigDecimal.ROUND_HALF_UP);
		}
		return staticRisk;
	}

	public void setStaticRisk(BigDecimal staticRisk) {
		this.staticRisk = staticRisk;
	}

	@Override
	public int compareTo(Object o) {

		return -1;
	}

	public String getCreditCode() {
		return creditCode;
	}

	public void setCreditCode(String creditCode) {
		this.creditCode = creditCode;
	}

	public String getOrganizationCode() {
		return organizationCode;
	}

	public void setOrganizationCode(String organizationCode) {
		this.organizationCode = organizationCode;
	}
}