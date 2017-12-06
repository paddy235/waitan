package com.bbd.wtyh.util;

import org.apache.commons.codec.binary.Base64;
import org.apache.commons.lang.StringUtils;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.net.URLEncoder;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 * 日期工具类
 * @since 2016/08/09
 */
public class DateUtils {

    public static String getLastMonth(Date date, int count) {
        DateFormat df = new SimpleDateFormat("yyyy-MM");
        Calendar c = Calendar.getInstance();
        c.setTime(date);
        c.add(Calendar.MONTH, count);
        return df.format(c.getTime());
    }

    public static String getLastMonth(Date date) {
        DateFormat df = new SimpleDateFormat("yyyy-MM");
        Calendar c = Calendar.getInstance();
        c.setTime(date);
        c.add(Calendar.MONTH, -1);
        return df.format(c.getTime());
    }

    public static String formatDate(Date date) {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyyMM");
        return sdf.format(date);
    }

    /*public static void main(String[] args) {
        System.out.print(formatDate(new Date()));
        System.out.print("\nstringToDate():" +stringToDate("2018-01-9 9:3:1"));
    }*/

    /**
     * 日期时间字符串转Date (by cgj)
     * @param strDate 格式"yyyy-MM-dd hh:mm:ss"
     * @return 中途任何转换失败的情况下均返回null
     */
    public static Date stringToDate(String strDate) {
        if(StringUtils.isBlank(strDate)) {
            return null;
        }
        Date tDate =null;
        try {
            SimpleDateFormat dateFormat =new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
            tDate =dateFormat.parse(strDate);
        } catch (Exception e) {
            tDate =null;
        }
        return tDate;
    }

    public static String formatDateYmd(Date date) {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        return sdf.format(date);
    }
}
