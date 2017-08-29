package com.bbd.wtyh.mapper;

import com.bbd.wtyh.domain.PABRelationDO;

/**
 * Created by Barney on 2017/8/29.
 */
public interface PABRelationMapper {

    /**
     * 新增园区与楼宇的关系
     *
     * @param pabRelationDO
     */
    void addPABRelation(PABRelationDO pabRelationDO);

    /**
     * 根据园区ID，删除与其相关的楼宇关系
     *
     * @param parkId
     */
    void delPABRelationByParkId(Integer parkId);

}
