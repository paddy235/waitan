package com.bbd.wtyh.service;

import java.util.List;

import com.bbd.wtyh.domain.CrowdFundingBusinessStatisticsDO;
import com.bbd.wtyh.domain.CrowdFundingStatisticsDO;

/**
* 众筹企业相关接口
* @author Ian.Su
* @since 2016年8月11日 下午3:43:20
*/
public interface CrowdFundingService {
	
	public CrowdFundingBusinessStatisticsDO lastMonthData();

	
	public List<CrowdFundingStatisticsDO> lastMonthType();
	
}
