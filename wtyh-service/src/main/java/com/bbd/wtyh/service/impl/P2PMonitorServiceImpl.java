package com.bbd.wtyh.service.impl;

import com.bbd.wtyh.dao.P2PMonitorDao;
import com.bbd.wtyh.service.P2PMonitorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Map;

/**
 * P2P平台名称信息业务层
 * @author wangchenge
 * @since 2016.8.5
 */
@Service("p2PMonitorService")
public class P2PMonitorServiceImpl implements P2PMonitorService{
    @Autowired
    private P2PMonitorDao p2PMonitorDao;
    @Override
    public Map<String, Object> platFormName() {
        return p2PMonitorDao.platFormName();
    }
}
