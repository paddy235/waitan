package com.bbd.wtyh.cashetobean;

import com.bbd.wtyh.mapper.UserInfoMapper;
import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by Administrator on 2017/4/13.
 */
public class ShanghaiAreaCode {
    //private static UserInfoService uis;
    private static UserInfoMapper userInfoMapper;

    public static void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        //ShanghaiAreaCode.applicationContext = applicationContext;
        userInfoMapper = applicationContext.getBean(UserInfoMapper.class);

        //首次从数据库中取出区域代码表
        updateList(null);
        updateCnt++;
    }

    private static byte updateCnt =0;
    private static List<Map<String, Object>> list; //区域代码表
    private static Map<Integer, String> map; //区域代码字典

    /**
     *
     * @param areaCodeListIn 为null时自己读取数据库更新，否则通过外部表更新
     */
    public static void updateList(List<Map<String, Object>> areaCodeListIn)  {
        if(null ==areaCodeListIn) {
            try {
                list = userInfoMapper.selectShanghaiAreaCodeTable();
                if (null != list) {
                    for (Map<String, Object> iter : list) {
                        if (null != iter.get("areaId") && 104 == (Integer) iter.get("areaId")) {
                            iter.put("cityName", "上海全区");
                            break;
                        }
                    }
                }
            } catch (Exception e) {
                list = new ArrayList<Map<String, Object>>() {{
                    add(new HashMap<String, Object>() {{
                        put("areaId", (Integer) (104));
                        put("cityName", "上海全区");
                    }});
                }};
            }
            list.add(0, new HashMap<String, Object>() {{
                put("areaId", (Integer) (0));
                put("cityName", "全部");
            }});
        }else {
            list = areaCodeListIn;
        }
        map = new HashMap<Integer, String>();
        for (Map<String, Object> itr : list) { //构造一个区域代码名称字典
            map.put((Integer) itr.get("areaId"), (String) itr.get("cityName"));
        }
    }

    /**
     * 获取和内部更新上海市区代码表
     * @param isImm 是否立即更新
     * @return
     */
    static public List<Map<String, Object>> getAndUpdateList(boolean isImm) {
        if(isImm || 0== updateCnt) {
            updateList(null);
        }
        updateCnt++;
        return list;
    }

    public static List<Map<String, Object>> quickGetList() {
        return list;
    }

    public static Map<Integer, String> getMap() {
        return map;
    }
}
