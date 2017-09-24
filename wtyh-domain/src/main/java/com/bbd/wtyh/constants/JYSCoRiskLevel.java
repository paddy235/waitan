package com.bbd.wtyh.constants;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 交易场所风险等级
 *
 * @author Created by LiYao on 2017-04-27 10:52.
 */
public enum JYSCoRiskLevel {
    HAPPEN(1, "已出风险"),
    IMPORT_FOCUS(2, "重点关注"),
    COMMON_FOCUS(3, "一般关注"),
    NORMAL(4, "正常");

    private int type;
    private String desc;

    JYSCoRiskLevel(int type, String desc) {
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
        List<Map<String, Object>> riskList = new ArrayList<>();
        Map<String, Object> map = new HashMap<>();
        map.put("type", 0);
        map.put("desc", "全部状态");
        riskList.add(map);

        JYSCoRiskLevel[] jysCoRiskLevels = JYSCoRiskLevel.values();
        for (JYSCoRiskLevel rl : jysCoRiskLevels) {
            map = new HashMap<>();
            map.put("type", rl.type());
            map.put("desc", rl.desc());
            riskList.add(map);
        }
        return riskList;
    }

    public static Map<String, Integer> getMap() {
        Map<String, Integer> rst = new HashMap();
        for (JYSCoRiskLevel companyLevel : JYSCoRiskLevel.values()) {
            rst.put(companyLevel.desc(), companyLevel.type());
        }
        return rst;
    }

    public static String getRiskDesc(int risk) {
        for (JYSCoRiskLevel level : JYSCoRiskLevel.values()) {
            if (level.type() == risk) {
                return level.desc();
            }
        }
        return null;
    }

    public static Integer getRiskType(String desc) {
        for (JYSCoRiskLevel level : JYSCoRiskLevel.values()) {
            if (level.desc.equals(desc)) {
                return level.type();
            }
        }
        return null;
    }
}
