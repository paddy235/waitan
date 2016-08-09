package com.bbd.data.domain;


/**
* 
* @author Ian.Su
* @since 2016年8月8日 下午3:25:39
*/
public class TableDO {
	
	private String table_comment;
	
	private String table_name;
	
	private Integer table_rows;
	
	
	public String getTable_comment() {
		return table_comment;
	}
	
	public void setTable_comment(String table_comment) {
		this.table_comment = table_comment;
	}
	
	public String getTable_name() {
		return table_name;
	}
	
	public void setTable_name(String table_name) {
		this.table_name = table_name;
	}
	
	public Integer getTable_rows() {
		return table_rows;
	}
	
	public void setTable_rows(Integer table_rows) {
		this.table_rows = table_rows;
	} 
	
}
