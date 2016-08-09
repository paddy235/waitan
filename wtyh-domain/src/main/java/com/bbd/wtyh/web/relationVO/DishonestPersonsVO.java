package com.bbd.wtyh.web.relationVO;

/**
 * 失信被执行人VO
 * 
 * @author Wen Jie
 *
 */
public class DishonestPersonsVO {

	private String executiveCourt;
	private String documentNo;
	private String releaseTime;
	private String executiveNo;

	public String getExecutiveNo() {
		return executiveNo;
	}

	public void setExecutiveNo(String executiveNo) {
		this.executiveNo = executiveNo;
	}

	public String getExecutiveCourt() {
		return executiveCourt;
	}

	public void setExecutiveCourt(String executiveCourt) {
		this.executiveCourt = executiveCourt;
	}

	public String getDocumentNo() {
		return documentNo;
	}

	public void setDocumentNo(String documentNo) {
		this.documentNo = documentNo;
	}

	public String getReleaseTime() {
		return releaseTime;
	}

	public void setReleaseTime(String releaseTime) {
		this.releaseTime = releaseTime;
	}
}
