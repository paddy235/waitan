package com.bbd.wtyh.service;

import com.bbd.wtyh.domain.ParkRangeDO;

import java.util.List;

/**
 * Created by Barney on 2017/8/29.
 */
public interface ParkRangeService {

    void addParkRange(List<ParkRangeDO> list) throws Exception;

    void delParkRangeByUserId(Integer userId) throws Exception;

    List<ParkRangeDO> queryParkRangeByUserId(Integer userId);
}
