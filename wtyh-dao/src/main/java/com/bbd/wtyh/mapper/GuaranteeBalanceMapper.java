package com.bbd.wtyh.mapper;

import com.bbd.wtyh.domain.GuaranteeBalanceDO;

import java.util.List;

public interface GuaranteeBalanceMapper {
    GuaranteeBalanceDO selectByPrimaryKey(Integer id);

    List<GuaranteeBalanceDO> listByYear();
}