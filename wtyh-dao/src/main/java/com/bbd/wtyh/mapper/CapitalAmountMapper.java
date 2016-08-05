package com.bbd.wtyh.mapper;

import com.bbd.wtyh.domain.CapitalAmountDO;

public interface CapitalAmountMapper {
    CapitalAmountDO selectByPrimaryKey(Integer investmentTypeId);
}