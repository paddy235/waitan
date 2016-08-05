package com.bbd.wtyh.mapper;

import com.bbd.wtyh.domain.CompanyLevelDO;

public interface CompanyLevelMapper {
    CompanyLevelDO selectByPrimaryKey(Integer companyId);
}