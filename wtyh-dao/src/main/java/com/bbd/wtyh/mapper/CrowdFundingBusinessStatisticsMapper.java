package com.bbd.wtyh.mapper;

import java.util.List;

import com.bbd.wtyh.domain.NvDO;

public interface CrowdFundingBusinessStatisticsMapper {
    
    List<NvDO> lastMonthData();
}