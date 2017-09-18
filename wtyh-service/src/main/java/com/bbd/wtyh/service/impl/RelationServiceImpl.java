package com.bbd.wtyh.service.impl;

import com.bbd.higgs.utils.ListUtil;
import com.bbd.wtyh.mapper.RelationMapper;
import com.bbd.wtyh.service.RelationService;
import com.bbd.wtyh.web.relationVO.RelationDiagramVO;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.CollectionUtils;

import java.util.List;

/**
 * Created by Barney on 2017/7/12. test
 */
@Service
public class RelationServiceImpl implements RelationService {

    @Autowired
    private RelationMapper mapper;
    private static final int batchCount = 5000;
    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void addRelation(RelationDiagramVO diagramVO, String queriedCompany,String bbdQyxxId) throws Exception {
        logger.info("Method[addRelation],targetCompany:" + queriedCompany+"  "+ bbdQyxxId);
        try {
            if (null == diagramVO ||
                    CollectionUtils.isEmpty(diagramVO.getLineList()) ||
                    CollectionUtils.isEmpty(diagramVO.getPointList())) {
                return;
            }
            //清除该企业的数据
            this.delLineByTarget(queriedCompany,bbdQyxxId);
            this.delPointByTarget(queriedCompany,bbdQyxxId);
            //新增线数据
            List<RelationDiagramVO.LineVO> list=diagramVO.getLineList();
            int totalCount = list.size();
            int pageSize = totalCount > batchCount ? batchCount : totalCount;
            int pageCount = (totalCount + pageSize - 1) / pageSize;

            int fromIndex ;
            int toIndex ;
            logger.info("Method[addRelation-Line],total count is " + totalCount + ",page count is " + pageCount);
            for (int i = 1; i <= pageCount; i++) {

                fromIndex = (i - 1) * pageSize;
                toIndex = fromIndex + pageSize;
                toIndex = toIndex < totalCount ? toIndex : totalCount;

                List<RelationDiagramVO.LineVO> batchList = list.subList(fromIndex, toIndex);
                if (ListUtil.isNotEmpty(batchList)) {

                    for (RelationDiagramVO.LineVO vo:batchList) {
                        vo.setQueriedCompany(queriedCompany);
                        vo.setBbdQyxxId(bbdQyxxId);
                    }
                    mapper.addLine(batchList);
                }
            }

            //新增点数据
            List<RelationDiagramVO.PointVO> pointList=diagramVO.getPointList();
            totalCount = pointList.size();
            pageSize = totalCount > batchCount ? batchCount : totalCount;
            pageCount = (totalCount + pageSize - 1) / pageSize;
            logger.info("Method[addRelation-Point],total count is " + totalCount + ",page count is " + pageCount);
            for (int i = 1; i <= pageCount; i++) {

                fromIndex = (i - 1) * pageSize;
                toIndex = fromIndex + pageSize;
                toIndex = toIndex < totalCount ? toIndex : totalCount;

                List<RelationDiagramVO.PointVO> batchList = pointList.subList(fromIndex, toIndex);
                if (ListUtil.isNotEmpty(batchList)) {
                    for (RelationDiagramVO.PointVO vo:batchList) {
                        vo.setQueriedCompany(queriedCompany);
                        vo.setBbdQyxxId(bbdQyxxId);
                    }
                    mapper.addPoint(batchList);
                }
            }
        } catch (Exception e) {
            logger.error("Method[addRelation],catch exception:" + e.getMessage());
            throw new Exception(e);
        }
    }

    @Override
    public void delLineByTarget(String queriedCompany,String bbdQyxxId) {
        int i=0;
        if(StringUtils.isNotBlank(bbdQyxxId)){
            i=mapper.delLineByQyxxId(bbdQyxxId);
        }
        if(0==i){
            mapper.delLineByTarget(queriedCompany);
        }

    }

    @Override
    public void delPointByTarget(String queriedCompany,String bbdQyxxId) {
        int i=0;
        if(StringUtils.isNotBlank(bbdQyxxId)){
            i=mapper.delPointByQyxxId(bbdQyxxId);
        }
        if(0==i){
            mapper.delPointByTarget(queriedCompany);
        }

    }

}
