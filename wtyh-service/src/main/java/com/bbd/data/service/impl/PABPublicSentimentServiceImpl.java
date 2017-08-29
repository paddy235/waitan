package com.bbd.data.service.impl;

import com.bbd.data.mapper.PABPublicSentimentMapper;
import com.bbd.data.service.PABPublicSentimentService;
import com.bbd.wtyh.domain.vo.NewsVO;
import com.bbd.wtyh.util.relation.ListUtils;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.*;

/**
 * Created by Barney on 2017/8/17.
 */
@Service
public class PABPublicSentimentServiceImpl implements PABPublicSentimentService {

    private Logger logger = LoggerFactory.getLogger(this.getClass());
    @Autowired
    private PABPublicSentimentMapper pabPublicSentimentMapper;

    @Override
    public NewsVO queryParkPublicSentiment(int areaId, String parkName) {
        if (areaId <= 0 || StringUtils.isEmpty(parkName))
            return null;
        /* 组装参数 */
        Map<String, Object> params = new HashMap<>();
        params.put("areaId", areaId);
        params.put("parkName", parkName);

        int count = pabPublicSentimentMapper.queryParkPublicSentimentCount(params);
        if (count <= 0)
            return null;
        // TODO 注意这里最多只请求20条数据
        List<NewsVO.Result> list = pabPublicSentimentMapper.queryParkPublicSentiment(params);

        NewsVO newsVO = new NewsVO();
        newsVO.setMsg("成功获取园区舆情信息。");
        newsVO.setRsize(ListUtils.isEmpty(list) ? 0 : list.size());
        newsVO.setTotal(count);
        newsVO.setResults(list);
        return newsVO;
    }

    @Override
    public NewsVO queryBuildingPublicSentiment(int buildingId) {
        if (buildingId <= 0)
            return null;
        int count = pabPublicSentimentMapper.queryBuildingPublicSentimentCount(buildingId);
        if (count <= 0)
            return null;
        // TODO 注意这里最多只请求20条数据
        List<NewsVO.Result> list = pabPublicSentimentMapper.queryBuildingPublicSentiment(buildingId);

        NewsVO newsVO = new NewsVO();
        newsVO.setMsg("成功获取楼宇舆情信息。");
        newsVO.setRsize(ListUtils.isEmpty(list) ? 0 : list.size());
        newsVO.setTotal(count);
        newsVO.setResults(list);
        return newsVO;
    }

}
