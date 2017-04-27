package com.bbd.wtyh.domain;

import com.alibaba.fastjson.JSON;
import com.bbd.wtyh.constants.RiskChgCoSource;
import com.bbd.wtyh.domain.enums.CompanyAnalysisResult;
import com.bbd.wtyh.excel.annotation.Excel;
import com.bbd.wtyh.util.CoRiskchgUtil;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.apache.commons.lang3.StringUtils;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * 风险变化公司
 *
 * @author ly.sorm
 *
 *         2017-04-18 15:27:57
 */
@Entity
@Table(name = "risk_change_company")
public class RiskChgCoDo {

	/** ID */
	@Id
	@Column(name = "id")
	private Long id;

	/** 公司ID */
	@Column(name = "company_id")
	private Integer companyId;

	/** 企业名称 */
	@Excel(exportName = "企业名称")
	@Column(name = "company_name")
	private String companyName;

	/** 组织机构代码 */
	@Column(name = "organization_code")
	private String organizationCode;

	/**
	 * 公司类型 1:P2P 2:小贷 3:融资担保 4:线下理财 5:私募基金 6:众筹 7:其他 8:金融 9:交易所 10:商业保理 11.预付卡
	 * 12.典当 13融资租赁
	 */
	@Column(name = "company_type")
	private Integer companyType;

	/** 公司类型，显示用 */
	@Excel(exportName = "新金融类别")
	@Transient
	private String disCompanyType;

	/** 区域ID */
	@Column(name = "area_id")
	private Integer areaId;

	/** 名称 */
	@Excel(exportName = "所在区域")
	@Column(name = "area_name")
	private String areaName;

	/** 楼宇ID */
	@Column(name = "building_id")
	private Integer buildingId;

	/** 楼宇名字 */
	@Excel(exportName = "所在楼宇")
	@Column(name = "building_name")
	private String buildingName;

	/** 公司当前风险等级，1:已出风险(黑) 2:重点关注(红) 3:一般关注(黄) 4:正常(绿) */
	@Column(name = "risk_level")
	private Integer riskLevel;

	@Excel(exportName = "当前状态")
	@Transient
	private String disRiskLevel;

	/** 公司原始风险等级，1:已出风险(黑) 2:重点关注(红) 3:一般关注(黄) 4:正常(绿) */
	@Column(name = "old_risk_level")
	private Integer oldRiskLevel;

	@Excel(exportName = "原始状态")
	@Transient
	private String disOldRiskLevel;

	/** 当前外部评级 */
	@Column(name = "out_Level")
	private Integer outLevel;
	/** 原始外部评级 */
	@Column(name = "old_out_Level")
	private Integer oldOutLevel;

	/** 当前内部评级 */
	@Column(name = "inner_Level")
	private Integer innerLevel;
	/** 原始内部评级 */
	@Column(name = "old_inner_Level")
	private Integer oldInnerLevel;

	/** 当前现场检查 */
	@Column(name = "live_Level")
	private Integer liveLevel;
	/** 原始现场检查 */
	@Column(name = "old_inner_Level")
	private Integer oldLiveLevel;

	/** 当前是否存在风险 */
	@Column(name = "have_risk")
	private boolean haveRisk;

	/** 原始是否存在风险 */
	@Column(name = "old_have_risk")
	private boolean oldHaveRisk;

	@Excel(exportName = "风险评级")
	private String disRiskRating;

	/** 来源，1：人工修改，2：模型评分 */
	@Column(name = "source")
	private Integer source;

	@Excel(exportName = "来源")
	@Transient
	private String disSource;

	/** 变化时间 */
	@Excel(exportName = "变化时间", dateFormat = "yyyy-MM-dd")
	@Column(name = "change_date")
	@JsonFormat(pattern = "yyyy-MM-dd", timezone = "GMT+8")
	private Date changeDate;

	/** 创建人 */
	@Column(name = "create_by")
	private String createBy;

	/** 创建时间 */
	@Column(name = "create_date")
	private Date createDate;

	/** 修改人 */
	@Column(name = "update_by")
	private String updateBy;

	/** 修改时间 */
	@Column(name = "update_date")
	private Date updateDate;

	public String getDisRiskRating() {
		this.disRiskRating = CoRiskchgUtil.getRiskRating(this.companyType, this.innerLevel, this.outLevel, this.liveLevel);
		return disRiskRating;
	}

