package com.bbd.data.mapper;

import com.bbd.wtyh.domain.vo.NewsVO;

import java.util.List;
import java.util.Map;

/**
 * Created by Barney on 2017/8/18.
 */
public interface PABPublicSentimentMapper {

    void addParkPublicSentiment(NewsVO.Result result);

    void addBuildingPublicSentiment(NewsVO.Result result);

    List<NewsVO.Result> queryParkPublicSentiment(Map<String, Object> params);

    int queryParkPublicSentimentCount(Map<String, Object> params);

    List<NewsVO.Result> queryBuildingPublicSentiment(int buildingId);

    int queryBuildingPublicSentimentCount(int buildingId);

}
