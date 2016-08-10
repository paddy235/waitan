package com.bbd.wtyh.mapper;

import com.bbd.wtyh.domain.PrivateFundStatisticDO;

import java.util.List;

public interface PrivateFundStatisticMapper {
    PrivateFundStatisticDO selectByPrimaryKey(Byte typeId);

    List<PrivateFundStatisticDO> selectAll();
}