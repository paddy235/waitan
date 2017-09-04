package com.bbd.wtyh.service.impl;

import com.bbd.higgs.utils.ListUtil;
import com.bbd.wtyh.domain.ParkRangeDO;
import com.bbd.wtyh.mapper.ParkRangeMapper;
import com.bbd.wtyh.service.ParkRangeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by Barney on 2017/8/29.
 */
@Service
public class ParkRangeServiceImpl implements ParkRangeService {

    @Autowired
    private ParkRangeMapper parkRangeMapper;

    @Override
    public void addParkRange(Integer userId, String parkArrStr, String operator) {
        try {
            if (null != userId && !StringUtils.isEmpty(parkArrStr) && !StringUtils.isEmpty(operator)) {
                String[] parkArr = parkArrStr.split(",");
                if (null != parkArr && parkArr.length >= 1) {
                    List<String> parkIdList = Arrays.asList(parkArr);
                    if (ListUtil.isNotEmpty(parkIdList)) {
                        List<ParkRangeDO> list = new ArrayList<>();

                        parkIdList.forEach((String parkId) -> {
                            ParkRangeDO prdo = new ParkRangeDO();
                            prdo.setParkId(Integer.parseInt(parkId));
                            prdo.setUserId(userId);
                            prdo.setCreateBy(operator);
                            prdo.setUpdateBy(operator);

                            list.add(prdo);
                        });

                        if (ListUtil.isNotEmpty(list))
                            parkRangeMapper.addParkRange(list);
                    }
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void delParkRangeByUserId(Integer userId) {
        parkRangeMapper.delParkRangeByUserId(userId);
    }

    @Override
    public List<ParkRangeDO> queryParkRangeByUserId(Integer userId) {
        return parkRangeMapper.queryParkRangeByUserId(userId);
    }

    @Override
    public void delParkRangeByParkId(Integer parkId) {
        parkRangeMapper.delParkRangeByParkId(parkId);
    }

}
