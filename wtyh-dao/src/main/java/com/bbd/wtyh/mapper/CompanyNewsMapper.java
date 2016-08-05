package com.bbd.wtyh.mapper;

import com.bbd.wtyh.domain.CompanyNewsDO;

public interface CompanyNewsMapper {
    CompanyNewsDO selectByPrimaryKey(Integer newsId);
}