package com.bbd.wtyh.service;

import com.bbd.wtyh.common.Pagination;
import com.bbd.wtyh.domain.LargeLoanDO;
import com.bbd.wtyh.domain.LoanBalanceDO;

import java.util.List;

/**
 * Created by Marco on 2016/8/8 0008.
 */
public interface LoanService {

    List<LoanBalanceDO> getLoanBalanceByYear();

    List<LoanBalanceDO> getLoanBalanceByMonth();

    List<LargeLoanDO> listLargeLoan(Pagination pagination, Integer orderByField, String descAsc);

    int countLargeLoan();
}
