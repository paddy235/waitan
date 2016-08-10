package com.bbd.wtyh.mapper;

import com.bbd.wtyh.domain.InvestmentReturnStatisticDO;

import java.util.List;

public interface InvestmentReturnStatisticMapper {
    InvestmentReturnStatisticDO selectByPrimaryKey(Integer year);

    List<InvestmentReturnStatisticDO> selectAll();
}