package com.bbd.wtyh.service;

import com.bbd.wtyh.domain.ParkRangeDO;

import java.util.List;

/**
 * Created by Barney on 2017/8/29.
 */
public interface ParkRangeService {

    void addParkRange(Integer userId, String parkArrStr, String operator);

    void delParkRangeByUserId(Integer userId);

    List<ParkRangeDO> queryParkRangeByUserId(Integer userId);
}
