package com.bbd.wtyh.util;

import java.math.BigDecimal;

/**
 * Created by win7 on 2016/8/10.
 */
public class CalculateUtils {
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

}
