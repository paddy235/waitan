package com.bbd.wtyh.service;

import com.bbd.wtyh.web.relationVO.RelationDiagramVO;

import java.util.List;

/**
 * Created by Barney on 2017/7/12.
 */
public interface RelationService {

    void addRelation(RelationDiagramVO diagramVO, String queriedCompany) throws Exception;

    void delLineByTarget(String queriedCompany);

    void delPointByTarget(String queriedCompany);

}
