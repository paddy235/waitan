package com.bbd.wtyh.mapper;


import com.bbd.wtyh.web.relationVO.RelationDiagramVO;

import java.util.List;

/**
 * Created by Barney on 2017/7/12.
 */
public interface RelationMapper {
    
    void addLine( List<RelationDiagramVO.LineVO> list);

    void delLineByTarget(String queriedCompany);

    void addPoint(List<RelationDiagramVO.PointVO> list);

    void delPointByTarget(String queriedCompany);

}
