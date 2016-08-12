package com.bbd.wtyh.domain;


/**
* 预付卡企业信息
* @author Ian.Su
* @since 2016年8月12日 上午10:03:57
*/
public class PrepaidCompanyDO {

	private Integer companyId;
	private String  companyName;
	private String  businessType;
	private String  recordNumber;
	private Byte 	analysisResult;
	private String 	analysisResultCN;
	

	public Integer getCompanyId() {
		return companyId;
	}
	
	
	
	public void setCompanyId(Integer companyId) {
		this.companyId = companyId;
	}
	

	
	public String getCompanyName() {
		return companyName;
	}

	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}
	

	
	public String getBusinessType() {
		return businessType;
	}
	

	public void setBusinessType(String businessType) {
		this.businessType = businessType;
	}
	

	
	public String getRecordNumber() {
		return recordNumber;
	}
	

	
	public void setRecordNumber(String recordNumber) {
		this.recordNumber = recordNumber;
	}

	
	public Byte getAnalysisResult() {
		return analysisResult;
	}

	public void setAnalysisResult(Byte analysisResult) {
		this.analysisResult = analysisResult;
	}
	

	public String getAnalysisResultCN() {
		
		analysisResultCN = CompanyAnalysisResultDO.anaResCN(this.analysisResult);
		
		return analysisResultCN;
	}
	

	public void setAnalysisResultCN(String analysisResultCN) {
		this.analysisResultCN = analysisResultCN;
	}
	
	
	
}
