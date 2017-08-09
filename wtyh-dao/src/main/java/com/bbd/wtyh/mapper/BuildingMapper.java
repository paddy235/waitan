package com.bbd.wtyh.mapper;

import java.util.List;

import com.bbd.wtyh.domain.*;
import org.apache.ibatis.annotations.Param;

public interface BuildingMapper {

    BuildingDO selectByPrimaryKey(Integer buildingId);

    List<BuildingDO> queryBuildings(@Param("areaId") Integer areaId,@Param("parkName") String parkName);

    List<CompanyNewsDO> buildingNews(Integer buildingId);

    List<BuildingNumberInAreaDO> countByArea();

    List<CompanyGroupByAreaDO> companyGroupByArea();

    List<CountCompanyByAreaDO> countCompanyByArea();
}