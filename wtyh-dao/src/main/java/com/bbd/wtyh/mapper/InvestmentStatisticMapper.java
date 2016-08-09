package com.bbd.wtyh.mapper;

import com.bbd.wtyh.domain.InvestmentStatisticDO;

public interface InvestmentStatisticMapper {
    InvestmentStatisticDO selectByPrimaryKey(Integer year);
}