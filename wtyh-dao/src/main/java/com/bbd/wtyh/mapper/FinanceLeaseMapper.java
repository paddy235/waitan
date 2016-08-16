package com.bbd.wtyh.mapper;

import com.bbd.wtyh.domain.vo.FinanceLeaseStatisticVO;
import com.bbd.wtyh.domain.vo.FinanceLeaseVO;

import java.util.List;
import java.util.Map;

public interface FinanceLeaseMapper {

    public List<FinanceLeaseStatisticVO> queryFinanceLeaseStatistic(Integer year);

    public List<Map> queryFinanceLeaseCompanyCategory(Integer year);

    public List<FinanceLeaseVO> queryLeaseCompanyList(Map map);
}