package com.bbd.wtyh.mapper;

import java.util.List;
import java.util.Map;

import com.bbd.wtyh.domain.RiskCompanyInfoDO;

public interface RiskCompanyMapper {
	
	List<RiskCompanyInfoDO> getScanner(Map<String, Object> params);
	
	int getScannerCount(Map<String, Object> params);

}
