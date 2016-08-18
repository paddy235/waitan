package com.bbd.wtyh.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bbd.wtyh.domain.RiskCompanyInfoDO;
import com.bbd.wtyh.mapper.RiskCompanyMapper;
import com.bbd.wtyh.redis.RedisDAO;
import com.bbd.wtyh.service.RiskCompanyService;

@Service
public class RiskCompanyServiceImpl implements RiskCompanyService {
	
	@Autowired
	private RiskCompanyMapper riskCompanyMapper;
	private static final int SCANNER_COUNT = 1000;
	@Autowired
	private RedisDAO redisDAO;
	private static final String SCANNER_PREFIX_KEY = "scanner_";

	@Override
	@SuppressWarnings("unchecked")
	public List<RiskCompanyInfoDO> getScanner(Map<String, Object> params) {
		String key = SCANNER_PREFIX_KEY + params.get("area") + "_" + params.get("minRegCapital") + "_"
				+ params.get("maxRegCapital") + "_" + params.get("companyQualification") + "_"
				+ params.get("minReviewTime") + "_" + params.get("maxReviewTime");
		List<RiskCompanyInfoDO> scannerList = (List<RiskCompanyInfoDO>) redisDAO.getObject(key);
		if (null == scannerList || scannerList.size() == 0) {
			int realCount = riskCompanyMapper.getScannerCount(params);
			int result = realCount / SCANNER_COUNT;
			List<RiskCompanyInfoDO> list = riskCompanyMapper.getScanner(params);
			scannerList = new ArrayList<>();
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
			redisDAO.addObject(key, scannerList, 604800l, List.class); // 保留7天
		}
		return scannerList;
	}

	@Override
	public List<RiskCompanyInfoDO> getTop(Map<String, Object> params) {
		return riskCompanyMapper.getTop(params);
	}

	@Override
	public int getTopCount(Map<String, Object> params) {
		return riskCompanyMapper.getTopCount(params);
	}

}
