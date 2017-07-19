package com.bbd.wtyh.service;

import com.bbd.wtyh.web.relationVO.RelationDiagramVO;

import java.util.List;

/**
 * Created by Barney on 2017/7/12.
 */
public interface RelationService {

    void addRelation(List<RelationDiagramVO.LineVO> list, String targetCompany) throws Exception;

    void delRelationByTarget(String targetCompany);

}
