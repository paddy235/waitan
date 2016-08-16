package com.bbd.wtyh.domain;

public class CrowdFundingCompanyDO extends BaseDO {
	
    private Integer companyId;
	private String companyName;//公司名称
	private String address;//营业地址
	private String areaName;//注册地
	private String websiteUrl;//网址
	private String platformName;//平台名称
	private String fundingBusinessType;//业务类型;
	private Integer successNumber;//成功项目数
	private Float fundedAmout;//已筹基金	
    
	
	private String fundingBusinessTypeCN;//业务类型;

	
	
	public String getFundingBusinessTypeCN() {
		
		if("1".equals(fundingBusinessType)){
			fundingBusinessTypeCN = "公益型"; 
		}else if("2".equals(fundingBusinessType)){
			fundingBusinessTypeCN = "综合型"; 
		}else if("3".equals(fundingBusinessType)){
			fundingBusinessTypeCN = "权益型"; 
		}else if("4".equals(fundingBusinessType)){
			fundingBusinessTypeCN = "股权型"; 
		}
		
		return fundingBusinessTypeCN;
	}




	
	public void setFundingBusinessTypeCN(String fundingBusinessTypeCN) {
		this.fundingBusinessTypeCN = fundingBusinessTypeCN;
	}



	public String getCompanyName() {
		return companyName;
	}

	
	
	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}

	public String getAddress() {
		return address;
	}

		
	public void setAddress(String address) {
		this.address = address;
	}

	
	public String getAreaName() {
		return areaName;
	}


	public void setAreaName(String areaName) {
		this.areaName = areaName;
	}

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
        this.platformName = platformName == null ? null : platformName.trim();
    }

    public String getWebsiteUrl() {
        return websiteUrl;
    }

    public void setWebsiteUrl(String websiteUrl) {
        this.websiteUrl = websiteUrl == null ? null : websiteUrl.trim();
    }

    public String getFundingBusinessType() {
        return fundingBusinessType;
    }

    public void setFundingBusinessType(String fundingBusinessType) {
        this.fundingBusinessType = fundingBusinessType == null ? null : fundingBusinessType.trim();
    }

    public Integer getSuccessNumber() {
        return successNumber;
    }

    public void setSuccessNumber(Integer successNumber) {
        this.successNumber = successNumber;
    }

    public Float getFundedAmout() {
        return fundedAmout;
    }

    public void setFundedAmout(Float fundedAmout) {
        this.fundedAmout = fundedAmout;
    }
}