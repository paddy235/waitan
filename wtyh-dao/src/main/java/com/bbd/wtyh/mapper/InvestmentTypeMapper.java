package com.bbd.wtyh.mapper;

import com.bbd.wtyh.domain.InvestmentTypeDO;

public interface InvestmentTypeMapper {
    InvestmentTypeDO selectByPrimaryKey(Integer investmentTypeId);
}