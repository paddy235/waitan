package com.bbd.wtyh.service.shiro;

import com.bbd.wtyh.domain.BuildingDO;
import com.bbd.wtyh.domain.CompanyDO;
import com.bbd.wtyh.domain.ParkDO;
import com.bbd.wtyh.domain.vo.ParkAndBuildingVO;

import java.util.List;
import java.util.Map;

/**
 * Created by Administrator on 2017/7/13 0013.
 */
public interface ParkMgtService{

    /**
     * 园区列表
     * @return
     */
    List<ParkDO> queryParkList();

    /**
     * 楼宇列表
     * @param parkId
     * @param buildingName
     * @return
     */
    List<Map<String,String>> queryBuildingList(String parkId,String buildingName);

    /**
     * 园区楼宇列表
     * @param parkId 园区ID
     * @param buildingName 楼宇名称
     * @return
     */
    List<ParkAndBuildingVO> queryParkAndBuilding(String parkId,String buildingName);

    /**
     * 查询楼宇企业信息
     * @param buildingId 楼宇ID
     * @return
     */
    List<CompanyDO> queryCompanyByBuildingId(String buildingId);

    /**
     * 根据园区ID查询楼宇
     * @param parkId
     * @return
     */
    List<Map<String,String>> queryBuildingByParkId(String parkId);

    /**
     * 删除园区
     * @param parkId
     */
    void delParkById(String parkId);

    /**
     * 删除楼宇
     * @param parkId
     */
    void delBuildingByParkId(String parkId);

    /**
     * 删除楼宇
     * @param buildingId
     */
    void delBuildingById(List<String> buildingId);

    /**
     * 删除企业
     * @param parkId
     */
    void delCompanyBuildingByParkId(String parkId);

    /**
     * 删除企业
     * @param buildingId
     */
    void delCompanyByBuildingId(List<String> buildingId);

    /**
     * 根据企业ID删除企业
     * @param companyIdList 企业名称列表
     */
    void delCompanyByCompanyId(String buildingId,List<String> companyIdList);

    /**
     * 根据园区名称取得园区ID
     * @param parkName 园区名称
     * @return
     */
    int queryParkIdByName(String parkName);

    /**
     * 园区楼宇企业数量
     * @param parkId 园区ID
     * @return
     */
    List<ParkAndBuildingVO> queryBuildingCompanyNumber(String parkId);

    /**
     * 园区楼宇企业数量
     * @param parkId
     * @param buildingName
     * @return
     */
    BuildingDO queryBuildingByParkAndName(int parkId, String buildingName);

    /**
     * 新增园区
     * @param park
     */
    void addPark(ParkDO park);

    /**
     * 新增楼宇
     * @param building
     */
    void addBuilding(BuildingDO building);
}
