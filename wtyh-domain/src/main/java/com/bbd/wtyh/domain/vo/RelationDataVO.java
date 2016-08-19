package com.bbd.wtyh.domain.vo;

import java.util.List;

public class RelationDataVO {

	private String currentMonth;
	
	private String compareMonth;
	
	private int crtRelationPersonNum; // 当前关联自然人
	
	private int cpeRelationPersonNum; // 比较方关联自然人
	
	private List<String> decreaseRelationPerson;//关联方减少自然人
	
	private List<String> addRelationPerson;//关联方增加自然人
	
	private int crtCompanyPersonNum; // 当前关联法人
	
	private int cpeCompanyPersonNum; // 比较方关联法人
	
	private List<String> decreaseCompanyPerson;//关联方减少法人
	
	private List<String> addCompanyPerson;//关联方增加法人
	
	private int crtAgreeActNum; // 当前利益一致行动法人数量
	
	private int cpeAgreeActNum; // 比较利益一致行动法人数量
	
	private List<String> decreaseAgreeComDet; // 利益一致行动法人减少明细

	private List<String> addAgreeComDet; // 当前利益一致行动法人增加明细
	
	private int crtChildCompanyNum; // 当前子公司数量
	
	private int cpeChildCompanyNum; // 比较方子公司数量
	
	private List<String> decreaseChildCompany;//子公司减少详情
	
	private List<String> addChildCompany;//子公司增加详情
	
	private int crtOnePersonNum; // 当前一度自然人数量
	
	private int cpeOnePersonNum; // 比较方一度自然人数量
	
	private List<String> decreaseOnePerson;//一度自然人减少详情
	
	private List<String> addOnePerson;//一度自然人增加详情
	
	private int crtOneCompanyNum; // 当前一度法人数量
	
	private int cpeOneCompanyNum; // 比较方一度法人数量
	
	private List<String> decreaseOneCompany;//一度法人减少详情
	
	private List<String> addOneCompany;//一度法人增加详情
	
	private int crtTwoPersonNum; // 当前二度自然人数量
	
	private int cpeTwoPersonNum; // 比较方二度自然人数量
	
	private List<String> decreaseTwoPerson;//二度自然人减少详情
	
	private List<String> addTwoPerson;//二度自然人增加详情
	
	private int crtTwoCompanyNum; // 当前二度法人数量
	
	private int cpeTwoCompanyNum; // 比较方二度法人数量
	
	private List<String> decreaseTwoCompany;//二度法人减少详情
	
	private List<String> addTwoCompany;//二度法人增加详情
	
	private int crtThreePersonNum; // 当前三度自然人数量
	
	private int cpeThreePersonNum; // 比较方三度自然人数量
	
	private List<String> decreaseThreePerson;//三度自然人减少详情
	
	private List<String> addThreePerson;//三度自然人增加详情
	
	private int crtThreeCompanyNum; // 当前三度法人数量
	
	private int cpeThreeCompanyNum; // 比较方三度法人数量
	
	private List<String> decreaseThreeCompany;//三度法人减少详情
	
	private List<String> addThreeCompany;//三度法人增加详情

	public int getCrtRelationPersonNum() {
		return crtRelationPersonNum;
	}

	public void setCrtRelationPersonNum(int crtRelationPersonNum) {
		this.crtRelationPersonNum = crtRelationPersonNum;
	}

	public int getCpeRelationPersonNum() {
		return cpeRelationPersonNum;
	}

	public void setCpeRelationPersonNum(int cpeRelationPersonNum) {
		this.cpeRelationPersonNum = cpeRelationPersonNum;
	}

	public List<String> getDecreaseRelationPerson() {
		return decreaseRelationPerson;
	}

	public void setDecreaseRelationPerson(List<String> decreaseRelationPerson) {
		this.decreaseRelationPerson = decreaseRelationPerson;
	}

	public List<String> getAddRelationPerson() {
		return addRelationPerson;
	}

	public void setAddRelationPerson(List<String> addRelationPerson) {
		this.addRelationPerson = addRelationPerson;
	}

	public int getCrtCompanyPersonNum() {
		return crtCompanyPersonNum;
	}

	public void setCrtCompanyPersonNum(int crtCompanyPersonNum) {
		this.crtCompanyPersonNum = crtCompanyPersonNum;
	}

