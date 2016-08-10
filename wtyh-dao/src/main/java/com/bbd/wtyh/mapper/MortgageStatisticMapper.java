package com.bbd.wtyh.mapper;

import com.bbd.wtyh.domain.MortgageStatisticDO;

public interface MortgageStatisticMapper {
    MortgageStatisticDO selectByPrimaryKey(Integer year);
}