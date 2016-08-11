package com.bbd.wtyh.mapper;

import com.bbd.wtyh.domain.MortgageStatisticDO;

import java.util.List;

public interface MortgageStatisticMapper {
    MortgageStatisticDO selectByPrimaryKey(Integer year);

    List<MortgageStatisticDO> selectAll();
}