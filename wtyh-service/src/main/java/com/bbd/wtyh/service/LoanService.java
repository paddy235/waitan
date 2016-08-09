package com.bbd.wtyh.service;

import com.bbd.wtyh.common.Pagination;
import com.bbd.wtyh.domain.LoanBalanceDO;
import com.bbd.wtyh.domain.dto.LargeLoanDTO;

import java.util.List;

/**
 * Created by Marco on 2016/8/8 0008.
 */
public interface LoanService {

    List<LoanBalanceDO> getLoanBalance();

    List<LargeLoanDTO> listLargeLoan(Pagination pagination, Integer orderByField, String descAsc);

}
