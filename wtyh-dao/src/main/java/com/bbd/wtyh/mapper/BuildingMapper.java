package com.bbd.wtyh.mapper;

import java.util.List;

import com.bbd.wtyh.domain.BuildingDO;
import com.bbd.wtyh.domain.CompanyNewsDO;

public interface BuildingMapper {
	
    BuildingDO selectByPrimaryKey(Integer buildingId);
    
    List<BuildingDO> queryBuildings(Integer areaId);
	
	List<CompanyNewsDO> buildingNews(Integer buildingId);

}