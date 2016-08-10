package com.bbd.wtyh.mapper;

import com.bbd.wtyh.domain.PrepaidCompanyStatisticDO;

public interface PrepaidCompanyStatisticMapper {
    PrepaidCompanyStatisticDO selectByPrimaryKey(Integer year);
}