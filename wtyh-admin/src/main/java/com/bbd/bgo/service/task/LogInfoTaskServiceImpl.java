package com.bbd.bgo.service.task;


import com.bbd.higgs.utils.StringUtils;
import com.bbd.higgs.utils.http.HttpCallback;
import com.bbd.higgs.utils.http.HttpTemplate;
import com.bbd.wtyh.core.base.BaseServiceImpl;
import com.bbd.wtyh.service.LogInfoService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 * Created by Administrator on 2017/3/20 0020.
 */
@Service
public class LogInfoTaskServiceImpl extends BaseServiceImpl implements LogInfoTaskService{

    @Autowired
    private LogInfoService logInfoService;
    @Value("${wtyh.web1.url}")
    private String wtyh_web1_url;
    @Value("${wtyh.web2.url}")
    private String wtyh_web2_url;

    private static Long counts;

    Logger logger= LoggerFactory.getLogger(LogInfoTaskServiceImpl.class);

    @Scheduled(cron = "0 0 1 * * ?")
    public void exportLogFileTask() {
        exportLogFile(null);
    }

    public void exportLogFile(String operDate) {
        logger.info("日志入库程序开始");
        String date=null;
        if(null==operDate){
            //定时任务
            date=getPreDay(1);//处理当前日期前一天的数据
        }else{
            //手动调用
            date=operDate;
        }
        counts=1L;
        //先删除表里的数据
        logger.info("日志入库-删除原日志数据开始");
        executeCUD("delete from user_behavior_log where operation_date like '"+date+"%'");
        logger.info("日志入库-删除原日志数据结束");
        //后台管理系统的日志
        Long tempCounts;
        logger.info("日志入库-后台系统入库开始");
        tempCounts=logInfoService.exportLogFileToDataBase(date,counts);
        if(null!=tempCounts && 0!=tempCounts){
            counts=tempCounts;
        }
        logger.info("日志入库-后台系统入库结束，累计笔数"+(counts-1));

        //web1 前台业务系统的日志
        String web1=wtyh_web1_url+"?date="+date+"&counts="+counts;
        logger.info("日志入库-业务系统"+web1+"入库开始");
        tempCounts=callHttpRequest(web1);
        if(null!=tempCounts && 0!=tempCounts){
            counts=tempCounts;
        }
        logger.info("日志入库-业务系统"+web1+"入库结束，累计笔数"+(counts-1));

        //web2 前台业务系统的日志 上海有2台服务器，成都只有一台服务器
        if(!StringUtils.isNullOrEmpty(wtyh_web2_url)){
            String web2=wtyh_web2_url+"?date="+date+"&counts="+counts;
            logger.info("日志入库-业务系统"+web2+"入库开始");
            tempCounts=callHttpRequest(web2);
            if(null!=tempCounts && 0!=tempCounts){
                counts=tempCounts;
            }
            logger.info("日志入库-业务系统"+web2+"入库结束，累计笔数"+(counts-1));
        }
    }

    private Long callHttpRequest(String url){

        HttpTemplate httpTemplate = new HttpTemplate();
        try {
            return httpTemplate.get(url, new HttpCallback<Long>() {
                @Override
                public boolean valid() {
                    return true;
                }

                @Override
                public Long parse(String result) {
                    return Long.parseLong(result);
                }
            });

        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    /**
     * 取当前日期之前后者之后某一天
     **/
    private static String getPreDay(int size){
        String preDay=null;
        try{
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");

            Calendar c = Calendar.getInstance();
            c.add(Calendar.DATE, - size);
            Date today = c.getTime();
            preDay = sdf.format(today);

        }catch(Exception e){
        }
        return preDay;
    }
}
