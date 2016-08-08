package com.bbd.wtyh.service;

import java.util.List;
import java.util.Map;

import com.bbd.wtyh.domain.RiskCompanyInfoDO;

public interface RiskCompanyService {
	
	List<RiskCompanyInfoDO> getScanner(Map<String, Object> params);

}
