package com.bbd.wtyh.dao.impl;

import com.bbd.wtyh.dao.P2PMonitorDao;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.Map;

/**
 * p2p检测平台dao层
 * @author wangchenge
 * @since 2016.08.05
 */
@Repository("p2PMonitorDap")
public class P2PMonitorDaoImpl implements P2PMonitorDao {
    @Override
    public Map<String, Object> platFormStatus() {
        Map<String , Object> map = new HashMap<>();
        map.put("name" , "数联铭品");
        map.put("score" , "88");
        map.put("status" , "正常营业");
        return map;
    }
}
