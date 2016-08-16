
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
public class AreaDO extends BaseDO{
	public static final int LEVEL_PROVINCE = 1;
	public static final int LEVEL_CITY = 2;
	public static final int LEVEL_DISTRICT = 3;


	private Integer areaId;
	private String name;
	private Integer parentId;
	private Integer cityId;
	private Integer provinceId;


	
	public Integer getAreaId() {
		return areaId;
	}
	
	public void setAreaId(Integer areaId) {
		this.areaId = areaId;
	}
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}

	public Integer getParentId() {
		return parentId;
	}

	public void setParentId(Integer parentId) {
		this.parentId = parentId;
	}

	public Integer getCityId() {
		return cityId;
	}

	public void setCityId(Integer cityId) {
		this.cityId = cityId;
	}

	public Integer getProvinceId() {
		return provinceId;
	}

	public void setProvinceId(Integer provinceId) {
		this.provinceId = provinceId;
	}
}
