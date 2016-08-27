package com.bbd.wtyh.mapper;

import com.bbd.wtyh.domain.*;
import com.bbd.wtyh.domain.query.CompanyQuery;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

public interface CompanyCreditInformationMapper {

    List<CompanyCreditInformationDO> selectCompanyCreditInformationList(Integer companyId);

    List<CompanyCreditPointItemsDO> selectCompanyCreditPointItems();

}