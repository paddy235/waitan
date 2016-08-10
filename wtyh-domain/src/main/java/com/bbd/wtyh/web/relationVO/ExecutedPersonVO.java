package com.bbd.wtyh.web.relationVO;

public class ExecutedPersonVO {
	private String executedName;//被执行人姓名/名称
	private String iDNumber;//身份证号码/组织机构代码
	private String executiveCourt;//执行法院
	private String filingTime;//立案时间
	private String documentNo;//案号
	private String executiveSubject;//执行标的
	public String getExecutedName() {
		return executedName;
	}
	public void setExecutedName(String executedName) {
		this.executedName = executedName;
	}
	public String getiDNumber() {
		return iDNumber;
	}
	public void setiDNumber(String iDNumber) {
		this.iDNumber = iDNumber;
	}
	public String getExecutiveCourt() {
		return executiveCourt;
	}
	public void setExecutiveCourt(String executiveCourt) {
		this.executiveCourt = executiveCourt;
	}
	public String getFilingTime() {
		return filingTime;
	}
	public void setFilingTime(String filingTime) {
		this.filingTime = filingTime;
	}
	public String getDocumentNo() {
		return documentNo;
	}
	public void setDocumentNo(String documentNo) {
		this.documentNo = documentNo;
	}
	public String getExecutiveSubject() {
		return executiveSubject;
	}
	public void setExecutiveSubject(String executiveSubject) {
		this.executiveSubject = executiveSubject;
	}
	
	
}
