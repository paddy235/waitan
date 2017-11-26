package com.bbd.wtyh.dao.impl;

import com.bbd.wtyh.dao.RealTimeMonitorDao;
import com.bbd.wtyh.mapper.CompanyMapper;
import com.bbd.wtyh.mapper.SysConfigMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.validation.Valid;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

/**
 * Created by wangchenge on 2016/8/20 0020.
 */
@Repository("realTimeMonitorDao")
public class RealTimeMonitorDaoImpl implements RealTimeMonitorDao {

    private String MonitorNum;
    private String juBaoMsg;
    private String MonitorAd;
    private String daFeiMonitor;
    private String internetMonitor;
    private String rollInfo;
    @Autowired
    private CompanyMapper companyMapper;
    @Autowired
    private SysConfigMapper sysConfigMapper;
    @Override
    public Map<String, Object> shMapMonitor() {
        int count = companyMapper.countAllCompany();
        rollInfo = sysConfigMapper.findByKey("rollInfo");
        Date date = new Date();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        Map<String, Object> data = new LinkedHashMap<>();
        data.put("已监控企业数", count);
        data.put("监控日期", sdf.format(date));
        data.put("rollInfo", rollInfo);
        return data;
    }
}
