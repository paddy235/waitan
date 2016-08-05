
/**
* @Title: Area.java
* @Package com.bbd.wtyh.entity
* @Description: TODO
* @author Ian.Su
* @date 2016年8月5日 上午11:58:52
* @version V1.0
*/

package com.bbd.wtyh.entity;


/**
* @ClassName: Area
* @Description: 园区实体
* @author Ian.Su
* @date 2016年8月5日 上午11:58:52
*/
public class Area {
	
	private Integer area_id;
	private String name;
	
	/**
	* getter method
	* @return the area_id
	*/
	public Integer getArea_id() {
		return area_id;
	}
	
	/**
	* setter method
	* @param area_id the area_id to set
	*/
	public void setArea_id(Integer area_id) {
		this.area_id = area_id;
	}
	
	/**
	* getter method
	* @return the name
	*/
	public String getName() {
		return name;
	}
	
	/**
	* setter method
	* @param name the name to set
	*/
	public void setName(String name) {
		this.name = name;
	}

	
	
}
