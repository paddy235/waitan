package com.bbd.wtyh.test;

import com.bbd.wtyh.domain.CompanyDO;

/**
 * 
 * Created by Administrator on 2017/6/30 0030.
 */
public class MainTest {

    public static void main(String[] args) {

        String userName=" 甬钜信息科技（上海）有限公司";
        String userNami=" 甬钜信息科技（上海）有限公司";
        System.out.println("test:"+userNami.trim());
        String str=" ";
        System.out.println(str);
        String ss = stringToUnicode(str);
        System.out.println(ss);
    }



    public static String stringToUnicode(String s) {
        String str = "";
        for (int i = 0; i < s.length(); i++) {
            int ch = (int) s.charAt(i);
            if (ch > 255)
                str += s.charAt(i) + ":" + "\\u" + Integer.toHexString(ch)
                        + "\n";
            else
                str += s.charAt(i) + ":" + "\\u00" + Integer.toHexString(ch)
                        + "\n";
        }
        return str;
    }

}
