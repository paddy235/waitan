/**
 * BrandBigData.com Inc.
 * Copyright (c) 2016 All Rights Reserved.
 */
package com.bbd.wtyh.util.relation;

import java.io.UnsupportedEncodingException;

/**
 * @author xumin
 * @version ${Id}:URLEncoder.java, v0.1 2016/12/29 0029 下午 1:41 xumin
 */
public class URLEncoder {

    public static String encode(String conent) {
        try {
            return java.net.URLEncoder.encode(conent, "utf-8");
        } catch (UnsupportedEncodingException e) {
            throw new RuntimeException(e.getMessage(), e);
        }

    }
}
