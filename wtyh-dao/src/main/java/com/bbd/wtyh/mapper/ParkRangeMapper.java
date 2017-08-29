package com.bbd.wtyh.mapper;

import com.bbd.wtyh.domain.ParkRangeDO;

import java.util.List;

/**
 * Created by Barney on 2017/8/29.
 */
public interface ParkRangeMapper {

    /**
     * 新增用户的园区访问范围
     *
     * @param list
     */
    void addParkRange(List<ParkRangeDO> list);

    /**
     * 删除用户的园区访问范围
     *
     * @param userId
     */
    void delParkRangeByUserId(Integer userId);

    /**
     * 根据用户ID查询其园区访问范围
     *
     * @param userId
     * @return
     */
    List<ParkRangeDO> queryParkRangeByUserId(Integer userId);

}
