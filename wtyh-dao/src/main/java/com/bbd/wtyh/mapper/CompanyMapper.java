package com.bbd.wtyh.mapper;

import java.util.Date;
import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.bbd.wtyh.domain.CompanyDO;
import com.bbd.wtyh.domain.CompanyTypeCountDO;
import com.bbd.wtyh.domain.InBusinessDO;

public interface CompanyMapper {
	
    CompanyDO selectByPrimaryKey(Integer companyId);
    
   public InBusinessDO countByDate(@Param(value = "areaId") Integer areaId,
					             @Param(value = "start")Date start,
					             @Param(value = "end")Date end);
   
   
   
   public CompanyTypeCountDO countByType(@Param(value = "areaId") Integer areaId,
		                               @Param(value = "type")Byte type);
   
   
   public List<CompanyDO> buildingCompany(Integer buildingId);
   
}