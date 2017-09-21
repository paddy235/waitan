package com.bbd.wtyh.constants;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 预付卡风险等级
 *
 * @author Created by LiYao on 2017-04-27 13:37.
 */
public enum PrepaidCoRiskLevel {

    NORMAL(4, "正常"),
    LATENT(3, "潜在"),
    HAPPEN(2, "已发生");

    private int type;
    private String desc;

    PrepaidCoRiskLevel(int type, String desc) {
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
        PrepaidCoRiskLevel[] levels = PrepaidCoRiskLevel.values();
        List<Map<String, Object>> riskList = new ArrayList<>();
        Map<String, Object> map = new HashMap<>();
        map.put("type", 0);
        map.put("desc", "全部状态");
        riskList.add(map);
        for (PrepaidCoRiskLevel rl : levels) {

            map = new HashMap<>();
            map.put("type", rl.type());
            map.put("desc", rl.desc());
            riskList.add(map);
        }
        return riskList;
    }

    public static Map<String, Integer> getMap() {
        Map<String, Integer> rst = new HashMap();
        for (PrepaidCoRiskLevel companyLevel : PrepaidCoRiskLevel.values()) {
            rst.put(companyLevel.desc(), companyLevel.type());
        }
        return rst;
    }

}
