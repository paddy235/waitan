package com.bbd.wtyh.mapper;

import java.util.List;

import com.bbd.wtyh.domain.*;
import org.apache.ibatis.annotations.Param;

public interface BuildingMapper {

    BuildingDO selectByPrimaryKey(Integer buildingId);

    List<BuildingDO> queryBuildings(@Param("parkId") Integer parkId);

    List<CompanyNewsDO> buildingNews(Integer buildingId);

    List<BuildingNumberInAreaDO> countByArea();

    List<CompanyGroupByAreaDO> companyGroupByArea();

    List<CountCompanyByAreaDO> countCompanyByArea();

    List<BuildingDO> queryAllBuilding();

}