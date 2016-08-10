package com.bbd.wtyh.mapper;

import com.bbd.wtyh.domain.QflpCompanyDO;

import java.util.List;

public interface QflpCompanyMapper {
    QflpCompanyDO selectByPrimaryKey(Integer companyId);

    List<QflpCompanyDO> selectAll();
}