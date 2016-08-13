package com.bbd.wtyh.service.impl;

import com.bbd.wtyh.common.Pagination;
import com.bbd.wtyh.domain.GuaranteeBalanceDO;
import com.bbd.wtyh.domain.GuaranteedInfoDO;
import com.bbd.wtyh.domain.LoanBalanceDO;
import com.bbd.wtyh.domain.dto.LargeGuaranteeDTO;
import com.bbd.wtyh.domain.dto.LargeLoanDTO;
import com.bbd.wtyh.mapper.GuaranteeBalanceMapper;
import com.bbd.wtyh.mapper.GuaranteedInfoMapper;
import com.bbd.wtyh.mapper.LargeLoanMapper;
import com.bbd.wtyh.mapper.LoanBalanceMapper;
import com.bbd.wtyh.service.GuaranteeService;
import com.bbd.wtyh.service.LoanService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by Marco on 2016/8/8.
 */
@Service
public class GuaranteeServiceImpl implements GuaranteeService {
    @Autowired
    private GuaranteeBalanceMapper guaranteeBalanceMapper;
    @Autowired
    private GuaranteedInfoMapper guaranteedInfoMapper;


    @Override
    public List<GuaranteeBalanceDO> getGuaranteeBalance() {
        return guaranteeBalanceMapper.listByYear();
    }

    @Override
    public List<GuaranteedInfoDO> listLargeGuarantee(Pagination pagination, Integer orderByField, String descAsc) {
        List<GuaranteedInfoDO> largeGuaranteeDTOs = guaranteedInfoMapper.listLargeGuarantee(pagination, orderByField, descAsc);
        return largeGuaranteeDTOs;
    }

    @Override
    public int countLargeGuarantee() {
        return guaranteedInfoMapper.countLargeGuarantee();
    }
}
