package com.bbd.wtyh.service.impl;

import com.bbd.wtyh.entity.Test;
import com.bbd.wtyh.service.OfflineFinanceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
 * 线下理财接口实现层
 * @author zhouxuan
 * @since 2016.08.05
 */
@Service("offlineFinanceService")
public class OfflineFinanceServiceImpl implements OfflineFinanceService {


    @Override
    public List<Map> relatedGraph() {
        return null;
    }
}
