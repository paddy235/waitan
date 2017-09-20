package com.bbd.wtyh.service;

import com.bbd.wtyh.domain.PABRelationDO;

import java.util.Map;

/**
 * Created by Barney on 2017/8/29.
 */
public interface PABRelationService {

    void addPABRelation(PABRelationDO pabRelationDO);

    void delPABRelationByParkId(Integer parkId);

    void delPABRelationByBuildingId(Integer buildingId);

    int queryPABRelation(Map<String, Object> params);

    void delPABRelation(Map<String, Object> params);

}
