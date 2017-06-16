
/**
* @Title: Area.java
* @Package com.bbd.wtyh.entity
* @Description: TODO
* @author Ian.Su
* @date 2016年8月5日 上午11:58:52
* @version V1.0
*/

package com.bbd.wtyh.domain.credit;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.Table;

import com.bbd.wtyh.domain.BaseDO;

/**
 * 园区实体
 * 
 * @author Ian.Su
 * @since 2016年8月5日 上午11:58:52
 */
@Table(name = "company_credit_fail_info")
public class CompanyCreditFailInfoDO extends BaseDO {


	@Id
	@Column(name = "id")
	private Integer id;

	@Column(name = "company_id")
	private Integer companyId;

	@Column(name = "company_name")
	private String companyName;

	@Column(name = "organization_code")
	private String organizationCode;

	@Column(name = "credit_code")
	private String creditCode;

	@Column(name = "result_code")
	private String resultCode;

	@Column(name = "data_version")
	private String dataVersion;


	@Override
	public Integer getId() {
		return id;
	}

	@Override
	public void setId(Integer id) {
		this.id = id;
	}

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

	public String getOrganizationCode() {
		return organizationCode;
	}

	public void setOrganizationCode(String organizationCode) {
		this.organizationCode = organizationCode;
	}

	public String getCreditCode() {
		return creditCode;
	}

	public void setCreditCode(String creditCode) {
		this.creditCode = creditCode;
	}

	public String getResultCode() {
		return resultCode;
	}

	public void setResultCode(String resultCode) {
		this.resultCode = resultCode;
	}

	public String getDataVersion() {
		return dataVersion;
	}

	public void setDataVersion(String dataVersion) {
		this.dataVersion = dataVersion;
	}
}
