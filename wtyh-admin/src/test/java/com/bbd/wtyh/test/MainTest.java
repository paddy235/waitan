package com.bbd.wtyh.test;


import org.apache.commons.lang3.time.DateFormatUtils;
import org.apache.commons.lang3.time.DateUtils;
import org.springframework.scheduling.support.CronSequenceGenerator;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.temporal.TemporalAdjusters;
import java.util.Date;
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
            String formatDay="yyyy-MM-dd";
            String format="yyyy-MM-dd HH:mm:ss";
            LocalDate today = LocalDate.now();
            int day=today.getDayOfWeek().getValue();
            int del=day-1;
            String newDay=null;
            if(del>0){
                newDay=today.minusDays(del).format(DateTimeFormatter.ofPattern(formatDay));
            }else{
                newDay=today.format(DateTimeFormatter.ofPattern(formatDay));
            }

            CronSequenceGenerator cronSequenceGenerator = new CronSequenceGenerator("0 0 18 ? * 5");

            String run=DateFormatUtils.format(cronSequenceGenerator.next(DateUtils.parseDate(newDay,formatDay)),format);
            System.out.println(run);
            int planRun=LocalDate.parse(run, DateTimeFormatter.ofPattern(format)).getDayOfWeek().getValue();
            System.out.println("今天是周几："+day);
            System.out.println("计划是周几："+planRun);
            if(day<planRun){
                System.out.println("任务未启动");
            }
            else if(day==planRun){
                System.out.println("从第一笔开始执行");
            }else{
                System.out.println("从前一天任务接着执行");
            }

            /*map.put("planCount",10);
            reSetResultCount( planCount, successCount, failCount, map);
            System.out.println(planCount);
            System.out.println(successCount);
            System.out.println(failCount);*/

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
