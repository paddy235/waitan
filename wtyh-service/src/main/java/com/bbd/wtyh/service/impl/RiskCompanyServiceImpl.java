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
	private static final String SCANNER_KEY = "scanner_key";

	@Override
	@SuppressWarnings("unchecked")
	public List<RiskCompanyInfoDO> getScanner(Map<String, Object> params) {
		List<RiskCompanyInfoDO> scannerList = (List<RiskCompanyInfoDO>) redisDAO.getObject(SCANNER_KEY);
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
			redisDAO.addObject(SCANNER_KEY, scannerList, 604800l, List.class); // 保留7天
		}
		return scannerList;
	}

	@Override
	public List<RiskCompanyInfoDO> getTop(Map<String, Object> params) {
		return riskCompanyMapper.getTop(params);
	}

}
