package com.bbd.wtyh.mapper;

import com.bbd.wtyh.domain.vo.FinanceLeaseStatisticVO;
import com.bbd.wtyh.domain.vo.FinanceLeaseVO;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;
import java.util.Set;

public interface FinanceLeaseMapper {

    public List<FinanceLeaseStatisticVO> queryFinanceLeaseStatistic(Map map);

    public List<Map> queryFinanceLeaseCompanyCategory(@Param("year") Integer year);

    public Set<FinanceLeaseVO> queryLeaseCompanyList(Map map);

    List<String> getYears();
}