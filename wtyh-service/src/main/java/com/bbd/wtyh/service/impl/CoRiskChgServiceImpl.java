package com.bbd.wtyh.service.impl;

import com.bbd.wtyh.core.base.BaseServiceImpl;
import com.bbd.wtyh.mapper.CoRiskChgMapper;
import com.bbd.wtyh.service.CoRiskChgService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
 * 企业变化监测-风险变化企业
 *
 * @author Created by LiYao on 2017-04-19 16:45.
 */
@Service
public class CoRiskChgServiceImpl extends BaseServiceImpl implements CoRiskChgService {

	@Autowired
	private CoRiskChgMapper coRiskChgMapper;

	@Override
	public List<Map<String, Object>> riskChgCoBuilding() {

		return this.coRiskChgMapper.riskChgCoBuilding();
	}
}
