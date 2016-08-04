package com.bbd.wtyh.web.util;

/**
 * Created by win7 on 2016/8/2.
 */
public class Q3 {
    public static void main(String[] args) {
        String a = "￥2011";
//        String[] as = a.split("￥");
//        System.out.println(as.length);
//        for (String e : a.split("￥")) {
//            System.out.println("1");
//            System.out.println(e);
//        }
        System.out.println(a.replace("￥", ""));
    }
}
