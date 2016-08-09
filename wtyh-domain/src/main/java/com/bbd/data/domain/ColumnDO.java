package com.bbd.data.domain;


/**
* 
* @author Ian.Su
* @since 2016年8月8日 下午5:35:39
*/
public class ColumnDO {

	
	
	private String colKey;
	
	private String tableName;
	
	private String dataType;
	
	private String length;
	
	private String isNullAble;
	
	private String colName;
	
	private String colComment;
	
	
	
	public String getColKey() {
		return colKey;
	}
	
	
	
	public void setColKey(String colKey) {
		this.colKey = colKey;
	}
	
	
	
	public String getTableName() {
		return tableName;
	}
	
	
	
	public void setTableName(String tableName) {
		this.tableName = tableName;
	}
	
	
	
	public String getDataType() {
		return dataType;
	}
	
	
	
	public void setDataType(String dataType) {
		this.dataType = dataType;
	}
	
	
	
	public String getLength() {
		return length;
	}
	
	
	
	public void setLength(String length) {
		this.length = length;
	}
	
	
	public String getIsNullAble() {
		return isNullAble;
	}
	
	
	
	public void setIsNullAble(String isNullAble) {
		this.isNullAble = isNullAble;
	}
	
	
	public String getColName() {
		return colName;
	}
	
	
	
	public void setColName(String colName) {
		this.colName = colName;
	}
	
	
	
	public String getColComment() {
		return colComment;
	}

	
	public void setColComment(String colComment) {
		this.colComment = colComment;
	}
	
	
}
