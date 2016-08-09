package com.bbd.wtyh.mapper;

import com.bbd.wtyh.domain.CompanyLevelDO;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface CompanyLevelMapper {
    CompanyLevelDO selectByPrimaryKey(Integer companyId);

    List<CompanyLevelDO> selectCompanyLevel(@Param("companyType") Integer companyType, @Param("orderByField") Integer orderByField, @Param("descAsc") String descAsc);

}