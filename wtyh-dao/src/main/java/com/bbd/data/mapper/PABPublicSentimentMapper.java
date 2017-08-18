package com.bbd.data.mapper;

import com.bbd.wtyh.domain.vo.NewsVO;

import java.util.List;

/**
 * Created by Barney on 2017/8/18.
 */
public interface PABPublicSentimentMapper {

    void addParkPublicSentiment(NewsVO.Result result);

    void addBuildingPublicSentiment(NewsVO.Result result);

}
