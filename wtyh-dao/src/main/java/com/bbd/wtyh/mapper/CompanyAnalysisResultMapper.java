package com.bbd.wtyh.mapper;

import com.bbd.wtyh.domain.CompanyAnalysisResultDO;

public interface CompanyAnalysisResultMapper {
    CompanyAnalysisResultDO selectByPrimaryKey(Integer companyId);
}