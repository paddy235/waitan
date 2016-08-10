package com.bbd.wtyh.mapper;

import com.bbd.wtyh.domain.InvestmentReturnStatisticDO;
import com.bbd.wtyh.domain.InvestmentStatisticDO;

import java.util.List;

public interface InvestmentStatisticMapper {
    InvestmentStatisticDO selectByPrimaryKey(Integer year);

    List<InvestmentReturnStatisticDO> selectAll();
}