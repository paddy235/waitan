package com.bbd.wtyh.service.impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bbd.wtyh.domain.RiskCompanyInfoDO;
import com.bbd.wtyh.mapper.RiskCompanyMapper;
import com.bbd.wtyh.service.RiskCompanyService;

@Service
public class RiskCompanyServiceImpl implements RiskCompanyService {
	
	@Autowired
	private RiskCompanyMapper riskCompanyMapper;

	@Override
	public List<RiskCompanyInfoDO> getScanner(Map<String, Object> params) {
		return riskCompanyMapper.getScanner(params);
	}

	@Override
	public int getScannerCount(Map<String, Object> params) {
		return riskCompanyMapper.getScannerCount(params);
	}

}
