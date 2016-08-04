package com.bbd.wtyh.web.util;

import java.io.UnsupportedEncodingException;
import java.nio.charset.Charset;

/**
 * Created by win7 on 2016/8/2.
 */
public class Q1 {
    public static void main(String[] args) throws UnsupportedEncodingException {
        String t = "我ABCD";
        byte[] bytes = t.getBytes();
        byte[] out_bytes = {bytes[0], bytes[1], bytes[2]};
        String out = new String(out_bytes, "UTF-8");
        System.out.println(out);
        System.out.println(Charset.defaultCharset());
        System.out.println(t.charAt(1));
        System.out.println(t.substring(0, 2));
    }
}
