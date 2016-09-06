package com.bbd.wtyh.domain;

public class CompanyAnalysisResultDO extends BaseDO {

	private String name;

	private Integer companyId;

	private String longitude;

	private String latitude;

    private Byte analysisResult;

	private int registered_capital;

	/*	*
	* 公司类型 1:P2P 2:小贷 3:融资担保 4:线下理财 5:私募基金 6:众筹 7:其他 8:金融 9:交易所 10:商业保理 11.预付卡 12.典当 13融资租赁
	* */
	private Integer companyType;

	private int registered_capital_type;

	private String exposureDate;

	private String staticRiskIndex;




	// 颜色 1:已曝光(黑) 2:高危(红) 3:关注(黄) 4:正常(绿)
    @SuppressWarnings("unused")
	private String anaResCN;

	public static final int EXPOSURE = 1;
	public static final int HIGH = 2;
	public static final int FOCUS = 3;
	public static final int NORMAL = 4;

	public static String anaResCN(Byte result) {
    	if(result == null){
    		return "";
    	}
    	switch (result) {
		case EXPOSURE:
			return "已曝光";
		case HIGH:
			return "高危";
		case FOCUS:
			return "关注";
		default:
			return "正常";
		}
    }

	public String getLongitude() {
		return longitude;
	}

	public void setLongitude(String longitude) {
		this.longitude = longitude;
	}

	public String getLatitude() {
		return latitude;
	}

	public void setLatitude(String latitude) {
		this.latitude = latitude;
	}

	public String getStaticRiskIndex() {
		return staticRiskIndex;
	}

	public void setStaticRiskIndex(String staticRiskIndex) {
		this.staticRiskIndex = staticRiskIndex;
	}


	public Integer getCompanyType() {
		return companyType;
	}

	public void setCompanyType(Integer companyType) {
		this.companyType = companyType;
	}

	public String getExposureDate() {
		return exposureDate;
	}

	public void setExposureDate(String exposureDate) {
		this.exposureDate = exposureDate;
	}

	public int getRegistered_capital() {
		return registered_capital;
	}

	public void setRegistered_capital(int registered_capital) {
		this.registered_capital = registered_capital;
	}

	public int getRegistered_capital_type() {
		return registered_capital_type;
	}

	public void setRegistered_capital_type(int registered_capital_type) {
		this.registered_capital_type = registered_capital_type;
	}

	public String getAnaResCN(){
    	return anaResCN(this.analysisResult);
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