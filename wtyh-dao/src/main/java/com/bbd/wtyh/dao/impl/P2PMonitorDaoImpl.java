package com.bbd.wtyh.dao.impl;

import com.bbd.wtyh.dao.P2PMonitorDao;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by wangchenge on 2016/8/5 0005.
 */
@Repository("p2PMonitorDap")
public class P2PMonitorDaoImpl implements P2PMonitorDao {
    @Override
    public Map<String, Object> platFormName() {
        Map<String , Object> map = new HashMap<>();
        map.put("name" , "数联铭品");
        map.put("score" , "88");
        map.put("status" , "正常营业");
        return map;
    }
}
