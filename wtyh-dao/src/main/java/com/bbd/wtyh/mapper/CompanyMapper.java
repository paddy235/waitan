package com.bbd.wtyh.mapper;

import java.util.Date;

import org.apache.ibatis.annotations.Param;

import com.bbd.wtyh.domain.CompanyDO;
import com.bbd.wtyh.domain.InBusiness;

public interface CompanyMapper {
	
    CompanyDO selectByPrimaryKey(Integer companyId);
    
   public InBusiness countByDate(@Param(value = "areaId") Integer areaId,
					             @Param(value = "start")Date start,
					             @Param(value = "end")Date end);
    
}