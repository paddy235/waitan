package com.bbd.wtyh.dao.impl;

import com.bbd.higgs.utils.http.HttpTemplate;
import com.bbd.wtyh.common.Constants;
import com.bbd.wtyh.dao.OfflineFinanceDao;
import com.bbd.wtyh.domain.dto.RelationDTO;
import com.bbd.wtyh.domain.dto.RelationRealDTO;
import com.bbd.wtyh.mapper.OfflineFinanceMapper;
import com.bbd.wtyh.redis.RedisDAO;
import com.bbd.wtyh.util.relation.URLEncoder;
import com.bbd.wtyh.web.relationVO.LineVO;
import com.bbd.wtyh.web.relationVO.RelationDiagramVO;
import com.bbd.wtyh.web.relationVO.SubGraphVO;
import com.google.gson.Gson;
import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Repository;

import java.util.List;


/**
 *
 */
@Repository("offlineFinanceDao")
public class OfflineFinanceDaoImpl implements OfflineFinanceDao {

    private static final Logger LOGGER = LoggerFactory.getLogger(OfflineFinanceDaoImpl.class);

    @Value("${relation.real.url}")
    private String relationRealUrl;

    @Value("${relation.url}")
    private String relationUrl;

    @Autowired
    private RedisDAO    redisDAO;

    @Autowired
    private HttpTemplate httpTemplate;

    @Autowired
    private OfflineFinanceMapper offlineFinanceMapper;

    @Override
    public RelationDTO queryRealation(String companyName, String dateVersion) {
        String redisKey = Constants.REDIS_KEY_RELATION_URL + "_" + companyName + "_" + dateVersion;
        String response = redisDAO.getString(redisKey);
        if (StringUtils.isEmpty(response)) {
            try {
                LOGGER.info("关联方接口：" + relationUrl + companyName + "&date=" + dateVersion);
                response = httpTemplate.get(relationUrl + URLEncoder.encode(companyName) + "&date=" + dateVersion);
                redisDAO.addString(redisKey, response, Constants.cacheDay);
            } catch (Exception e) {
                LOGGER.error(e.getMessage(), e);
            }
        }
        return new Gson().fromJson(response, RelationDTO.class);
    }

    @Override
    public SubGraphVO queryRealTimeRelation(String unikey, String degree) {
        try {
            LOGGER.info("request_url:" + relationRealUrl + "?unikey=" + unikey + "&degree=" + degree);
            String response = httpTemplate.get(relationRealUrl + "?unikey=" + unikey + "&degree=" + degree);
            LOGGER.debug("request_result:" + response);
            Gson gson = new Gson();
            RelationRealDTO relationNowDTO = gson.fromJson(response, RelationRealDTO.class);
            LOGGER.info("request_result:" + relationNowDTO.getData());
            return relationNowDTO.getData();
        } catch (Exception e) {
            LOGGER.error(e.getMessage(), e);
        }
        return null;
    }

    @Override
    public RelationDiagramVO queryRealationFromDb(String companyName, Integer degree){
        RelationDiagramVO diagramVO ;
        try {
            List  lineVOList = offlineFinanceMapper.queryLineByName(companyName,degree);
            if(CollectionUtils.isEmpty(lineVOList)){
                return null;
            }
            List  pointVOList = offlineFinanceMapper.queryPointByName(companyName,degree);
            if(CollectionUtils.isEmpty(pointVOList)){
                return null;
            }
            diagramVO= new RelationDiagramVO();
            diagramVO.setLineList(lineVOList);
            diagramVO.setPointList(pointVOList);
        } catch (Exception e) {
            LOGGER.error(e.getMessage(), e);
            return null;
        }
        return diagramVO;
    }
}
