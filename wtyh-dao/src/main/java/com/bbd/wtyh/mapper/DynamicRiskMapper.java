package com.bbd.wtyh.mapper;

import com.bbd.wtyh.domain.CompanyDO;
import com.bbd.wtyh.domain.DynamicRiskDataDO;
import com.bbd.wtyh.domain.vo.DynamicRiskIndexVO;
import com.bbd.wtyh.domain.vo.ExchangeCompanyAreaVO;
import com.bbd.wtyh.domain.vo.ExchangeCompanyVO;

import java.util.List;
import java.util.Map;

public interface DynamicRiskMapper {

    public DynamicRiskIndexVO queryDynamicRisk(Map<String, Object> params);

    public void save(DynamicRiskDataDO dynamicRiskDataDO);

}