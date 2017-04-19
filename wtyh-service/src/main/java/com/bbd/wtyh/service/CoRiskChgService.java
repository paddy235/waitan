package com.bbd.wtyh.service;

import com.bbd.wtyh.core.base.BaseService;

import java.util.List;
import java.util.Map;

/**
 * 企业变化监测-风险变化企业
 *
 * @author Created by LiYao on 2017-04-19 16:45.
 */
public interface CoRiskChgService extends BaseService {

	/**
	 * 企业变化监测-风险变化企业-所有楼宇
	 * 
	 * @return
	 */
	List<Map<String, Object>> riskChgCoBuilding();
}
