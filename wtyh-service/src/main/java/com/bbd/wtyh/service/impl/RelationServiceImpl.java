package com.bbd.wtyh.service.impl;

import com.bbd.higgs.utils.ListUtil;
import com.bbd.wtyh.domain.RelationDO;
import com.bbd.wtyh.mapper.RelationMapper;
import com.bbd.wtyh.service.RelationService;
import com.bbd.wtyh.web.relationVO.RelationDiagramVO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Barney on 2017/7/12.
 */
@Service
public class RelationServiceImpl implements RelationService {

    @Autowired
    private RelationMapper mapper;
    private static final int batchCount = 5000;
    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void addRelation(List<RelationDiagramVO.LineVO> list, String targetCompany) throws Exception {
        logger.info("Method[addRelation],targetCompany:" + targetCompany);
        try {
            this.delRelationByTarget(targetCompany);
            int totalCount = list.size();
            int pageSize = totalCount > batchCount ? batchCount : totalCount;
            int pageCount = (totalCount + pageSize - 1) / pageSize;

            int fromIndex;
            int toIndex;
            logger.info("Method[addRelation],total count is" + totalCount + ",page count is" + pageCount);
            for (int i = 1; i <= pageCount; i++) {

                fromIndex = (i - 1) * pageSize;
                toIndex = fromIndex + pageSize;
                toIndex = toIndex < totalCount ? toIndex : totalCount;

                List<RelationDiagramVO.LineVO> batchList = list.subList(fromIndex, toIndex);
                List<RelationDO> relationList = new ArrayList<>();
                if (ListUtil.isNotEmpty(batchList)) {
                    for (RelationDiagramVO.LineVO vo:batchList) {
                        RelationDO rdo = new RelationDO();
                        rdo.setInvestee(vo.getOrigName());
                        rdo.setInvesteeNo(Integer.parseInt(vo.getOrigLevel()));
                        rdo.setInvestorsNo(Integer.parseInt(vo.getTarLevel()));
                        rdo.setRelationship(vo.getType());
                        rdo.setTargetCompany(targetCompany);
                        rdo.setInvestors(vo.getTargetName());
                        rdo.setRelationship(vo.getRelationship());

                        relationList.add(rdo);
                    }
                    mapper.addRelation(relationList);
                }
            }
        } catch (Exception e) {
            logger.error("Method[addRelation],catch exception:" + e.getMessage());
            throw new Exception(e);
        }
    }

    @Override
    public void delRelationByTarget(String targetCompany) {
        mapper.delRelationByTarget(targetCompany);
    }

}
