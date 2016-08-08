package com.bbd.wtyh.domain;


/**
* 
* 用于存储 name-value对
* 
* @author Ian.Su
* @since 2016年8月7日 下午2:32:17
*/
public class NvDO {
	
	private String name;
	private Object value;
	
	
	public String getName() {
		return name;
	}
	
	
	public void setName(String name) {
		this.name = name;
	}
	
	
	public Object getValue() {
		return value;
	}
	
	public void setValue(Object value) {
		this.value = value;
	}
	
	
	
}
