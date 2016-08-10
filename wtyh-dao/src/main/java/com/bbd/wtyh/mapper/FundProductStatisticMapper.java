package com.bbd.wtyh.mapper;

import com.bbd.wtyh.domain.FundProductStatisticDO;

import java.util.List;

public interface FundProductStatisticMapper {
    FundProductStatisticDO selectByPrimaryKey(Integer productTypeId);

    List<FundProductStatisticDO> selectAll();
}