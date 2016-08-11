package com.bbd.wtyh.mapper;

import java.util.List;

import com.bbd.wtyh.domain.CrowdFundingStatisticsDO;

public interface CrowdFundingStatisticsMapper {
	
    CrowdFundingStatisticsDO selectByPrimaryKey(Integer year);
    
    
    List<CrowdFundingStatisticsDO> lastMonthType();

	
}