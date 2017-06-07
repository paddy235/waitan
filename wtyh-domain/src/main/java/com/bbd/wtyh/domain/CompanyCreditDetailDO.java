package com.bbd.wtyh.domain;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Date;

@Table(name = "company_credit_detail")
public class CompanyCreditDetailDO {

	@Id
	@Column(name = "company_id")
	private Integer companyId;

	@Column(name = "company_risk_info")
	private float companyRiskInfo;

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

	public Integer getCompanyId() {
		return companyId;
	}

	public void setCompanyId(Integer companyId) {
		this.companyId = companyId;
	}

	public float getCompanyRiskInfo() {
		return companyRiskInfo;
	}

	public void setCompanyRiskInfo(float companyRiskInfo) {
		this.companyRiskInfo = companyRiskInfo;
	}

	public String getCreateBy() {
		return createBy;
	}

	public void setCreateBy(String createBy) {
		this.createBy = createBy;
	}

	public Date getCreateDate() {
		return createDate;
	}

	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}

	public String getUpdateBy() {
		return updateBy;
	}

	public void setUpdateBy(String updateBy) {
		this.updateBy = updateBy;
	}

	public Date getUpdateDate() {
		return updateDate;
	}

	public void setUpdateDate(Date updateDate) {
		this.updateDate = updateDate;
	}
}