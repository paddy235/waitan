package com.bbd.wtyh.service;

import java.util.Map;

/**
 * Created by Administrator on 2017/4/18 0018.
 */
public interface CoChgMonitorService {

	/**
	 * 根据条件查询企业增销变化
	 *
	 */
	Map<String, Object> queryCompanyStatusChg(Integer areaId, Integer companyType, String beginDate, String endDate,
			Integer changeTpye, Integer source, Integer closedType, Integer page, Integer pageSize);
}
