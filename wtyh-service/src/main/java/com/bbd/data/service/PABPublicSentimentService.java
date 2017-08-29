package com.bbd.data.service;

import com.bbd.wtyh.domain.vo.NewsVO;

/**
 * Created by Barney on 2017/8/17.
 */
public interface PABPublicSentimentService {

    NewsVO queryParkPublicSentiment(int areaId, String parkName);

    NewsVO queryBuildingPublicSentiment(int buildingId);

}
