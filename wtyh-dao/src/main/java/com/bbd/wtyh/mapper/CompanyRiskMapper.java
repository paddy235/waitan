package com.bbd.wtyh.mapper;

import com.bbd.wtyh.domain.CompanyRiskDO;

public interface CompanyRiskMapper {
    CompanyRiskDO selectByPrimaryKey(Integer companyId);
}