package com.bbd.wtyh.mapper;

import com.bbd.wtyh.domain.CrowdFundingCompanyDO;

public interface CrowdFundingCompanyMapper {
    CrowdFundingCompanyDO selectByPrimaryKey(Integer companyId);
}