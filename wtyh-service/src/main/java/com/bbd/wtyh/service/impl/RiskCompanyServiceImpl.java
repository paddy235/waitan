package com.bbd.wtyh.service.impl;

import java.util.ArrayList;
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
	private static final int SCANNER_COUNT = 1000;

	@Override
	public List<RiskCompanyInfoDO> getScanner(Map<String, Object> params) {
		int realCount = riskCompanyMapper.getScannerCount(params);
		int result = realCount / SCANNER_COUNT;
		List<RiskCompanyInfoDO> list = riskCompanyMapper.getScanner(params);
		List<RiskCompanyInfoDO> scannerList = new ArrayList<>();
		if (result >= 2 && null != list && list.size() >= 1) {
			for (int i = 0; i < list.size(); i++) {
				if (i % result == 0) {
					scannerList.add(list.get(i));
				} else if (i == list.size() - 1) {
					scannerList.add(list.get(i));
				} else {}
			}
		} else {
			scannerList = list;
		}
		return scannerList;
	}

	@Override
	public List<RiskCompanyInfoDO> getTop(Map<String, Object> params) {
		return riskCompanyMapper.getTop(params);
	}

}
