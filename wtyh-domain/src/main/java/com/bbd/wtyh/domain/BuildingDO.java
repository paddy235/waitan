package com.bbd.wtyh.domain;

import com.bbd.wtyh.util.CalculateUtils;

public class BuildingDO extends BaseDO {
	
   
	private Integer buildingId;

    private String name;

    private Integer parkId;
    
    private String imgUrl;
    
    
    /**
    * @Fields finComNum : finance_company_number 类金融企业数量	
    */
    private Integer finComNum;

    /**
     *  企业数量
     */
    private Integer total;
    
    
    /**
    * @Fields ratio : finance_company_ratio 类金融企业占比
    */
    private String  finComRatio;


    public Integer getTotal() {
        return total;
    }

    public void setTotal(Integer total) {
        this.total = total;
    }

    public String getImgUrl() {
		return imgUrl;
	}

	
	public void setImgUrl(String imgUrl) {
		this.imgUrl = imgUrl;
	}


	public Integer getFinComNum() {
		return finComNum;
	}


	public void setFinComNum(Integer finComNum) {
		this.finComNum = finComNum;
	}


	public String getFinComRatio() {

        finComRatio = CalculateUtils.divide(finComNum*100,total,1)+"%";

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