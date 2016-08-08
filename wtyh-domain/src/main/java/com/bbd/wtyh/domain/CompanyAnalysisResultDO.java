package com.bbd.wtyh.domain;

public class CompanyAnalysisResultDO extends BaseDO {
    
	private Integer companyId;

    private Byte analysisResult;
    
    private String name;
    
    // 颜色 1:已曝光(黑) 2:高危(红) 3:关注(黄) 4:正常(绿)
    @SuppressWarnings("unused")
	private String anaResCN;
    
    
    public String getAnaResCN(){
    	switch (analysisResult) {
		case 1:
			return "已曝光";
		case 2:
			return "高危";
		case 3:
			return "关注";
		default:
			return "正常";
		}
    }


	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Integer getCompanyId() {
        return companyId;
    }

    public void setCompanyId(Integer companyId) {
        this.companyId = companyId;
    }

    public Byte getAnalysisResult() {
        return analysisResult;
    }

    public void setAnalysisResult(Byte analysisResult) {
        this.analysisResult = analysisResult;
    }
}