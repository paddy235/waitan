package com.bbd.wtyh.map.name.code;

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
public class CodeNameMap implements ApplicationContextAware {
    private static ApplicationContext applicationContext;
    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        CodeNameMap.applicationContext = applicationContext;
        uis = CodeNameMap.applicationContext.getBean(UserInfoService.class);
        //首次从数据库中取出区域代码表
        updateShanghaiAreaCodeTable(null);
        updateCnt++;
    }
//    static ApplicationContext context = new ClassPathXmlApplicationContext("spring-config.xml");
//    static UserInfoService uis = context.getBean(UserInfoService.class);
    static UserInfoService uis;
    static List<Map<String, Object>> shanghaiAreaCodeList; //区域代码表
    static byte updateCnt =0;
    static Map<Integer, String> shanghaiAreaCodeMap; //区域代码字典

    /**
     *
     * @param shanghaiAreaCodeList
     * @param isImm 是否立即更新
     */
    static public void setShanghaiAreaCodeList(List<Map<String, Object>> shanghaiAreaCodeList, boolean isImm) {
        if(isImm || 0== updateCnt) {
            updateShanghaiAreaCodeTable(shanghaiAreaCodeList);
        }
        updateCnt++;
    }

    /**
     * 获取和内部更新上海市区代码表
     * @param isImm 是否立即更新
     * @return
     */
    static public List<Map<String, Object>> getAndUpdateShanghaiAreaCodeTable(boolean isImm) {
        if(isImm || 0== updateCnt) {
            updateShanghaiAreaCodeTable(null);
        }
        updateCnt++;
        return shanghaiAreaCodeList;
    }
    static public void updateShanghaiAreaCodeTable(List<Map<String, Object>> areaCodeListIn)  {
        if(null ==areaCodeListIn) {
            try {
                shanghaiAreaCodeList = uis.getShanghaiAreaCodeTable("0"); //读取区域代码表
            } catch (Exception e) {
                shanghaiAreaCodeList = new ArrayList<Map<String, Object>>() {{
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
            shanghaiAreaCodeList = areaCodeListIn;
        }
        shanghaiAreaCodeMap = new HashMap<Integer, String>();
        for (Map<String, Object> itr : shanghaiAreaCodeList) { //构造一个区域代码名称字典
            shanghaiAreaCodeMap.put((Integer) itr.get("areaId"), (String) itr.get("cityName"));
        }
    }
    static public List<Map<String, Object>> quickGetShanghaiAreaCodeTable() {  return shanghaiAreaCodeList; }
    static public Map<Integer, String> getShanghaiAreaCodeMap() {  return shanghaiAreaCodeMap; }


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

    static List<Map<String, String>> userTypeList; //用户类型表
    static Map<String, String> userTypeMap; //用户类型字典
    static {
        userTypeList =new ArrayList<Map<String, String>>() {{
            add( new  HashMap<String, String>() {{
                put("tpCode", "T");
                put("tpName", "全部");
            }} );
            for (  UserInfoService.UserType uType  :  UserInfoService.UserType.values() ) {
                add(new HashMap<String, String>() {{
                    put("tpCode", uType.getTypeCode() );
                    put("tpName", uType.getTypeName() );
                }});
            }
        }};
        userTypeMap = new HashMap<String, String>();
        for ( Map<String, String>itr: userTypeList ) { //构造一个字典
            userTypeMap.put( (String) itr.get("tpCode") , (String) itr.get("tpName"));
        }
    }
    static public List<Map<String, String>> getUserTypeList() {  return userTypeList; }
    static public Map<String, String> getUserTypeMap() {  return userTypeMap; }

    static List<Map<String, String>> userStatusList; //用户类型表
    static Map<String, String> userStatusMap; //用户类型字典
    static {
        userStatusList =new ArrayList<Map<String, String>>() {{
            add( new  HashMap<String, String>() {{
                put("stsCode", "T");
                put("stsName", "全部");
            }} );
            for (  UserInfoService.UserStatus uStatus  :  UserInfoService.UserStatus.values() ) {
                add(new HashMap<String, String>() {{
                    put("stsCode", uStatus.getStatusCode() );
                    put("stsName", uStatus.getStatusName() );
                }});
            }
        }};
        userStatusMap = new HashMap<String, String>();
        for ( Map<String, String>itr: userStatusList ) { //构造一个字典
            userStatusMap.put( (String) itr.get("stsCode") , (String) itr.get("stsName"));
        }
    }
    static public List<Map<String, String>> getUserStatusList() {  return userStatusList; }
    static public Map<String, String> getUserStatusMap(){  return userStatusMap; }
}
