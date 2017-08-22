package com.bbd.data.service;

import com.bbd.wtyh.domain.vo.NewsVO;

/**
 * Created by Barney on 2017/8/17.
 */
public interface PABPublicSentimentService {

    @SuppressWarnings(value = "unused")
    void saveParkPublicSentiment() throws Exception;

    @SuppressWarnings(value = "unused")
    void saveBuildingPublicSentiment() throws Exception;

    NewsVO queryParkPublicSentiment(int areaId, String parkName);

    NewsVO queryBuildingPublicSentiment(int buildingId);

}
