package com.bbd.wtyh.mapper;

import com.bbd.wtyh.domain.InvestmentReturnStatisticDO;

public interface InvestmentReturnStatisticMapper {
    InvestmentReturnStatisticDO selectByPrimaryKey(Integer year);
}