package com.bbd.wtyh.service.shiro;

import com.bbd.wtyh.domain.vo.ParkAndBuildingVO;

import java.util.List;

/**
 * Created by Administrator on 2017/7/13 0013.
 */
public interface ParkMgtService{

    /**
     *
     * @param parkName 园区名称
     * @return 园区楼宇列表
     */
    List<ParkAndBuildingVO> queryParkAndBuilding(String parkName);

    /**
     *
     * @param parkName 园区名称
     * @return 楼宇企业数量
     */
    List<ParkAndBuildingVO> queryBuildingCompanyNumber(String parkName);
}
