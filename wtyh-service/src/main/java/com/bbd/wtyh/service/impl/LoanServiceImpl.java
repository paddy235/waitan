package com.bbd.wtyh.service.impl;

import com.bbd.wtyh.common.Pagination;
import com.bbd.wtyh.domain.LargeLoanDO;
import com.bbd.wtyh.domain.LoanBalanceDO;
import com.bbd.wtyh.domain.dto.LargeLoanDTO;
import com.bbd.wtyh.mapper.LargeLoanMapper;
import com.bbd.wtyh.mapper.LoanBalanceMapper;
import com.bbd.wtyh.service.LoanService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by Marco on 2016/8/8.
 */
@Service
public class LoanServiceImpl implements LoanService {
    @Autowired
    private LoanBalanceMapper loanBalanceMapper;
    @Autowired
    private LargeLoanMapper largeLoanMapper;

    @Override
    public List<LoanBalanceDO> getLoanBalanceByMonth() {
        return loanBalanceMapper.listByMonth();
    }

    @Override
    public List<LoanBalanceDO> getLoanBalanceByYear() {
        return loanBalanceMapper.listByYear();
    }

    @Override
    public List<LargeLoanDO> listLargeLoan(Pagination pagination, Integer orderByField, String descAsc) {
        if (null != orderByField && orderByField >= 5) {
            orderByField = null;
        }
        return largeLoanMapper.listLargeLoan(pagination, orderByField, descAsc);
    }

    @Override
    public int countLargeLoan() {
        return largeLoanMapper.countLargeLoan();
    }


}