	public int getCpeCompanyPersonNum() {
		return cpeCompanyPersonNum;
	}

	public void setCpeCompanyPersonNum(int cpeCompanyPersonNum) {
		this.cpeCompanyPersonNum = cpeCompanyPersonNum;
	}

	public List<String> getDecreaseCompanyPerson() {
		return decreaseCompanyPerson;
	}

	public void setDecreaseCompanyPerson(List<String> decreaseCompanyPerson) {
		this.decreaseCompanyPerson = decreaseCompanyPerson;
	}

	public List<String> getAddCompanyPerson() {
		return addCompanyPerson;
	}

	public void setAddCompanyPerson(List<String> addCompanyPerson) {
		this.addCompanyPerson = addCompanyPerson;
	}

	public int getCrtChildCompanyNum() {
		return crtChildCompanyNum;
	}

	public void setCrtChildCompanyNum(int crtChildCompanyNum) {
		this.crtChildCompanyNum = crtChildCompanyNum;
	}

	public int getCpeChildCompanyNum() {
		return cpeChildCompanyNum;
	}

	public void setCpeChildCompanyNum(int cpeChildCompanyNum) {
		this.cpeChildCompanyNum = cpeChildCompanyNum;
	}

	public List<String> getDecreaseChildCompany() {
		return decreaseChildCompany;
	}

	public void setDecreaseChildCompany(List<String> decreaseChildCompany) {
		this.decreaseChildCompany = decreaseChildCompany;
	}

	public List<String> getAddChildCompany() {
		return addChildCompany;
	}

	public void setAddChildCompany(List<String> addChildCompany) {
		this.addChildCompany = addChildCompany;
	}

	public int getCrtOnePersonNum() {
		return crtOnePersonNum;
	}

	public void setCrtOnePersonNum(int crtOnePersonNum) {
		this.crtOnePersonNum = crtOnePersonNum;
	}

	public int getCpeOnePersonNum() {
		return cpeOnePersonNum;
	}

	public void setCpeOnePersonNum(int cpeOnePersonNum) {
		this.cpeOnePersonNum = cpeOnePersonNum;
	}

	public List<String> getDecreaseOnePerson() {
		return decreaseOnePerson;
	}

	public void setDecreaseOnePerson(List<String> decreaseOnePerson) {
		this.decreaseOnePerson = decreaseOnePerson;
	}

	public List<String> getAddOnePerson() {
		return addOnePerson;
	}

	public void setAddOnePerson(List<String> addOnePerson) {
		this.addOnePerson = addOnePerson;
	}

	public int getCrtOneCompanyNum() {
		return crtOneCompanyNum;
	}

	public void setCrtOneCompanyNum(int crtOneCompanyNum) {
		this.crtOneCompanyNum = crtOneCompanyNum;
	}

	public int getCpeOneCompanyNum() {
		return cpeOneCompanyNum;
	}

	public void setCpeOneCompanyNum(int cpeOneCompanyNum) {
		this.cpeOneCompanyNum = cpeOneCompanyNum;
	}

	public List<String> getDecreaseOneCompany() {
		return decreaseOneCompany;
	}

	public void setDecreaseOneCompany(List<String> decreaseOneCompany) {
		this.decreaseOneCompany = decreaseOneCompany;
	}

	public List<String> getAddOneCompany() {
		return addOneCompany;
	}

	public void setAddOneCompany(List<String> addOneCompany) {
		this.addOneCompany = addOneCompany;
	}

	public int getCrtTwoPersonNum() {
		return crtTwoPersonNum;
	}

	public void setCrtTwoPersonNum(int crtTwoPersonNum) {
		this.crtTwoPersonNum = crtTwoPersonNum;
	}

	public int getCpeTwoPersonNum() {
		return cpeTwoPersonNum;
	}

	public void setCpeTwoPersonNum(int cpeTwoPersonNum) {
		this.cpeTwoPersonNum = cpeTwoPersonNum;
	}

	public List<String> getDecreaseTwoPerson() {
		return decreaseTwoPerson;
	}

	public void setDecreaseTwoPerson(List<String> decreaseTwoPerson) {
		this.decreaseTwoPerson = decreaseTwoPerson;
	}

	public List<String> getAddTwoPerson() {
		return addTwoPerson;
	}

