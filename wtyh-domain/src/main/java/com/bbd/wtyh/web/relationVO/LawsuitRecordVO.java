package com.bbd.wtyh.web.relationVO;

/**
 * 诉讼记录VO
 * 
 * @author Wen Jie
 *
 */
public class LawsuitRecordVO {

	private String caseNo;
	private String caseReason;
	private String refereeDate;
	private String prosecutionPerson; // 起诉方当事人
	private String prosecutionOther; // 起诉方其他相关人
	private String defendantPerson; // 被诉方当事人
	private String defendantOther; // 被诉方其他相关人
	private String caseResult; // 案件结果
	private String type;
	private String title;
	private String main;
	private String trialCourt; // 审理法院
	private String courtPerson; // 法院方当事人
	private String applicableLaw; // 适用法条

	public String getApplicableLaw() {
		return applicableLaw;
	}

	public void setApplicableLaw(String applicableLaw) {
		this.applicableLaw = applicableLaw;
	}

	public String getCourtPerson() {
		return courtPerson;
	}

	public void setCourtPerson(String courtPerson) {
		this.courtPerson = courtPerson;
	}

	public String getTrialCourt() {
		return trialCourt;
	}

	public void setTrialCourt(String trialCourt) {
		this.trialCourt = trialCourt;
	}

	public String getType() {
		return type;
	}

	public String getCaseReason() {
		return caseReason;
	}

	public void setType(String type) {
		this.type = type;
	}

	public void setCaseReason(String caseReason) {
		this.caseReason = caseReason;
	}

	public String getProsecutionPerson() {
		return prosecutionPerson;
	}

	public void setProsecutionPerson(String prosecutionPerson) {
		this.prosecutionPerson = prosecutionPerson;
	}

	public String getProsecutionOther() {
		return prosecutionOther;
	}

	public void setProsecutionOther(String prosecutionOther) {
		this.prosecutionOther = prosecutionOther;
	}

	public String getDefendantPerson() {
		return defendantPerson;
	}

	public void setDefendantPerson(String defendantPerson) {
		this.defendantPerson = defendantPerson;
	}

	public String getDefendantOther() {
		return defendantOther;
	}

	public void setDefendantOther(String defendantOther) {
		this.defendantOther = defendantOther;
	}

	public String getCaseResult() {
		return caseResult;
	}

	public void setCaseResult(String caseResult) {
		this.caseResult = caseResult;
	}

	public String getMain() {
		return main;
	}

	public void setMain(String main) {
		this.main = main;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getCaseNo() {
		return caseNo;
	}

	public void setCaseNo(String caseNo) {
		this.caseNo = caseNo;
	}

	public String getRefereeDate() {
		return refereeDate;
	}

	public void setRefereeDate(String refereeDate) {
		this.refereeDate = refereeDate;
	}

}
