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
   
   public List<CompanyDO> buildingCompany( @Param(value = "buildingId")Integer buildingId,
										   @Param(value = "orderField")Integer orderField,
										   @Param(value = "descAsc")String descAsc);

   public CompanyTypeCountDO countTypeByBuild( @Param(value = "buildingId") Integer buildingId,
									           @Param(value = "type")Byte type);

   public List<CompanyTypeCountDO> buildingBackground(@Param(value = "buildingId")Integer buildingId,
		   											  @Param(value = "background")Integer background);
   
}