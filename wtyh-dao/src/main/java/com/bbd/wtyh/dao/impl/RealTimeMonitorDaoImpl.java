package com.bbd.wtyh.dao.impl;

import com.bbd.wtyh.dao.RealTimeMonitorDao;
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
    @Override
    public Map<String, Object> shMapMonitor() {
        Date date = new Date();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        Map<String, Object> data = new LinkedHashMap<>();
        data.put("已监控企业数", 82315);
        data.put("监控日期", sdf.format(date));
        data.put("举报信息", 845);
        data.put("监测广告", 465);
        data.put("打非监测", 73250);
        data.put("互联网金融监测", 273);
        return data;
    }
}
