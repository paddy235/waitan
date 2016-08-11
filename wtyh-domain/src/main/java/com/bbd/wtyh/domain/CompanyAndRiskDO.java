package com.bbd.wtyh.domain;


/**
* 企业信息（包含风险信息）
* @author Ian.Su
* @since 2016年8月11日 上午9:38:12
*/
public class CompanyAndRiskDO {
	
	private Integer id;
	
	private String companyName;
	
	private Byte analysisResult;
	
	private String recordNumber;
	
	private String address;
	
	private String anaResultCN;

	
	
	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}


	public Integer getId() {
		return id;
	}

	
	public void setId(Integer id) {
		this.id = id;
	}


	
	public String getCompanyName() {
		return companyName;
	}


	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}


	
	public Byte getAnalysisResult() {
		return analysisResult;
	}

	public void setAnalysisResult(Byte analysisResult) {
		this.analysisResult = analysisResult;
	}

	
	
	public String getRecordNumber() {
		return recordNumber;
	}


	public void setRecordNumber(String recordNumber) {
		this.recordNumber = recordNumber;
	}

	

	public String getAnaResultCN() {
		
		anaResultCN = CompanyAnalysisResultDO.anaResCN(analysisResult);
		
		return anaResultCN;
	}

	

	public void setAnaResultCN(String anaResultCN) {
		this.anaResultCN = anaResultCN;
	}
	
	
	
	
}
