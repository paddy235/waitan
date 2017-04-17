package com.bbd.wtyh.map.name.code;

import com.bbd.wtyh.log.user.Operation;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static com.bbd.wtyh.log.user.Operation.Page.OP_PAGE_MAP_KEY;

/**
 * Created by cgj on 2017/3/24.
 */

public class CodeNameMap {

    private static List<Map<String, Object>> sysLocationList; //系统位置表
    private static Map<Integer, String> sysLocationMap; //系统位置字典
    static {
        sysLocationList = new ArrayList<Map<String, Object>>() {{
            add(new HashMap<String, Object>() {{
                put("sysCode", (Integer) (-1));
                put("sysName", "全部");
            }});
            for (Operation.System opS : Operation.System.values()) {
                add(new HashMap<String, Object>() {{
                    put("sysCode", (Integer) opS.sysCode());
                    put("sysName", opS.sysName());
                }});
            }
        }};
        sysLocationMap = new HashMap<Integer, String>();
        for (Map<String, Object> itr : sysLocationList) { //构造一个系统位置字典
            sysLocationMap.put((Integer) itr.get("sysCode"), (String) itr.get("sysName"));
        }
    }
    public static List<Map<String, Object>> getSysLocationList() {  return sysLocationList; }
    public static Map<Integer, String> getSysLocationMap() {  return sysLocationMap; }


    private static List<Map<String, Object>> opTypeList; //操作类型表
    private static Map<Integer, String> opTypeMap; //操作类型字典
    static {
        opTypeList = new ArrayList<Map<String, Object>>() {{
            add(new HashMap<String, Object>() {{
                put("opTpCd", (Integer) (-1));
                put("opType", "全部");
            }});
            for (Operation.Type opT : Operation.Type.values()) {
                add(new HashMap<String, Object>() {{
                    put("opTpCd", (Integer) opT.code());
                    put("opType", opT.desc());
                }});
            }
        }};
        opTypeMap = new HashMap<Integer, String>();
        for (Map<String, Object> itr : opTypeList) { //构造一个操作类型字典
            opTypeMap.put((Integer) itr.get("opTpCd"), (String) itr.get("opType"));
        }
    }
    public static List<Map<String, Object>> getOpTypeList() {  return opTypeList; }
    public static Map<Integer, String> getOpTypeMap() {  return opTypeMap; }


    private static List<Map<String, Object>> opPageList; //操作页面表
    private static Map<Integer, String> opPageMap; //操作页面字典
    static {
        opPageList =Operation.Page.getOpPageListBySystem(true,null, true);
        opPageMap =(Map<Integer, String>)opPageList.get(opPageList.size() -1).get(OP_PAGE_MAP_KEY);
        opPageList.remove(opPageList.size() -1); //删除无用的项
    }
    public static List<Map<String, Object>> getOpPageList() {  return opPageList; }
    public static Map<Integer, String> getOpPageMap() {  return opPageMap; }
}
