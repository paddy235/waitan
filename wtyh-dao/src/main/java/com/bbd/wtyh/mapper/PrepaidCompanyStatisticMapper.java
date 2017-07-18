package com.bbd.wtyh.mapper;

import com.bbd.wtyh.domain.CompanyInfoModify.CompanyInfo;
import com.bbd.wtyh.domain.PrepaidCompanyDO;
import com.bbd.wtyh.domain.PrepaidCompanyStatisticDO;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface PrepaidCompanyStatisticMapper {

    PrepaidCompanyStatisticDO selectByPrimaryKey(Integer year);

    List<PrepaidCompanyStatisticDO> prepaidAll();

    List<PrepaidCompanyDO> prepaidCompanyAll();

    CompanyInfo getPerpaycardByCompanyName(@Param(value = "name") String name);
}