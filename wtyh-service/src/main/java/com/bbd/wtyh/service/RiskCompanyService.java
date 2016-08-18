package com.bbd.wtyh.service;

import java.math.BigDecimal;
import java.util.List;
import java.util.Map;

import com.bbd.wtyh.domain.RiskCompanyInfoDO;

public interface RiskCompanyService {
	
	List<RiskCompanyInfoDO> getScanner(Map<String, Object> params);
	
	List<RiskCompanyInfoDO> getTop(Map<String, Object> params);
	
	int getTopCount(Map<String, Object> params);
	
	BigDecimal getLastStaticRiskByCompanyName(String companyName);
	
}
