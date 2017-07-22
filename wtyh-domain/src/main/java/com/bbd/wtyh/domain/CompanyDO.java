package com.bbd.wtyh.domain;

import com.fasterxml.jackson.annotation.JsonFormat;

import javax.persistence.Column;
import javax.persistence.Table;
import java.math.BigDecimal;
import java.util.Date;

@SuppressWarnings("serial")
@Table(name = "company")
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

	//企业ID
	@Column(name = "company_id")
	private Integer companyId;

	//统一社会信用代码
	@Column(name = "company_id")
	private String creditCode;

	//企业名称
	@Column(name = "name")
	private String name = "";

	//经度
	@Column(name = "longitude")
	private Double longitude;

	//纬度
	@Column(name = "latitude")
	private Double latitude;

	//组织机构代码
	@Column(name = "organization_code")
	private String organizationCode;

	//法人
	@Column(name = "legal_person")
	private String legalPerson = "";

	//区域ID
	@Column(name = "area_id")
	private Integer areaId;

	//企业地址
	@Column(name = "address")
	private String address = "";

	//注册资本
	@Column(name = "registered_capital")
	private Integer registeredCapital;

	//注册资本类型 1:人民币 2:美元
	@Column(name = "registered_capital_type")
	private Integer registeredCapitalType;

	//注册时间
	@JsonFormat(pattern = "yyyy-MM-dd", timezone = "GMT+8")
	@Column(name = "registered_date")
	private Date registeredDate;

	//公司注册类型，比如有限责任公司
	@Column(name = "registered_type")
	private String registeredType = "";

	//公司类型: ... 3:融资担保 4:线下理财 5:私募基金 6:众筹 7:其他 8:金融 9:交易所 ...
	@Column(name = "company_type")
	private Byte companyType;

	//行业类型,比如零售业，制造业
	@Column(name = "business_type")
	private String businessType = "";

	// 公司风险等级
	@Column(name = "risk_level")
	private Integer riskLevel;

	// 前一期公司风险等级
	@Column(name = "previous_risk_level")
	private Integer previousRiskLevel;

	//备案号 商业保理和预付卡企业才有
	@Column(name = "record_number")
	private String recordNumber;

	//1:存续 2:注销
	@Column(name = "status")
	private Byte status;

	//是否新增。0：否、1：是
	@Column(name = "is_new")
	private Boolean neo;

	/////////////////////////以下是数据库中没有的字段////

	@SuppressWarnings("unused")
	private String comTypeCN = "";

	private Byte background;

	@SuppressWarnings("unused")
	private String backgroundCN = "";

	private BigDecimal staticRisk;

	private Date exposureDate;

	private Integer analysisResult;

	// 平台名称
	private String platName = "";

	public boolean isNeo() {
		return neo;
	}

	public void setNeo(boolean neo) {
		this.neo = neo;
	}

	public Double getLongitude() {
		return longitude;
	}

	public void setLongitude(Double longitude) {
		this.longitude = longitude;
	}

	public Double getLatitude() {
		return latitude;
	}

	public void setLatitude(Double latitude) {
		this.latitude = latitude;
	}

	public String getRecordNumber() {
		return recordNumber;
	}

	public void setRecordNumber(String recordNumber) {
		this.recordNumber = recordNumber;
	}

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

	public Integer getPreviousRiskLevel() {
		return previousRiskLevel;
	}

	public void setPreviousRiskLevel(Integer previousRiskLevel) {
		this.previousRiskLevel = previousRiskLevel;
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