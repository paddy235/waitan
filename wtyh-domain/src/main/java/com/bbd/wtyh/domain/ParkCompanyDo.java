package com.bbd.wtyh.domain;

import com.bbd.wtyh.domain.enums.CompanyAnalysisResult;
import com.bbd.wtyh.excel.annotation.Excel;
import com.fasterxml.jackson.annotation.JsonFormat;

import java.util.Date;

/**
 * Created by Administrator on 2017/4/14 0014.
 */
public class ParkCompanyDo {

	private Integer companyId;// 企业ID

	@Excel(exportName = "公司名称")
	private String companyName;// 企业名称
	@Excel(exportName = "法定代表人")
	private String legalPerson;// 法人
	@Excel(exportName = "企业背景")
	private String backgroundName;// 企业背景名称

	private Byte companyType;// 企业类型

	@Excel(exportName = "行业")
	private String companyTypeName;// 企业类型名称

	@Excel(exportName = "所在楼宇")
	private String buildingName;// 楼宇名称

	private Integer riskLevel;// 风险等级

	@Excel(exportName = "风险等级")
	private String riskLevelName;// 风险等级名称

	private Integer isNew;// 是否新增
	@Excel(exportName = "状态")
	private String isNewName;// 是否新增名称

	private Integer buildingId;// 楼宇ID

	private String background;// 企业背景

	@Excel(exportName = "注册资本（万元）")
	private Integer registeredCapital;//注册资本

	private Integer registeredCapitalType;//注册资本类型
	@Excel(exportName = "注册资本类型")
	private String registeredCapitalTypeName;//注册资本类型名称
	@Excel(exportName = "注册地址")
	private String address;//注册地址

	@Excel(exportName = "注册时间",dateFormat = "yyyy-MM-dd")
	@JsonFormat(pattern = "yyyy-MM-dd", timezone = "GMT+8")
	private Date registeredDate;//'注册时间

	public Integer getCompanyId() {
		return companyId;
	}

	public void setCompanyId(Integer companyId) {
		this.companyId = companyId;
	}

	public String getCompanyName() {
		return companyName;
	}

	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}

	public String getLegalPerson() {
		return legalPerson;
	}

	public void setLegalPerson(String legalPerson) {
		this.legalPerson = legalPerson;
	}

	public Byte getCompanyType() {
		return companyType;
	}

	public void setCompanyType(Byte companyType) {
		this.companyType = companyType;
	}

	public String getCompanyTypeName() {
		return CompanyDO.companyTypeCN(this.companyType);
	}

	public void setCompanyTypeName(String companyTypeName) {
		this.companyTypeName = companyTypeName;
	}

	public Integer getRiskLevel() {
		return riskLevel;
	}

	public void setRiskLevel(Integer riskLevel) {
		this.riskLevel = riskLevel;
	}

	public String getRiskLevelName() {
		if (null == this.riskLevel) {
			return "";
		}

		CompanyAnalysisResult[] types = CompanyAnalysisResult.values();
		for (CompanyAnalysisResult t : types) {
			if (this.riskLevel.equals(t.getType())) {
				return t.getName();
			}
		}
		if (this.riskLevel.equals(5)) {
			return "已出风险";
		}
		return "";
	}

	public void setRiskLevelName(String riskLevelName) {
		this.riskLevelName = riskLevelName;
	}

	public Integer getIsNew() {
		return isNew;
	}

	public void setIsNew(Integer isNew) {
		this.isNew = isNew;
	}

	public Integer getBuildingId() {
		return buildingId;
	}

	public void setBuildingId(Integer buildingId) {
		this.buildingId = buildingId;
	}

	public String getBuildingName() {
		return buildingName;
	}

	public void setBuildingName(String buildingName) {
		this.buildingName = buildingName;
	}

	public String getBackground() {
		return background;
	}

	public void setBackground(String background) {
		this.background = background;
	}

	public String getBackgroundName() {
		if (null == background || background.equals("")) {
			return "";
		}
		String[] bg = background.split(",");
		StringBuffer sb = new StringBuffer();
		for (int i = 0; i < bg.length; i++) {
			if (i != 0) {
				sb.append(",");
			}
			sb.append(CompanyBackgroundDO.Bg.getBg(Byte.valueOf(bg[i])).CN);
		}
		return sb.toString();
	}

	public void setBackgroundName(String backgroundName) {
		this.backgroundName = backgroundName;
	}

	public String getIsNewName() {
		if (1 == this.isNew) {
			return "新增";
		}
		return "";
	}

	public void setIsNewName(String isNewName) {
		this.isNewName = isNewName;
	}

	public Integer getRegisteredCapitalType() {
		return registeredCapitalType;
	}

	public void setRegisteredCapitalType(Integer registeredCapitalType) {
		this.registeredCapitalType = registeredCapitalType;
	}

	public Integer getRegisteredCapital() {
		return registeredCapital;
	}

	public void setRegisteredCapital(Integer registeredCapital) {
		this.registeredCapital = registeredCapital;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public Date getRegisteredDate() {
		return registeredDate;
	}

	public void setRegisteredDate(Date registeredDate) {
		this.registeredDate = registeredDate;
	}

	public String getRegisteredCapitalTypeName() {
		if(null==registeredCapitalType){
			return  "";
		}
		String name="";
		switch (registeredCapitalType){
			case 1:name="人民币";
					break;
			case 2:name="美元";
					break;
			default:
					break;
		}
		return name;
	}

	public void setRegisteredCapitalTypeName(String registeredCapitalTypeName) {
		this.registeredCapitalTypeName = registeredCapitalTypeName;
	}
}