	public String getDisRiskLevel() {
		this.disRiskLevel = CoRiskchgUtil.getDisRiskLevel(this.companyType, this.innerLevel, this.outLevel, this.liveLevel);

		if (StringUtils.isBlank(this.disRiskLevel)) {
			this.disRiskLevel = CoRiskchgUtil.getDisRiskLevel(this.companyType, this.riskLevel, this.haveRisk);
		}
		return this.disRiskLevel;
	}

	public String getDisOldRiskLevel() {
		this.disOldRiskLevel = CoRiskchgUtil.getDisRiskLevel(this.companyType, this.oldInnerLevel, this.oldOutLevel, this.oldLiveLevel);
		if (StringUtils.isBlank(this.disOldRiskLevel)) {
			this.disOldRiskLevel = CoRiskchgUtil.getDisRiskLevel(this.companyType, this.oldRiskLevel, this.oldHaveRisk);
		}
		return this.disOldRiskLevel;
	}

	public String getDisSource() {
		if (this.source != null) {
			this.disSource = RiskChgCoSource.desc(this.source);
		}
		return this.disSource;
	}

	@Override
	public String toString() {
		return JSON.toJSONString(this);
	}

	/*********************************************************************************************
	 ************************************* getter and setter *************************************
	 *********************************************************************************************/

	/**
	 * 获取 ID
	 *
	 * @return id ID
	 */
	public Long getId() {
		return id;
	}

	/**
	 * 设置 ID
	 *
	 * @param id
	 *            ID
	 */
	public void setId(Long id) {
		this.id = id;
	}

	/**
	 * 获取 公司ID
	 *
	 * @return companyId 公司ID
	 */
	public Integer getCompanyId() {
		return companyId;
	}

	/**
	 * 设置 公司ID
	 *
	 * @param companyId
	 *            公司ID
	 */
	public void setCompanyId(Integer companyId) {
		this.companyId = companyId;
	}

	/**
	 * 获取 企业名称
	 *
	 * @return companyName 企业名称
	 */
	public String getCompanyName() {
		return companyName;
	}

