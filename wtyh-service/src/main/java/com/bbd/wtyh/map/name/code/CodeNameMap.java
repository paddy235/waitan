package com.bbd.wtyh.map.name.code;

import com.bbd.wtyh.log.user.Operation;
import com.bbd.wtyh.service.UserInfoService;
import com.bbd.wtyh.service.impl.UserInfoServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by cgj on 2017/3/24.
 */
public class CodeNameMap {
    static List<Map<String, Object>> areaCodeList; //区域代码表
    static byte ifCnt =0;
    static Map<Integer, String> areaCodeMap; //区域代码字典
    static {
        updateShanghaiAreaCodeTable(null);
    }

    static public void setAreaCodeList(List<Map<String, Object>> areaCodeList) {
        if( 0== ifCnt)
            updateShanghaiAreaCodeTable(areaCodeList);
        ifCnt++;
    }

    static public List<Map<String, Object>> getAndUpdateShanghaiAreaCodeTable() {
        updateShanghaiAreaCodeTable(null);
        return areaCodeList;
    }
    static public void updateShanghaiAreaCodeTable(List<Map<String, Object>> areaCodeListIn)  {
        if(null ==areaCodeListIn) {
            UserInfoService uis = new UserInfoServiceImpl();
            try {
                areaCodeList = uis.getShanghaiAreaCodeTable("0"); //读取区域代码表
            } catch (Exception e) {
                areaCodeList = new ArrayList<Map<String, Object>>() {{
                    add(new HashMap<String, Object>() {{
                        put("areaId", (Integer) (0));
                        put("cityName", "全部");
                    }});
                    add(new HashMap<String, Object>() {{
                        put("areaId", (Integer) (104));
                        put("cityName", "上海全区");
                    }});
                }};
            }
        }else {
            CodeNameMap.areaCodeList = areaCodeListIn;
        }
        areaCodeMap = new HashMap<Integer, String>();
        for (Map<String, Object> itr : areaCodeList) { //构造一个区域代码名称字典
            areaCodeMap.put((Integer) itr.get("areaId"), (String) itr.get("cityName"));
        }
    }
    static public List<Map<String, Object>> quickGetShanghaiAreaCodeTable() {  return areaCodeList; }
    static public Map<Integer, String> getShanghaiAreaCodeMap() {  return areaCodeMap; }


    static List<Map<String, Object>> sysLocationList; //系统位置表
    static Map<Integer, String> sysLocationMap; //系统位置字典
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
    static public List<Map<String, Object>> getSysLocationList() {  return sysLocationList; }
    static public Map<Integer, String> getSysLocationMap() {  return sysLocationMap; }


    static List<Map<String, Object>> opTypeList; //操作类型表
    static Map<Integer, String> opTypeMap; //操作类型字典
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
    static public List<Map<String, Object>> getOpTypeList() {  return opTypeList; }
    static public Map<Integer, String> getOpTypeMap() {  return opTypeMap; }


    static List<Map<String, Object>> opPageList; //操作页面表
    static Map<Integer, String> opPageMap; //操作页面字典
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
    static public List<Map<String, Object>> getOpPageList() {  return opPageList; }
    static public Map<Integer, String> getOpPageMap() {  return opPageMap; }
}
