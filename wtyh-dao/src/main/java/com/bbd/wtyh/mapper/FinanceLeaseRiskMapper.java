package com.bbd.wtyh.mapper;

import com.bbd.wtyh.domain.FinanceLeaseRiskDO;

public interface FinanceLeaseRiskMapper {
    FinanceLeaseRiskDO selectByPrimaryKey(Integer companyId);
}