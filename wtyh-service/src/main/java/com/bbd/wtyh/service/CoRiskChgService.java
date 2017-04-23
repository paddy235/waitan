package com.bbd.wtyh.service;

import com.bbd.wtyh.core.base.BaseService;
import com.bbd.wtyh.core.entity.Pagination;
import com.bbd.wtyh.domain.RiskChgCoDo;

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

	/**
	 * 查询分页数据
	 * 
	 * @param paramMap
	 * @param page
	 * @return
	 */
	List<RiskChgCoDo> queryPageData(Map<String, String> paramMap, Pagination page);

	/**
	 * 查询所有数据
	 * 
	 * @param paramMap
	 * @return
	 */
	List<RiskChgCoDo> queryAllData(Map<String, String> paramMap);
}
