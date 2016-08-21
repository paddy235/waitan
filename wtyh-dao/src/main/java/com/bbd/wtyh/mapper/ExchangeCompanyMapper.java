package com.bbd.wtyh.mapper;

import com.bbd.wtyh.domain.CompanyDO;
import com.bbd.wtyh.domain.vo.ExchangeCompanyAreaVO;
import com.bbd.wtyh.domain.vo.ExchangeCompanyVO;
import com.bbd.wtyh.domain.vo.StatisticsVO;
import org.apache.ibatis.annotations.Param;
import org.apache.poi.ss.formula.functions.T;

import java.util.List;
import java.util.Map;

public interface ExchangeCompanyMapper {

    public List<Map> queryExchangeCompanyCategory();

    public List<ExchangeCompanyAreaVO> queryExchangeCompanyArea();

    public List<ExchangeCompanyVO> queryExchangeCompanyByStatus(@Param("status") Integer status);

    public List<CompanyDO> queryExchangeCompanyListByAreaId(Map map);
}