package com.bbd.wtyh.util;

import java.math.BigDecimal;
import java.math.RoundingMode;

/**
 * 计算工具类
 */
public class CalculateUtil {
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
        BigDecimal bBcs = new BigDecimal("0"+bcs);
        BigDecimal bCs = new BigDecimal("0"+cs);
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
}
