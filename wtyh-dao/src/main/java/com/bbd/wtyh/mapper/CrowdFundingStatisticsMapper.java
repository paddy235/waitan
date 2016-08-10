package com.bbd.wtyh.mapper;

import com.bbd.wtyh.domain.CrowdFundingStatisticsDO;

public interface CrowdFundingStatisticsMapper {
    CrowdFundingStatisticsDO selectByPrimaryKey(Integer year);
}