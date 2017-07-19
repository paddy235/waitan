package com.bbd.wtyh.service;

import java.util.List;
import java.util.Map;

import com.bbd.wtyh.domain.CrowdFundingCompanyDO;
import com.bbd.wtyh.domain.CrowdFundingStatisticsDO;
import com.bbd.wtyh.domain.NvDO;
import com.bbd.wtyh.domain.wangDaiAPI.CrowdFundingStatisticsDTO;

/**
* 众筹企业相关接口
* @author Ian.Su
* @since 2016年8月11日 下午3:43:20
*/
public interface CrowdFundingService {
	
	public List<NvDO> lastMonthData();

	
	public Map<String, String> lastMonthType(String dataType);

	
	public List<CrowdFundingCompanyDO> allCompanys();


	public List<String> queryCompany(String keyword);

}