	/**
	 * 设置 企业名称
	 *
	 * @param companyName
	 *            企业名称
	 */
	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}

	/**
	 * 获取 组织机构代码
	 *
	 * @return organizationCode 组织机构代码
	 */
	public String getOrganizationCode() {
		return organizationCode;
	}

	/**
	 * 设置 组织机构代码
	 *
	 * @param organizationCode
	 *            组织机构代码
	 */
	public void setOrganizationCode(String organizationCode) {
		this.organizationCode = organizationCode;
	}

	/**
	 * 获取 公司类型 1:P2P 2:小贷 3:融资担保 4:线下理财 5:私募基金 6:众筹 7:其他 8:金融 9:交易所 10:商业保理
	 * 11.预付卡 12.典当 13融资租赁
	 *
	 * @return companyType 公司类型 1:P2P 2:小贷 3:融资担保 4:线下理财 5:私募基金 6:众筹 7:其他 8:金融
	 *         9:交易所 10:商业保理 11.预付卡 12.典当 13融资租赁
	 */
	public Integer getCompanyType() {
		return companyType;
	}

	/**
	 * 设置 公司类型 1:P2P 2:小贷 3:融资担保 4:线下理财 5:私募基金 6:众筹 7:其他 8:金融 9:交易所 10:商业保理
	 * 11.预付卡 12.典当 13融资租赁
	 *
	 * @param companyType
	 *            公司类型 1:P2P 2:小贷 3:融资担保 4:线下理财 5:私募基金 6:众筹 7:其他 8:金融 9:交易所
	 *            10:商业保理 11.预付卡 12.典当 13融资租赁
	 */
	public void setCompanyType(Integer companyType) {
		this.companyType = companyType;
	}

	/**
	 * 获取 区域ID
	 *
	 * @return areaId 区域ID
	 */
	public Integer getAreaId() {
		return areaId;
	}

	/**
	 * 设置 区域ID
	 *
	 * @param areaId
	 *            区域ID
	 */
	public void setAreaId(Integer areaId) {
		this.areaId = areaId;
	}

	/**
	 * 获取 名称
	 *
	 * @return areaName 名称
	 */
	public String getAreaName() {
		return areaName;
	}

	/**
	 * 设置 名称
	 *
	 * @param areaName
	 *            名称
	 */
	public void setAreaName(String areaName) {
		this.areaName = areaName;
	}

	/**
	 * 获取 楼宇ID
	 *
	 * @return buildingId 楼宇ID
	 */
	public Integer getBuildingId() {
		return buildingId;
	}

	/**
	 * 设置 楼宇ID
	 *
	 * @param buildingId
	 *            楼宇ID
	 */
	public void setBuildingId(Integer buildingId) {
		this.buildingId = buildingId;
	}

	/**
	 * 获取 楼宇名字
	 *
	 * @return buildingName 楼宇名字
	 */
	public String getBuildingName() {
		return buildingName;
	}

	/**
	 * 设置 楼宇名字
	 *
	 * @param buildingName
	 *            楼宇名字
	 */
	public void setBuildingName(String buildingName) {
		this.buildingName = buildingName;
	}

	/**
	 * 获取 公司当前风险等级，1:已出风险(黑) 2:重点关注(红) 3:一般关注(黄) 4:正常(绿)
	 *
	 * @return riskLevel 公司当前风险等级，1:已出风险(黑) 2:重点关注(红) 3:一般关注(黄) 4:正常(绿)
	 */
	public Integer getRiskLevel() {
		return riskLevel;
	}

	/**
	 * 设置 公司当前风险等级，1:已出风险(黑) 2:重点关注(红) 3:一般关注(黄) 4:正常(绿)
	 *
	 * @param riskLevel
	 *            公司当前风险等级，1:已出风险(黑) 2:重点关注(红) 3:一般关注(黄) 4:正常(绿)
	 */
	public void setRiskLevel(Integer riskLevel) {
		this.riskLevel = riskLevel;
	}

	/**
	 * 获取 公司原始风险等级，1:已出风险(黑) 2:重点关注(红) 3:一般关注(黄) 4:正常(绿)
	 *
	 * @return oldRiskLevel 公司原始风险等级，1:已出风险(黑) 2:重点关注(红) 3:一般关注(黄) 4:正常(绿)
	 */
	public Integer getOldRiskLevel() {
		return oldRiskLevel;
	}

	/**
	 * 设置 公司原始风险等级，1:已出风险(黑) 2:重点关注(红) 3:一般关注(黄) 4:正常(绿)
	 *
	 * @param oldRiskLevel
	 *            公司原始风险等级，1:已出风险(黑) 2:重点关注(红) 3:一般关注(黄) 4:正常(绿)
	 */
	public void setOldRiskLevel(Integer oldRiskLevel) {
		this.oldRiskLevel = oldRiskLevel;
	}

	/**
	 * 获取 来源，1：人工修改，2：模型评分
	 *
	 * @return source 来源，1：人工修改，2：模型评分
	 */
	public Integer getSource() {
		return source;
	}

	/**
	 * 设置 来源，1：人工修改，2：模型评分
	 *
	 * @param source
	 *            来源，1：人工修改，2：模型评分
	 */
	public void setSource(Integer source) {
		this.source = source;
	}

	/**
	 * 获取 变化时间
	 *
	 * @return changeDate 变化时间
	 */
	public Date getChangeDate() {
		return changeDate;
	}

	/**
	 * 设置 变化时间
	 *
	 * @param changeDate
	 *            变化时间
	 */
	public void setChangeDate(Date changeDate) {
		this.changeDate = changeDate;
	}

	/**
	 * 获取 创建人
	 *
	 * @return createBy 创建人
	 */
	public String getCreateBy() {
		return createBy;
	}

	/**
	 * 设置 创建人
	 *
	 * @param createBy
	 *            创建人
	 */
	public void setCreateBy(String createBy) {
		this.createBy = createBy;
	}

	/**
	 * 获取 创建时间
	 *
	 * @return createDate 创建时间
	 */
	public Date getCreateDate() {
		return createDate;
	}

	/**
	 * 设置 创建时间
	 *
	 * @param createDate
	 *            创建时间
	 */
	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}

	/**
	 * 获取 修改人
	 *
	 * @return updateBy 修改人
	 */
	public String getUpdateBy() {
		return updateBy;
	}

	/**
	 * 设置 修改人
	 *
	 * @param updateBy
	 *            修改人
	 */
	public void setUpdateBy(String updateBy) {
		this.updateBy = updateBy;
	}

	/**
	 * 获取 修改时间
	 *
	 * @return updateDate 修改时间
	 */
	public Date getUpdateDate() {
		return updateDate;
	}

	/**
	 * 设置 修改时间
	 *
	 * @param updateDate
	 *            修改时间
	 */
	public void setUpdateDate(Date updateDate) {
		this.updateDate = updateDate;
	}

	/**
	 * 获取 公司类型，显示用
	 *
	 * @return disCompanyType 公司类型，显示用
	 */
	public String getDisCompanyType() {
		if (StringUtils.isBlank(this.disCompanyType) && this.companyType != null) {
			this.disCompanyType = CompanyDO.companyTypeCN(this.companyType.byteValue());
		}
		return this.disCompanyType;
	}

	/**
	 * 获取 当前外部评级
	 *
	 * @return outLevel 当前外部评级
	 */
	public Integer getOutLevel() {
		return this.outLevel;
	}

	/**
	 * 设置 当前外部评级
	 *
	 * @param outLevel
	 *            当前外部评级
	 */
	public void setOutLevel(Integer outLevel) {
		this.outLevel = outLevel;
	}

	/**
	 * 获取 原始外部评级
	 *
	 * @return oldOutLevel 原始外部评级
	 */
	public Integer getOldOutLevel() {
		return this.oldOutLevel;
	}

	/**
	 * 设置 原始外部评级
	 *
	 * @param oldOutLevel
	 *            原始外部评级
	 */
	public void setOldOutLevel(Integer oldOutLevel) {
		this.oldOutLevel = oldOutLevel;
	}

	/**
	 * 获取 当前内部评级
	 *
	 * @return innerLevel 当前内部评级
	 */
	public Integer getInnerLevel() {
		return this.innerLevel;
	}

	/**
	 * 设置 当前内部评级
	 *
	 * @param innerLevel
	 *            当前内部评级
	 */
	public void setInnerLevel(Integer innerLevel) {
		this.innerLevel = innerLevel;
	}

	/**
	 * 获取 原始内部评级
	 *
	 * @return oldInnerLevel 原始内部评级
	 */
	public Integer getOldInnerLevel() {
		return this.oldInnerLevel;
	}

	/**
	 * 设置 原始内部评级
	 *
	 * @param oldInnerLevel
	 *            原始内部评级
	 */
	public void setOldInnerLevel(Integer oldInnerLevel) {
		this.oldInnerLevel = oldInnerLevel;
	}

	/**
	 * 获取 当前现场检查
	 *
	 * @return liveLevel 当前现场检查
	 */
	public Integer getLiveLevel() {
		return this.liveLevel;
	}

	/**
	 * 设置 当前现场检查
	 *
	 * @param liveLevel
	 *            当前现场检查
	 */
	public void setLiveLevel(Integer liveLevel) {
		this.liveLevel = liveLevel;
	}

	/**
	 * 获取 原始现场检查
	 *
	 * @return oldLiveLevel 原始现场检查
	 */
	public Integer getOldLiveLevel() {
		return this.oldLiveLevel;
	}

	/**
	 * 设置 原始现场检查
	 *
	 * @param oldLiveLevel
	 *            原始现场检查
	 */
	public void setOldLiveLevel(Integer oldLiveLevel) {
		this.oldLiveLevel = oldLiveLevel;
	}

	/**
	 * 获取 当前是否存在风险
	 *
	 * @return haveRisk 当前是否存在风险
	 */
	public boolean isHaveRisk() {
		return this.haveRisk;
	}

	/**
	 * 设置 当前是否存在风险
	 *
	 * @param haveRisk
	 *            当前是否存在风险
	 */
	public void setHaveRisk(boolean haveRisk) {
		this.haveRisk = haveRisk;
	}

	/**
	 * 获取 原始是否存在风险
	 *
	 * @return oldHaveRisk 原始是否存在风险
	 */
	public boolean isOldHaveRisk() {
		return this.oldHaveRisk;
	}

	/**
	 * 设置 原始是否存在风险
	 *
	 * @param oldHaveRisk
	 *            原始是否存在风险
	 */
	public void setOldHaveRisk(boolean oldHaveRisk) {
		this.oldHaveRisk = oldHaveRisk;
	}
}