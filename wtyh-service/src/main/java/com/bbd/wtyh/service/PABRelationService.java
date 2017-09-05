package com.bbd.wtyh.service;

import com.bbd.wtyh.domain.PABRelationDO;

/**
 * Created by Barney on 2017/8/29.
 */
public interface PABRelationService {

    void addPABRelation(PABRelationDO pabRelationDO);

    void delPABRelationByParkId(Integer parkId);

    void delPABRelationByBuildingId(Integer buildingId);

}
