package com.bbd.wtyh.mapper;

import com.bbd.wtyh.domain.RelationDO;

import java.util.List;

/**
 * Created by Barney on 2017/7/12.
 */
public interface RelationMapper {

    void addRelation(List<RelationDO> list);

    void delRelationByTarget(String targetCompany);

}
