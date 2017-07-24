package com.bbd.wtyh.mapper;

import com.bbd.wtyh.domain.ProductAmountDO;

import java.util.List;

public interface ProductAmountMapper {
    ProductAmountDO selectByPrimaryKey(Integer companyId);

    List<ProductAmountDO> topProductNumber(Integer numbers);

    //void update( ProductAmountDO pa );
}