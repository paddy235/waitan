package com.bbd.wtyh.service.impl;

import com.bbd.wtyh.domain.ParkRangeDO;
import com.bbd.wtyh.mapper.ParkRangeMapper;
import com.bbd.wtyh.service.ParkRangeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by Barney on 2017/8/29.
 */
@Service
public class ParkRangeServiceImpl implements ParkRangeService {

    @Autowired
    private ParkRangeMapper parkRangeMapper;

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void addParkRange(List<ParkRangeDO> list) throws Exception {
        try {
            parkRangeMapper.addParkRange(list);
        } catch (Exception e) {
            throw new Exception(e.getMessage(), e);
        }
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void delParkRangeByUserId(Integer userId) throws Exception {
        try {
            parkRangeMapper.delParkRangeByUserId(userId);
        } catch (Exception e) {
            throw new Exception(e.getMessage(), e);
        }
    }

    @Override
    public List<ParkRangeDO> queryParkRangeByUserId(Integer userId) {
        return parkRangeMapper.queryParkRangeByUserId(userId);
    }

}
