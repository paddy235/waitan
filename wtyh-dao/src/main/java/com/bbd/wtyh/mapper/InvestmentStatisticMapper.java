package com.bbd.wtyh.mapper;

import com.bbd.wtyh.domain.InvestmentStatisticDO;

import java.util.LinkedList;

public interface InvestmentStatisticMapper {
    InvestmentStatisticDO selectByPrimaryKey(Integer year);

    LinkedList<InvestmentStatisticDO> selectAll();
}