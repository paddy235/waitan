package com.bbd.wtyh.mapper;


import com.bbd.wtyh.domain.CompanyCreditDetailDO;

public interface CompanyCreditDetailMapper {
    void save(CompanyCreditDetailDO companyCreditDetailDO);

    float getCompanyRiskInfo(Integer companyId);
}