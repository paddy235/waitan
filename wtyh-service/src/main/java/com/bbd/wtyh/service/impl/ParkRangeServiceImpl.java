package com.bbd.wtyh.service.impl;

import com.bbd.wtyh.domain.ParkRangeDO;
import com.bbd.wtyh.mapper.ParkRangeMapper;
import com.bbd.wtyh.service.ParkRangeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by Barney on 2017/8/29.
 */
@Service
public class ParkRangeServiceImpl implements ParkRangeService {

    @Autowired
    private ParkRangeMapper parkRangeMapper;

    @Override
    public void addParkRange(List<ParkRangeDO> list) {
        parkRangeMapper.addParkRange(list);
    }

    @Override
    public void delParkRangeByUserId(Integer userId) {
        parkRangeMapper.delParkRangeByUserId(userId);
    }

    @Override
    public List<ParkRangeDO> queryParkRangeByUserId(Integer userId) {
        return parkRangeMapper.queryParkRangeByUserId(userId);
    }

}
