package com.bbd.wtyh.util;

import org.apache.commons.lang.StringUtils;

import javax.servlet.http.HttpServletRequest;

/**
 * wtyh
 *
 * @author Created by LiYao on 2017-09-19 14:45.
 */
public class IPUtil {

    public static String getRemoteAddress(HttpServletRequest request) {
        String ip = request.getHeader("Wtyh-Real-IP");
        if (StringUtils.isBlank(ip) || ip.equalsIgnoreCase("unknown")) {
            ip = request.getHeader("X-Real-IP");
        }
        if (StringUtils.isBlank(ip) || ip.equalsIgnoreCase("unknown")) {
            ip = request.getHeader("x-forwarded-for");
        }
        if (StringUtils.isBlank(ip) || ip.equalsIgnoreCase("unknown")) {
            ip = request.getHeader("Proxy-Client-IP");
        }
        if (StringUtils.isBlank(ip) || ip.equalsIgnoreCase("unknown")) {
            ip = request.getHeader("WL-Proxy-Client-IP");
        }
        if (StringUtils.isBlank(ip) || ip.equalsIgnoreCase("unknown")) {
            ip = request.getRemoteAddr();
        }
        return ip;
    }
}
