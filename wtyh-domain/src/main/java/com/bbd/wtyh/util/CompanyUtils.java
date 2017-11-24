package com.bbd.wtyh.util;


/**
 * 公司相关工具类
 */
public class CompanyUtils {

    /***
     *
     * 处理公司名
     * */
    public static String dealCompanyName(String name){
        if(org.apache.commons.lang.StringUtils.isEmpty(name)){
            return null;
        }
        //替换英文括号为中文括号，去掉名称中的空格
        name = name.replaceAll(" +","");
        name = name.replaceAll("\\(","（");
        name = name.replaceAll("\\)","）");
        return name;
    }
}
