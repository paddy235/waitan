package com.bbd.wtyh.web.relationVO;

import java.io.Serializable;

@SuppressWarnings("serial")
public class LineVO implements Serializable {

	private String orig; // 源
	private String target; // 目标
	private String isFullLine; // 是否为实线（0：否；1：是）
	private String type; // 关联方类型
	private String relationship; // 关联方关系（0：公司与公司；1：人与公司）
	
	private String origLevel; // 源维度
	private String tarLevel; // 目标维度

	public String getOrig() {
		return orig;
	}

	public void setOrig(String orig) {
		this.orig = orig;
	}

	public String getTarget() {
		return target;
	}

	public void setTarget(String target) {
		this.target = target;
	}

	public String getIsFullLine() {
		return isFullLine;
	}

	public void setIsFullLine(String isFullLine) {
		this.isFullLine = isFullLine;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getRelationship() {
		return relationship;
	}

	public void setRelationship(String relationship) {
		this.relationship = relationship;
	}

	public String getOrigLevel() {
		return origLevel;
	}

	public void setOrigLevel(String origLevel) {
		this.origLevel = origLevel;
	}

	public String getTarLevel() {
		return tarLevel;
	}

	public void setTarLevel(String tarLevel) {
		this.tarLevel = tarLevel;
	}

}
