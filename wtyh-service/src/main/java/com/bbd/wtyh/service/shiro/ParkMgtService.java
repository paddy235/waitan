package com.bbd.wtyh.service.shiro;

import com.bbd.wtyh.domain.BuildingDO;
import com.bbd.wtyh.domain.vo.ParkAndBuildingVO;

import java.util.List;

/**
 * Created by Administrator on 2017/7/13 0013.
 */
public interface ParkMgtService{

    /**
     * 园区楼宇列表
     * @param parkName 园区名称
     * @return
     */
    List<ParkAndBuildingVO> queryParkAndBuilding(String parkName);

    /**
     * 园区楼宇企业数量
     * @param parkName 园区名称
     * @return
     */
    List<ParkAndBuildingVO> queryBuildingCompanyNumber(String parkName);

    /**
     * 根据企业ID删除企业
     * @param companyNameList 企业名称列表
     */
    void delCompanyByCompanyName(List<String> companyNameList);

    /**
     * 根据园区名称取得园区ID
     * @param parkName 园区名称
     * @return
     */
    int queryParkIdByName(String parkName);

    /**
     * 园区楼宇企业数量
     * @param parkId
     * @param buildingName
     * @return
     */
    BuildingDO queryBuildingByParkAndName(int parkId, String buildingName);
}