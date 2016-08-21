
/**
* @Title: Area.java
* @Package com.bbd.wtyh.entity
* @Description: TODO
* @author Ian.Su
* @date 2016年8月5日 上午11:58:52
* @version V1.0
*/

package com.bbd.wtyh.domain;


/**
* 园区实体
* @author Ian.Su
* @since 2016年8月5日 上午11:58:52
*/
public class PlatformNameInformationDO extends BaseDO{
	private Integer companyId;
	private String platformName;

	public Integer getCompanyId() {
		return companyId;
	}

	public void setCompanyId(Integer companyId) {
		this.companyId = companyId;
	}

	public String getPlatformName() {
		return platformName;
	}

	public void setPlatformName(String platformName) {
		this.platformName = platformName;
	}
}
