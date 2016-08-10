package com.bbd.wtyh.service;

import org.apache.poi.ss.formula.functions.T;

import java.util.Map;

/**
 * 楼宇详情接口层
 * @author tracy zhou
 * @since  2016/8/8
 */
public interface BuildingDetailsService {

    /**
     * 楼宇图片
     * @param buildingId
     * @return
     */
    public Map<T,T> buildingPicture(Integer buildingId);
}
