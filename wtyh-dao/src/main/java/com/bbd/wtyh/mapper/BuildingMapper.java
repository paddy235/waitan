package com.bbd.wtyh.mapper;

import java.util.List;

import com.bbd.wtyh.domain.BuildingDO;

public interface BuildingMapper {
	
    BuildingDO selectByPrimaryKey(Integer buildingId);
    
    List<BuildingDO> queryBuildings(Integer areaId);
}