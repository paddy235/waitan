package com.bbd.wtyh.mapper;

import com.bbd.wtyh.domain.CompanyDO;

public interface CompanyMapper {
    CompanyDO selectByPrimaryKey(Integer companyId);
}