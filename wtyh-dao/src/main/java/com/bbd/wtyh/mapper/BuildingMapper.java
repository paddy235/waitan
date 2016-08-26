package com.bbd.wtyh.mapper;

import java.util.List;

import com.bbd.wtyh.domain.*;

public interface BuildingMapper {

    BuildingDO selectByPrimaryKey(Integer buildingId);

    List<BuildingDO> queryBuildings(Integer areaId);

    List<CompanyNewsDO> buildingNews(Integer buildingId);

    List<BuildingNumberInAreaDO> countByArea();

    List<CompanyGroupByAreaDO> companyGroupByArea();

    List<CountCompanyByAreaDO> countCompanyByArea();
}