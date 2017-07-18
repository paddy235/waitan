package com.bbd.wtyh.test;


import java.util.HashMap;
import java.util.Map;

/**
 * Created by Administrator on 2017/6/30 0030.
 */
public class MainTest {

    public static  void  main(String[]args){
        Integer planCount = null;// 计划执行笔数。 可在任务结束时更新
        Integer successCount=null;
        Integer failCount=null;
        Map map = new HashMap();
        try{
            map.put("planCount",10);
            reSetResultCount( planCount, successCount, failCount, map);
            System.out.println(planCount);
            System.out.println(successCount);
            System.out.println(failCount);

        }catch (Exception e){
            e.printStackTrace();
            System.out.println(e.toString());
        }
    }

    public static void reSetResultCount(Integer planCount,Integer successCount,Integer failCount,Map map){
        if(null!=map){
            planCount=map.get("planCount")==null?null:(Integer)map.get("planCount");
            successCount=map.get("successCount")==null?null:(Integer)map.get("successCount");
            failCount=map.get("failCount")==null?null:(Integer)map.get("failCount");
        }
    }
}
