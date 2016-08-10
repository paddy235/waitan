package com.bbd.wtyh.mapper;

import com.bbd.wtyh.domain.FinanceLeaseStatisticDO;

public interface FinanceLeaseStatisticMapper {
    FinanceLeaseStatisticDO selectByPrimaryKey(Integer year);
}