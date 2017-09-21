package com.bbd.wtyh.constants;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 融资租赁风险等级
 *
 * @author Created by LiYao on 2017-04-27 10:52.
 */
public enum RZZLCoRiskLevel {

    NORMAL(0, "正常"),
    LATENT(1, "潜在");

    private int type;
    private String desc;

    RZZLCoRiskLevel(int type, String desc) {
        this.type = type;
        this.desc = desc;
    }

    public int type() {
        return this.type;
    }

    public String desc() {
        return this.desc;
    }

    public static List<Map<String, Object>> getListMap() {
        RZZLCoRiskLevel[] levels = RZZLCoRiskLevel.values();
        List<Map<String, Object>> riskList = new ArrayList<>();
        Map<String, Object> map = new HashMap<>();
        map.put("type", 0);
        map.put("desc", "全部状态");
        riskList.add(map);
        for (RZZLCoRiskLevel rl : levels) {
            map = new HashMap<>();
            map.put("type", rl.type());
            map.put("desc", rl.desc());
            riskList.add(map);
        }
        return riskList;
    }
}
