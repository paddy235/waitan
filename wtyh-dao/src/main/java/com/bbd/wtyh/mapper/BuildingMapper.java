package com.bbd.wtyh.mapper;

import com.bbd.wtyh.domain.BuildingDO;

public interface BuildingMapper {
    BuildingDO selectByPrimaryKey(Integer buildingId);
}