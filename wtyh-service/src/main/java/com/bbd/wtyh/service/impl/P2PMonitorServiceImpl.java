package com.bbd.wtyh.service.impl;

import com.bbd.wtyh.dao.P2PMonitorDao;
import com.bbd.wtyh.service.P2PMonitorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Map;

/**
 * P2P平台状态信息业务层
 *
 * @author wangchenge
 * @since 2016.08.05
 */
@Service("p2PMonitorService")
public class P2PMonitorServiceImpl implements P2PMonitorService {
    @Autowired
    private P2PMonitorDao p2PMonitorDao;

    @Override
    public Map<String, Object> platFormStatus() {
        return p2PMonitorDao.platFormStatus();
    }

    @Override
    public Map<String, Object> platFormConsensus() {
        return p2PMonitorDao.platFormConsensus();
    }

    @Override
    public Map<String, Object> lawsuitMsg() {
        return p2PMonitorDao.lawsuitMsg();
    }

    @Override
    public Map<String, Object> radarScore() {
        return p2PMonitorDao.radarScore();
    }
}
