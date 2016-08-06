package com.bbd.wtyh.domain;

public class BuildingDO extends BaseDO {
	
   
	private Integer buildingId;

    private String name;

    private Integer parkId;
    
    
    /**
    * @Fields finComNum : finance_company_number 类金融企业数量	
    */
    private Integer finComNum;
    
    
    /**
    * @Fields ratio : finance_company_ratio 类金融企业占比
    */
    private String  finComRatio;
    
    
    



	public Integer getFinComNum() {
		return finComNum;
	}


	public void setFinComNum(Integer finComNum) {
		this.finComNum = finComNum;
	}


	public String getFinComRatio() {
		return finComRatio;
	}


	public void setFinComRatio(String finComRatio) {
		this.finComRatio = finComRatio;
	}

	public Integer getBuildingId() {
        return buildingId;
    }

    public void setBuildingId(Integer buildingId) {
        this.buildingId = buildingId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    public Integer getParkId() {
        return parkId;
    }

    public void setParkId(Integer parkId) {
        this.parkId = parkId;
    }
}