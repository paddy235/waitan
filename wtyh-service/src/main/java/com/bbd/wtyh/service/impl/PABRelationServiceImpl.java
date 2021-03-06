package com.bbd.wtyh.service.impl;

import com.bbd.wtyh.domain.PABRelationDO;
import com.bbd.wtyh.mapper.PABRelationMapper;
import com.bbd.wtyh.service.PABRelationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Map;

/**
 * Created by Barney on 2017/8/29.
 */
@Service
public class PABRelationServiceImpl implements PABRelationService {

    @Autowired
    private PABRelationMapper pabRelationMapper;

    @Override
    public void addPABRelation(PABRelationDO pabRelationDO) {
        pabRelationMapper.addPABRelation(pabRelationDO);
    }

    @Override
    public void delPABRelationByParkId(Integer parkId) {
        pabRelationMapper.delPABRelationByParkId(parkId);
    }

    @Override
    public void delPABRelationByBuildingId(Integer buildingId) {
        pabRelationMapper.delPABRelationByBuildingId(buildingId);
    }

    @Override
    public int queryPABRelation(Map<String, Object> params) {
        return pabRelationMapper.queryPABRelation(params);
    }

    @Override
    public void delPABRelation(Map<String, Object> params) {
        pabRelationMapper.delPABRelation(params);
    }
}
