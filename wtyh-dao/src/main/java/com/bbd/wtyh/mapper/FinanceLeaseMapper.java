package com.bbd.wtyh.mapper;

import com.bbd.wtyh.domain.CompanyDO;
import com.bbd.wtyh.domain.FinanceLeaseStatisticDO;
import com.bbd.wtyh.domain.vo.ExchangeCompanyAreaVO;
import com.bbd.wtyh.domain.vo.ExchangeCompanyVO;
import com.bbd.wtyh.domain.vo.FinanceLeaseVO;

import java.util.List;
import java.util.Map;

public interface FinanceLeaseMapper {

    public List<FinanceLeaseStatisticDO> queryFinanceLeaseStatisticDO(Integer year);

    public List<FinanceLeaseVO> queryLeaseCompanyList(Map map);
}