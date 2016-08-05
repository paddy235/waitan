package com.bbd.wtyh.mapper;

import com.bbd.wtyh.domain.ProductAmountDO;

public interface ProductAmountMapper {
    ProductAmountDO selectByPrimaryKey(Integer companyId);
}