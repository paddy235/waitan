package com.bbd.wtyh.service.impl;

import com.bbd.wtyh.domain.BuildingDO;
import com.bbd.wtyh.domain.vo.ParkAndBuildingVO;
import com.bbd.wtyh.mapper.ParkAndBuildingMgtMapper;
import com.bbd.wtyh.service.shiro.ParkMgtService;
import org.apache.commons.collections.map.HashedMap;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * Created by Administrator on 2017/7/13 0013.
 */
@Service
public class ParkMgtServiceImpl implements ParkMgtService {
    @Autowired
    private ParkAndBuildingMgtMapper parkAndBuildingMgtMapper;

    @Override
    public List<ParkAndBuildingVO> queryParkAndBuilding(String parkName) {
        List<ParkAndBuildingVO> list = new ArrayList<>();
        try {
            list = parkAndBuildingMgtMapper.queryParkAndBuilding(parkName);
        }catch (Exception e){
            e.printStackTrace();
            return list;
        }

        return list;
    }

    @Override
    public List<ParkAndBuildingVO> queryBuildingCompanyNumber(String parkName) {
        List<ParkAndBuildingVO> list = new ArrayList<>();
        try {
            list = parkAndBuildingMgtMapper.queryBuildingCompanyNumber(parkName);
        }catch (Exception e){
            e.printStackTrace();
            return list;
        }

        return list;
    }

    @Override
    public void delCompanyByCompanyName(List<String> companyNameList) {
        try{
            parkAndBuildingMgtMapper.delCompanyByCompanyName(companyNameList);
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    @Override
    public int queryParkIdByName(String parkName) {
        int i = 0000;
        try{
            i = parkAndBuildingMgtMapper.queryParkIdByName(parkName);
        }catch (Exception e){
            e.printStackTrace();
        }
        return i;
    }

    @Override
    public BuildingDO queryBuildingByParkAndName(int parkId, String buildingName) {
        Map<String, Object> params = new HashedMap();
        params.put("parkId",parkId);
        params.put("buildingName",buildingName);
        BuildingDO buildingDO = parkAndBuildingMgtMapper.queryBuildingByParkAndName(params);
        return buildingDO;
    }
}
