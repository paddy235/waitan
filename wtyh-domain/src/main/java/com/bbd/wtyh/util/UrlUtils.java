package com.bbd.wtyh.util;

import org.apache.commons.lang3.StringUtils;

/**
 * Created by Administrator on 2017/9/15 0015.
 */
public class UrlUtils {

    public static String assembleUrlByNameOrId(String url,String name,String id){
        StringBuffer sb=new StringBuffer();
        String condition;
        if(!StringUtils.isEmpty(id)){
            condition="&qyxx_id="+id;
        }else{
            condition="&company="+name;
        }
        sb.append(url);
        sb.append(condition);
        return sb.toString();
    }
}
