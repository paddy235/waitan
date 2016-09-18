package com.bbd.wtyh.mapper;

import com.bbd.wtyh.domain.LoanBalanceDO;

import java.util.List;

public interface LoanBalanceMapper {
    LoanBalanceDO selectByPrimaryKey(Integer id);

    List<LoanBalanceDO> listByMonth(Integer totalItems);

    List<LoanBalanceDO> listByYear();
}