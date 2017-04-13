package com.bbd.wtyh.map.name.code;

import com.bbd.wtyh.common.comenum.UserType;
import com.bbd.wtyh.log.user.Operation;
import com.bbd.wtyh.service.UserInfoService;
import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
        opPageList =new ArrayList<Map<String, Object>>() {{
            add( new  HashMap<String, Object>() {{
                put("opPgCd", (Integer)(-1));
                put("opPage", "全部");
            }} );
            for (  Operation.Page opPg  : Operation.Page.values() ) {
                if( opPg.code() >0 ) {
                    add(new HashMap<String, Object>() {{
                        put("opPgCd", (Integer) opPg.code());
                        put("opPage", opPg.page());
                    }});
                }
            }
        }};
        opPageMap = new HashMap<Integer, String>();
        for ( Map<String, Object>itr: opPageList ) { //构造一个操作页面字典
            opPageMap.put( (Integer) itr.get("opPgCd") , (String) itr.get("opPage"));
        }
    }
    public static List<Map<String, Object>> getOpPageList() {  return opPageList; }
    public static Map<Integer, String> getOpPageMap() {  return opPageMap; }
}
