package com.bbd.wtyh.service.impl;

import com.alibaba.fastjson.JSON;
import com.bbd.wtyh.core.base.BaseService;
import com.bbd.wtyh.core.base.BaseServiceImpl;
import com.bbd.wtyh.log.user.UserLog;
import com.bbd.wtyh.service.LogInfoService;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.io.*;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.regex.Pattern;

/**
 * Created by Administrator on 2017/3/18 0018.
 */
@Service
public class LogInfoServiceImpl extends BaseServiceImpl implements LogInfoService{
    @Value("${userActionLog.path}")
    private String userActionLogDir;

    /**
     * 将日志文件导入数据库
     */
    @Override
    //@Scheduled(cron = "0 0 1 * * ?")
    public void exportLogFileToDataBase(String operDate) {
        String date=null;
        if(null==operDate){
            date=getPreDay(0);//处理当前日期前一天的数据
        }else{
            date=operDate;
        }

        File fileDir =new File(userActionLogDir);
        if(!fileDir.isDirectory()){
            //fileDir .mkdir(); //创建目录
            return;
        }
        String[] list;
        String pattern="^userLog_"+date+"_\\d+.log$";//匹配 userLog_2017-03-18_数字
        list = fileDir.list(filter(pattern));
        Arrays.sort(list, String.CASE_INSENSITIVE_ORDER);
        for (String string : list) {
            loadLogFromFile(userActionLogDir+File.separator+string);
        }

    }

    /**
     * 把日志文件导入数据库
     */
    public void loadLogFromFile(String filePath) {
        // TODO Auto-generated method stub
        List<String> list=new ArrayList<String>();
        List<UserLog> userLogList=new ArrayList<UserLog>();
        BufferedReader reader = null;
        BufferedWriter writer = null;
        String errFilePath=filePath+ ".error";

        try {
            //读取日志文件
            File fileSource=new File(filePath);
            if(!fileSource.exists()){
                return;
            }
            //先删除错误日志
            File errFile=new File(errFilePath);
            if(errFile.exists()){
                errFile.delete();
            }
            InputStreamReader isr = new InputStreamReader(new FileInputStream(fileSource), "UTF-8");
            reader = new BufferedReader(isr);
            String tempString = null;
            tempString = reader.readLine();
            // 一次读入一行，直到读入null为文件结束
            while (tempString != null) {

                if (null==tempString || tempString.equals("")) {
                    continue;
                }

                try{
                    UserLog userLog = JSON.parseObject(tempString, UserLog.class);
                    userLogList.add(userLog);
                }catch (Exception e){
                    list.add(tempString);
                    e.printStackTrace();
                }

                if(userLogList.size()>=100){
                    addLogs(userLogList);
                    userLogList.clear();
                }

                tempString = reader.readLine();
            }
            addLogs(userLogList);
            userLogList.clear();
            reader.close();

            //备份出错的行到error文件
            File newErrFile=new File(filePath+ ".error");
            OutputStreamWriter osw = new OutputStreamWriter(new FileOutputStream(newErrFile), "UTF-8");
            writer = new BufferedWriter(osw);
            for(String str:list){
                if(null!=str && !str.equals("")){
                    writer.write(str);
                    writer.newLine();
                }

            }
            writer.flush();
            writer.close();

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (reader != null) {
                try {
                    reader.close();
                } catch (IOException e1) {
                }
            }
            if (writer != null) {
                try {
                    writer.close();
                } catch (IOException e1) {
                }
            }
        }

    }


    private void addLogs(List<UserLog> list) {
        // TODO Auto-generated method stub
        try{
            insertList(list);
        }catch(Exception e){
            e.printStackTrace();
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

    public static FilenameFilter filter(final String regex) {

        return new FilenameFilter() {
            private Pattern pattern = Pattern.compile(regex);

            @Override
            public boolean accept(File dir, String name) {
                return pattern.matcher(name).matches();
            }
        };
    }

}
