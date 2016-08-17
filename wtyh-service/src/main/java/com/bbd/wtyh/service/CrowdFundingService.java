package com.bbd.wtyh.service;

import java.util.List;

import com.bbd.wtyh.domain.CrowdFundingCompanyDO;
import com.bbd.wtyh.domain.CrowdFundingStatisticsDO;
import com.bbd.wtyh.domain.NvDO;

/**
* 众筹企业相关接口
* @author Ian.Su
* @since 2016年8月11日 下午3:43:20
*/
public interface CrowdFundingService {
	
	public List<NvDO> lastMonthData();

	
	public List<CrowdFundingStatisticsDO> lastMonthType();

	
	public List<CrowdFundingCompanyDO> allCompanys();
	
}
