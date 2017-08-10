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

    List<ParkAndBuildingVO> queryParkAndBuilding(@Param("parkId") String parkId,@Param("buildingName") String buildingName);

    ParkDO queryParkById(String parkId);

    void updateParkImgUrl(ParkDO park);

    void updateParkAreaId(ParkDO park);

    void updateBuildingImgUrl(BuildingDO building);

    List<ParkDO> queryAllPark();

    List<ParkAndBuildingVO> queryBuildingCompany(String parkName);

    List<ParkAndBuildingVO> queryBuildingFinCompany(String parkName);

    List<ParkAndBuildingVO> queryBuildingCompanyNumber(String parkId);

    void addBuilding(BuildingDO building);

    void delCompanyByCompanyId(@Param("buildingId") String buildingId,@Param("companyIdList") List<String> companyIdList);

    void delCompanyByBuildingId(List<String> buildingIdList);

    void delCompanyBuildingByParkId(String parkId);

    void delBuildingByParkId(String parkId);

    void delBuildingById(List<String> buildingId);

    void delParkByName(String parkName);

    void delParkById(String parkId);

    List<Map<String,String>> queryBuildingByParkId(String parkId);

    void addPark(ParkDO park);

    int queryParkIdByName(String parkName);

    int queryBuildingIdByName(@Param("parkId") Integer parkId,@Param("buildingName") String buildingName);

    int queryBIdByName(String buildingName);

    List<ParkDO> queryParkList();

    Integer queryCompanyBuildingId(@Param("buildingId") String buildingId,@Param("companyId") String companyId);

    Integer queryCBId(String companyId);

    int queryCompanyIdByName(String companyName);

    void addCompanyBuilding(CompanyBuildingDO companyBuildingDO);

    void addCompanyBuildingList(List<CompanyBuildingDO> companyBuildingList);

    void addExcelComAndBuilding(List<ParkCompanyImportDO> parkComImportList);

    String queryImportNo();

    List<ParkCompanyImportDO> queryImportContentByNo(String importNo);

    BuildingDO queryBuildingByParkAndBuilding(@Param("parkId") String parkId, @Param("buildingId") String buildingId);

    List<CompanyDO> queryCompanyByBuildingId(String buildingId);

    List<Map<String,String>> queryBuildingList(@Param("parkId") String parkId,@Param("buildingName") String buildingName);

    void delImgByStatus(@Param("statusList") List<String> statusList);

}