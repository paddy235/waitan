package com.bbd.data.mapper;

import com.bbd.wtyh.domain.vo.NewsVO;
import org.apache.ibatis.annotations.Delete;

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

    @Delete(" DELETE FROM building_public_sentiment WHERE id NOT IN (SELECT id FROM ( SELECT max(id) AS id FROM building_public_sentiment GROUP BY search_key,news_title,news_site,pubdate,building_id) rs ) ")
    void deleteRepeatBuildingPublicSentiment();

    @Delete(" DELETE FROM park_public_sentiment WHERE id NOT IN ( SELECT id FROM (SELECT MAX(id) id FROM park_public_sentiment GROUP BY search_key,news_title,news_site,pubdate,park) T) ")
    void deleteRepeatParkPublicSentiment();

}
