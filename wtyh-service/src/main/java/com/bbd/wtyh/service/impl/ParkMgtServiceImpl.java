package com.bbd.wtyh.service.impl;

import com.bbd.wtyh.domain.vo.ParkAndBuildingVO;
import com.bbd.wtyh.mapper.ParkAndBuildingMgtMapper;
import com.bbd.wtyh.service.shiro.ParkMgtService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

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
    public void delCompanyByCompanyName(List<Integer> companyNameList) {
        try{
            parkAndBuildingMgtMapper.delCompanyByCompanyName(companyNameList);
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
