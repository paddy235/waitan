package com.bbd.wtyh.mapper;

import com.bbd.wtyh.domain.InvestmentReturnStatisticDO;

import java.util.LinkedList;

public interface InvestmentReturnStatisticMapper {
    InvestmentReturnStatisticDO selectByPrimaryKey(Integer year);

    LinkedList<InvestmentReturnStatisticDO> selectAll();
}