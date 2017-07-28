package com.bbd.wtyh.mapper;

import com.bbd.wtyh.domain.FundProductTypeDO;
import org.apache.ibatis.annotations.Param;

public interface FundProductTypeMapper {
    FundProductTypeDO selectByPrimaryKey(Integer productTypeId);

    FundProductTypeDO getProductTypeByName(@Param("typeName") String typeName);
}