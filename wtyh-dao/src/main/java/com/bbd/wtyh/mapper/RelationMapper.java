package com.bbd.wtyh.mapper;


import com.bbd.wtyh.web.relationVO.RelationDiagramVO;

import java.util.List;

/**
 * Created by Barney on 2017/7/12.
 */
public interface RelationMapper {
    
    void addLine( List<RelationDiagramVO.LineVO> list);

    int delLineByTarget(String queriedCompany);

    int delLineByQyxxId(String bbdQyxxId);

    void addPoint(List<RelationDiagramVO.PointVO> list);

    int delPointByTarget(String queriedCompany);

    int delPointByQyxxId(String bbdQyxxId);

}
