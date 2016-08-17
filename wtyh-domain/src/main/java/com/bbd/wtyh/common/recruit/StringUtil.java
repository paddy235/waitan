package com.bbd.wtyh.common.recruit;

/**
 * @author wangchenge
 * @since 2016.08.17
 */
public class StringUtil {
    /**
     * @description 判断是否为空字符
     */
    public static boolean isNullOrEmpty(String str) {
        return str == null || str.length() == 0;
    }

    /**
     * @description 判断是否不为空字符
     */
    public static boolean isNotNullOrEmpty(String str) {
        return !isNullOrEmpty(str);
    }
    /**
     * @description float 转字符串
     */
    public static String StringValueOf(Object obj) {
        return (obj == null) ? "" : obj.toString();
    }

}
