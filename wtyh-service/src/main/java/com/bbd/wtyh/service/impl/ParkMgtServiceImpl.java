package com.bbd.wtyh.service.impl;

import com.bbd.higgs.utils.ListUtil;
import com.bbd.higgs.utils.StringUtils;
import com.bbd.wtyh.domain.*;
import com.bbd.wtyh.domain.vo.ParkAndBuildingVO;
import com.bbd.wtyh.mapper.ParkAndBuildingMgtMapper;
import com.bbd.wtyh.service.PABRelationService;
import com.bbd.wtyh.service.ParkRangeService;
import com.bbd.wtyh.service.ParkService;
import com.bbd.wtyh.service.shiro.ParkMgtService;
import org.apache.commons.collections.map.HashedMap;
import org.apache.poi.util.StringUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by Administrator on 2017/7/13 0013.
 */
@Service
public class ParkMgtServiceImpl implements ParkMgtService {
    @Autowired
    private ParkAndBuildingMgtMapper parkAndBuildingMgtMapper;
    @Autowired
    private ParkRangeService parkRangeService;
    @Autowired
    private PABRelationService pabRelationService;
    @Autowired
    private ParkService parkService;

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
    public List<Map<String, String>> queryBuildingList(String parkId, String buildingName) {
        try {
             return parkAndBuildingMgtMapper.queryBuildingList(parkId,buildingName);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public List<ParkAndBuildingVO> queryParkAndBuilding(String parkId,String buildingName) {
        try {
            return parkAndBuildingMgtMapper.queryParkAndBuilding(parkId,buildingName);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
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
    public Integer queryCompanyBuildingId(String buildingId, String companyId) {
        Integer i = parkAndBuildingMgtMapper.queryCompanyBuildingId(buildingId,companyId);
        return i;
    }

    @Override
    public Integer queryCBId(String companyId) {
        Integer i = parkAndBuildingMgtMapper.queryCBId(companyId);
        return i;
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
    public void updateParkAreaId(ParkDO park) {
        parkAndBuildingMgtMapper.updateParkAreaId(park);
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void updateBuilding(BuildingDO buildingDO, ParkDO parkDO, String origParkId) throws Exception {
        try {
            if (null == buildingDO || null == parkDO)
                throw new Exception("传入参数异常，building=" + buildingDO + "，park=" + parkDO);
            parkAndBuildingMgtMapper.updateBuilding(buildingDO);
            Map<String, Object> params = new HashMap<>();
            params.put("parkId", parkDO.getParkId());
            params.put("buildingId", buildingDO.getBuildingId());
            int relationCount = pabRelationService.queryPABRelation(params);
            if (relationCount == 0) {
                if (StringUtils.isNullOrEmpty(origParkId))
                    throw new Exception("入参异常，未获取到原所属园区信息！");
                Map<String, Object> delParams = new HashMap<>();
                delParams.put("parkId", origParkId);
                delParams.put("buildingId", buildingDO.getBuildingId());
                pabRelationService.delPABRelation(delParams);

                PABRelationDO pabRelationDO = new PABRelationDO();
                pabRelationDO.setCreateBy(buildingDO.getUpdateBy());
                pabRelationDO.setBuildingId(buildingDO.getBuildingId());
                pabRelationDO.setParkId(parkDO.getParkId());

                pabRelationService.addPABRelation(pabRelationDO);
            }
        } catch (Exception e) {
            throw new Exception(e.getMessage(), e);
        }
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void delParkById(String parkId) throws Exception {
        try {
            // TODO 这里要想清楚
            // parkAndBuildingMgtMapper.delCompanyBuildingByParkId(parkId);
            // parkAndBuildingMgtMapper.delBuildingByParkId(parkId);
            parkAndBuildingMgtMapper.delParkById(parkId);

            pabRelationService.delPABRelationByParkId(Integer.parseInt(parkId));
            parkRangeService.delParkRangeByParkId(Integer.parseInt(parkId));
        } catch (Exception e) {
            throw new Exception(e.getMessage(), e);
        }
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void delBuildingById(List<String> buildingId) throws Exception {
        try {
            if (ListUtil.isNotEmpty(buildingId)) {
                buildingId.forEach((String id) -> {
                    String pid = id.substring(0, id.indexOf("_"));
                    String bid = id.substring(id.indexOf("_") + 1);
                    // TODO 这里必须识别删除哪个园区下的楼宇，建议参数样例：23_133,23_155
                    // parkAndBuildingMgtMapper.delCompanyByBuildingId(buildingId);
                    // parkAndBuildingMgtMapper.delBuildingById(buildingId);

                    Map<String, Object> params = new HashMap<>();
                    params.put("parkId", pid);
                    params.put("buildingId", bid);
                    pabRelationService.delPABRelation(params);
                });
            }
        } catch (Exception e) {
            throw new Exception(e.getMessage(), e);
        }
    }

    @Override
    public void delCompanyByCompanyId(String buildingId,List<String> companyIdList) {
        try {
            parkAndBuildingMgtMapper.delCompanyByCompanyId(buildingId,companyIdList);
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
    public int queryBuildingIdByName(Integer parkId,String buildingName) {
        int i = 0000;
        try {
            i = parkAndBuildingMgtMapper.queryBuildingIdByName(parkId,buildingName);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return i;
    }

    @Override
    public int queryBIdByName(String buildingName) {
        try {
            String s = parkAndBuildingMgtMapper.queryBIdByName(buildingName);
            return StringUtils.isNullOrEmpty(s) ? 0 : Integer.parseInt(s);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return 0;
    }

    @Override
    public BuildingDO queryBuildingByParkAndBuilding(String parkId, String buildingId) {
        BuildingDO buildingDO = parkAndBuildingMgtMapper.queryBuildingByParkAndBuilding(parkId,buildingId);
        if (null != buildingDO && StringUtils.isNullOrEmpty(buildingDO.getImgUrl()))
            buildingDO.setImgUrl(BuildingDO.DEFAULT_BUILDING_IMG);
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

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void addBuilding(BuildingDO building, String parkName) throws Exception {
        try {
            parkAndBuildingMgtMapper.addBuilding(building);
            PABRelationDO pabDO = new PABRelationDO();
            pabDO.setBuildingId(building.getBuildingId());
            pabDO.setCreateBy(building.getCreateBy());
            pabDO.setUpdateBy(building.getUpdateBy());
            ParkDO parkDO = parkService.queryParkByName(parkName);
            if (null == parkDO || parkDO.getParkId() <= 0)
                throw new Exception("未查询到此楼宇所属园区！");
            pabDO.setParkId(parkDO.getParkId());
            pabRelationService.addPABRelation(pabDO);
        } catch (Exception e) {
            throw new Exception(e.getMessage(), e);
        }
    }

    @Override
    public void addCompanyBuilding(CompanyBuildingDO companyBuildingDO) {
        try {
            parkAndBuildingMgtMapper.addCompanyBuilding(companyBuildingDO);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public ParkDO queryParkById(String parkId) {
        ParkDO parkDO = parkAndBuildingMgtMapper.queryParkById(parkId);
        /* 使用默认图片 */
        if (null != parkDO && StringUtils.isNullOrEmpty(parkDO.getImgUrl()))
            parkDO.setImgUrl(ParkDO.DEFAULT_PARK_IMG);
        return parkDO;
    }

    @Override
    public void updateParkImgUrl(ParkDO park) {
        try{
            parkAndBuildingMgtMapper.updateParkImgUrl(park);
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    @Override
    public void updateBuildingImgUrl(BuildingDO building) {
        try{
            parkAndBuildingMgtMapper.updateBuildingImgUrl(building);
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    @Override
    public int queryPABRelation(String parkName, String buildingName) {
        Map<String, Object> params = new HashMap<>();
        params.put("parkName", parkName);
        params.put("buildingName", buildingName);
        return pabRelationService.queryPABRelation(params);
    }

    @Override
    public void bindingParkAndBuilding(BuildingDO building, String parkName) {
        try {
            PABRelationDO pabDO = new PABRelationDO();
            BuildingDO buildingDO = parkAndBuildingMgtMapper.queryBuildingByName(building.getName());
            if (null == buildingDO || buildingDO.getBuildingId() <= 0)
                throw new Exception("未查询到此楼宇！");
            pabDO.setBuildingId(buildingDO.getBuildingId());
            pabDO.setCreateBy(building.getCreateBy());
            pabDO.setUpdateBy(building.getCreateBy());
            ParkDO parkDO = parkService.queryParkByName(parkName);
            if (null == parkDO || parkDO.getParkId() <= 0)
                throw new Exception("未查询到此楼宇所属园区！");
            pabDO.setParkId(parkDO.getParkId());
            pabRelationService.addPABRelation(pabDO);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public int queryCountByParkName(String parkId, String parkName) {
        Map<String, Object> params = new HashMap<>();
        params.put("parkId", parkId);
        params.put("parkName", parkName);

        return parkAndBuildingMgtMapper.queryCountByParkName(params);
    }

    @Override
    public int queryCountByBuildingName(String buildingId, String buildingName) {
        Map<String, Object> params = new HashMap<>();
        params.put("buildingId", buildingId);
        params.put("buildingName", buildingName);

        return parkAndBuildingMgtMapper.queryCountByBuildingName(params);
    }
}
