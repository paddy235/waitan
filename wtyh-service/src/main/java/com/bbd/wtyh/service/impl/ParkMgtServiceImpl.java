package com.bbd.wtyh.service.impl;

import com.bbd.wtyh.domain.BuildingDO;
import com.bbd.wtyh.domain.CompanyDO;
import com.bbd.wtyh.domain.ParkDO;
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
    public List<ParkDO> queryParkList() {
        List<ParkDO> list = parkAndBuildingMgtMapper.queryParkList();
        List<ParkDO> t = new ArrayList<>();
        t.add(new ParkDO() {{
            setName("所有园区");

        }});
        t.addAll(list);
        return t;
    }

    @Override
    public List<ParkAndBuildingVO> queryParkAndBuilding(String parkId) {
        List<ParkAndBuildingVO> list = new ArrayList<>();
        try {
            list = parkAndBuildingMgtMapper.queryParkAndBuilding(parkId);
        } catch (Exception e) {
            e.printStackTrace();
            return list;
        }
        return list;
    }

    @Override
    public List<ParkAndBuildingVO> queryBuildingCompanyNumber(String parkId) {
        List<ParkAndBuildingVO> list = new ArrayList<>();
        try {
            list = parkAndBuildingMgtMapper.queryBuildingCompanyNumber(parkId);
        } catch (Exception e) {
            e.printStackTrace();
            return list;
        }
        return list;
    }

    @Override
    public List<CompanyDO> queryCompanyByBuildingId(String buildingId) {
        List<CompanyDO> list = new ArrayList<>();
        try {
            list = parkAndBuildingMgtMapper.queryCompanyByBuildingId(buildingId);
        } catch (Exception e) {
            e.printStackTrace();
            return list;
        }
        return list;
    }

    @Override
    public List<Map<String, String>> queryBuildingByParkId(String parkId) {
        List<Map<String, String>> list = new ArrayList<>();
        try {
            list = parkAndBuildingMgtMapper.queryBuildingByParkId(parkId);
        } catch (Exception e) {
            e.printStackTrace();
            return list;
        }
        return list;
    }

    @Override
    public void delCompanyByCompanyId(List<String> companyIdList) {
        try {
            parkAndBuildingMgtMapper.delCompanyByCompanyId(companyIdList);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public int queryParkIdByName(String parkName) {
        int i = 0000;
        try {
            i = parkAndBuildingMgtMapper.queryParkIdByName(parkName);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return i;
    }

    @Override
    public BuildingDO queryBuildingByParkAndName(int parkId, String buildingName) {
        Map<String, Object> params = new HashedMap();
        params.put("parkId", parkId);
        params.put("buildingName", buildingName);
        BuildingDO buildingDO = parkAndBuildingMgtMapper.queryBuildingByParkAndName(params);
        return buildingDO;
    }

    @Override
    public void addPark(ParkDO park) {
        try {
            parkAndBuildingMgtMapper.addPark(park);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
