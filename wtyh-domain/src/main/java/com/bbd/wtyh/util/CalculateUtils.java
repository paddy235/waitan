package com.bbd.wtyh.util;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.math.BigDecimal;

/**
 * 计算工具类
 */
public class CalculateUtils {

    /**
     * @Description: 封装除法
     * @param bcs 被除数
     * @param cs 除数
     * @param scale 保留小数位数
     * @return    double
     * @throws
     */
    public static double divide(Number bcs,Number cs,int scale){
        if(cs.doubleValue() == 0){
            return 0;
        }
        BigDecimal bBcs = new BigDecimal(String.valueOf(bcs));
        BigDecimal bCs = new BigDecimal(String.valueOf(cs));
        return bBcs.divide(bCs, scale, BigDecimal.ROUND_HALF_EVEN).doubleValue();
    }

    /**
     * 精度调整
     * @param rate
     * @return
     */
    public static String format(double rate) {
        return String.format("%.3f", rate);
    }

    /**
     * 类型BigDecimal转化为String，并保留相应小数位
     *
     * @param b
     * @param dec
     * @return
     */
    public static String bigDecimal2Str(BigDecimal b, int dec) {
        if (null != b && dec > -1) {
            return b.divide(BigDecimal.ONE, dec, BigDecimal.ROUND_HALF_UP).toString();
        }
        return null;
    }


    /***
     *
     * 万元转亿元
     * */
    public static Double WanToYi(Integer wan){
        if(wan == null){
            return 0.0;
        }
        return new BigDecimal(""+wan).divide(new BigDecimal("10000"),1,BigDecimal.ROUND_HALF_UP).doubleValue();
    }

    public static String decimalFormat (float x) {
        java.text.DecimalFormat df = new java.text.DecimalFormat("#0.00");
        return df.format(x);
    }
}
