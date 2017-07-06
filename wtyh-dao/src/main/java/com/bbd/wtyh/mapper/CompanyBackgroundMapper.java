package com.bbd.wtyh.mapper;

import com.bbd.wtyh.domain.CompanyBackgroundDO;

public interface CompanyBackgroundMapper {

    CompanyBackgroundDO selectByPrimaryKey(Integer id);

    CompanyBackgroundDO selectByCompanyId(Integer companyId);

    void update(CompanyBackgroundDO companyBackgroundDO);

    void add(CompanyBackgroundDO companyBackgroundDO);

    void deleteByCompanyId(Integer companyId);

}