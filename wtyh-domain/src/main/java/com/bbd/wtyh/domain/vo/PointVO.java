package com.bbd.wtyh.domain.vo;

import java.io.Serializable;

@SuppressWarnings("serial")
public class PointVO implements Serializable {

	private String name; // 关联方名称
	private String level; // 所处关联度数
	private String isPerson; // 是否是个人（0：公司；1：个人）
	private String isSonCom; // 是否为子公司（0：否；1：是）

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getLevel() {
		return level;
	}

	public void setLevel(String level) {
		this.level = level;
	}

	public String getIsPerson() {
		return isPerson;
	}

	public void setIsPerson(String isPerson) {
		this.isPerson = isPerson;
	}

	public String getIsSonCom() {
		return isSonCom;
	}

	public void setIsSonCom(String isSonCom) {
		this.isSonCom = isSonCom;
	}

}
