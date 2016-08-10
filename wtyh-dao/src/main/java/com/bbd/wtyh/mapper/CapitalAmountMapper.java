package com.bbd.wtyh.mapper;

import com.bbd.wtyh.domain.CapitalAmountDO;

import java.util.List;

public interface CapitalAmountMapper {
    CapitalAmountDO selectByPrimaryKey(Integer investmentTypeId);

    List<CapitalAmountDO> selectAll();
}