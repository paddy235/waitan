package com.bbd.wtyh.mapper;

import com.bbd.wtyh.domain.PrivateFundTypeDO;

public interface PrivateFundTypeMapper {
    PrivateFundTypeDO selectByPrimaryKey(Byte typeId);

    PrivateFundTypeDO getPriFundTypeByName(String typeName);
}