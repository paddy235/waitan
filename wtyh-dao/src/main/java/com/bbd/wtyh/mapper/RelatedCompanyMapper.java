package com.bbd.wtyh.mapper;

import com.bbd.wtyh.domain.RelatedCompanyDO;
import com.bbd.wtyh.domain.RelatedCompanyStatisticDO;

import java.util.List;

public interface RelatedCompanyMapper {
    RelatedCompanyDO selectByPrimaryKey(Integer id);

    List<RelatedCompanyDO> selectByCompanyId(Integer companyId);

    List<RelatedCompanyStatisticDO> statisticRelatedCompany(Integer companyType);

}