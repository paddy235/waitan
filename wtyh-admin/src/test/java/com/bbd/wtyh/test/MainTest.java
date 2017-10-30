package com.bbd.wtyh.test;

import com.bbd.wtyh.domain.CompanyDO;
import com.bbd.wtyh.domain.CompanyInfoModify.CompanyInfo;

/**
 * 
 * Created by Administrator on 2017/6/30 0030.
 */
public class MainTest {

    public static void main(String[] args) {
        CompanyDO companyDO=new CompanyDO();
        companyDO.setCompanyType(Byte.valueOf("4"));
        System.out.println(CompanyInfo.TYPE_XXLC_4 == (companyDO.getCompanyType() == null ? CompanyInfo.TYPE_XXLC_4 : companyDO.getCompanyType()));
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
