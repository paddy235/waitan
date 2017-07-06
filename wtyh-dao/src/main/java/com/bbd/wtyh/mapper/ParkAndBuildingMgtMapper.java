package com.bbd.wtyh.mapper;

import com.bbd.wtyh.domain.ParkDO;
import com.bbd.wtyh.domain.vo.ParkAndBuildingVO;

import java.util.List;

/**
 * Created by Barney on 2017/7/5.
 */
public interface ParkAndBuildingMgtMapper {

    List<ParkAndBuildingVO> queryParkAndBuilding(String parkName);

    ParkDO queryParkByName(String parkName);

}