package com.bbd.wtyh.mapper;

import com.bbd.wtyh.domain.*;
import com.bbd.wtyh.domain.vo.ParkAndBuildingVO;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

/**
 * Created by Barney on 2017/7/5.
 */
public interface ParkAndBuildingMgtMapper {

    List<ParkAndBuildingVO> queryParkAndBuilding(String parkId);

    ParkDO queryParkByName(String parkName);

    void updateParkImgUrl(ParkDO park);

    List<ParkDO> queryAllPark();

    List<ParkAndBuildingVO> queryBuildingCompany(String parkName);

    List<ParkAndBuildingVO> queryBuildingFinCompany(String parkName);

    List<ParkAndBuildingVO> queryBuildingCompanyNumber(String parkId);

    void addBuilding(BuildingDO building);

    void delCompanyByCompanyId(@Param("companyIdList") List<String> companyIdList);

    void delCompanyByBuildingId(List<Integer> buildingIdList);

    void delBuildingByParkId(int parkId);

    void delParkByName(String parkName);

    List<Map<String,String>> queryBuildingByParkId(String parkId);

    void addPark(ParkDO park);

    int queryParkIdByName(String parkName);

    List<ParkDO> queryParkList();

    int queryCompanyIdByName(String companyName);

    void addCompanyBuilding(List<CompanyBuildingDO> companyBuildingList);

    void addExcelComAndBuilding(List<ParkCompanyImportDO> parkComImportList);

    String queryImportNo();

    List<ParkCompanyImportDO> queryImportContentByNo(String importNo);

    BuildingDO queryBuildingByParkAndName(Map<String, Object> params);

    List<CompanyDO> queryCompanyByBuildingId(String buildingId);

}