	public void setAddTwoPerson(List<String> addTwoPerson) {
		this.addTwoPerson = addTwoPerson;
	}

	public int getCrtTwoCompanyNum() {
		return crtTwoCompanyNum;
	}

	public void setCrtTwoCompanyNum(int crtTwoCompanyNum) {
		this.crtTwoCompanyNum = crtTwoCompanyNum;
	}

	public int getCpeTwoCompanyNum() {
		return cpeTwoCompanyNum;
	}

	public void setCpeTwoCompanyNum(int cpeTwoCompanyNum) {
		this.cpeTwoCompanyNum = cpeTwoCompanyNum;
	}

	public List<String> getDecreaseTwoCompany() {
		return decreaseTwoCompany;
	}

	public void setDecreaseTwoCompany(List<String> decreaseTwoCompany) {
		this.decreaseTwoCompany = decreaseTwoCompany;
	}

	public List<String> getAddTwoCompany() {
		return addTwoCompany;
	}

	public void setAddTwoCompany(List<String> addTwoCompany) {
		this.addTwoCompany = addTwoCompany;
	}

	public int getCrtThreePersonNum() {
		return crtThreePersonNum;
	}

	public void setCrtThreePersonNum(int crtThreePersonNum) {
		this.crtThreePersonNum = crtThreePersonNum;
	}

	public int getCpeThreePersonNum() {
		return cpeThreePersonNum;
	}

	public void setCpeThreePersonNum(int cpeThreePersonNum) {
		this.cpeThreePersonNum = cpeThreePersonNum;
	}

	public List<String> getDecreaseThreePerson() {
		return decreaseThreePerson;
	}

	public void setDecreaseThreePerson(List<String> decreaseThreePerson) {
		this.decreaseThreePerson = decreaseThreePerson;
	}

	public List<String> getAddThreePerson() {
		return addThreePerson;
	}

	public void setAddThreePerson(List<String> addThreePerson) {
		this.addThreePerson = addThreePerson;
	}

	public int getCrtThreeCompanyNum() {
		return crtThreeCompanyNum;
	}

	public void setCrtThreeCompanyNum(int crtThreeCompanyNum) {
		this.crtThreeCompanyNum = crtThreeCompanyNum;
	}

	public int getCpeThreeCompanyNum() {
		return cpeThreeCompanyNum;
	}

	public void setCpeThreeCompanyNum(int cpeThreeCompanyNum) {
		this.cpeThreeCompanyNum = cpeThreeCompanyNum;
	}

	public List<String> getDecreaseThreeCompany() {
		return decreaseThreeCompany;
	}

	public void setDecreaseThreeCompany(List<String> decreaseThreeCompany) {
		this.decreaseThreeCompany = decreaseThreeCompany;
	}

	public List<String> getAddThreeCompany() {
		return addThreeCompany;
	}

	public void setAddThreeCompany(List<String> addThreeCompany) {
		this.addThreeCompany = addThreeCompany;
	}

	public int getCrtAgreeActNum() {
		return crtAgreeActNum;
	}

	public void setCrtAgreeActNum(int crtAgreeActNum) {
		this.crtAgreeActNum = crtAgreeActNum;
	}

	public int getCpeAgreeActNum() {
		return cpeAgreeActNum;
	}

	public void setCpeAgreeActNum(int cpeAgreeActNum) {
		this.cpeAgreeActNum = cpeAgreeActNum;
	}

	public List<String> getDecreaseAgreeComDet() {
		return decreaseAgreeComDet;
	}

	public void setDecreaseAgreeComDet(List<String> decreaseAgreeComDet) {
		this.decreaseAgreeComDet = decreaseAgreeComDet;
	}

	public List<String> getAddAgreeComDet() {
		return addAgreeComDet;
	}

	public void setAddAgreeComDet(List<String> addAgreeComDet) {
		this.addAgreeComDet = addAgreeComDet;
	}

	public String getCurrentMonth() {
		return currentMonth;
	}

	public void setCurrentMonth(String currentMonth) {
		this.currentMonth = currentMonth;
	}

	public String getCompareMonth() {
		return compareMonth;
	}

	public void setCompareMonth(String compareMonth) {
		this.compareMonth = compareMonth;
	}
	
	
}
