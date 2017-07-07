package com.bbd.wtyh.mapper;

import com.bbd.wtyh.domain.*;
import com.bbd.wtyh.domain.vo.ParkAndBuildingVO;

import java.util.List;

/**
 * Created by Barney on 2017/7/5.
 */
public interface ParkAndBuildingMgtMapper {

    List<ParkAndBuildingVO> queryParkAndBuilding(String parkName);

    ParkDO queryParkByName(String parkName);

    void updateParkImgUrl(ParkDO park);

    List<ParkDO> queryAllPark();

    List<ParkAndBuildingVO> queryBuildingCompany(String parkName);

    List<ParkAndBuildingVO> queryBuildingFinCompany(String parkName);

    void addBuilding(BuildingDO building);

    void delCompanyByBuildingId(List<Integer> buildingIdList);

    void delBuildingByParkId(int parkId);

    void delParkByName(String parkName);

    List<BuildingDO> queryBuildingByParkId(int parkId);

    void addPark(ParkDO park);

    int queryCompanyIdByName(String companyName);

    void addCompanyBuilding(List<CompanyBuildingDO> companyBuildingList);

    void addExcelComAndBuilding(List<ParkCompanyImportDO> parkComImportList);

    String queryImportNo();

    List<ParkCompanyImportDO> queryImportContentByNo(String importNo);

}