package com.bbd.wtyh.service;

import com.bbd.wtyh.domain.CompanyDO;
import com.bbd.wtyh.domain.FinanceLeaseStatisticDO;
import com.bbd.wtyh.domain.vo.ExchangeCompanyAreaVO;
import com.bbd.wtyh.domain.vo.ExchangeCompanyVO;

import java.util.List;
import java.util.Map;

/**
 * 融资租赁接口层
 * @author zhouxuan
 * @since  2016.08.10
 */
public interface FinanceLeaseService {

    public Map leaseCompanyCategory(Integer year);

    public List<FinanceLeaseStatisticDO> leaseCompanyAmount();

    public Map leaseCompanyBadRatioAndAmount();
}
