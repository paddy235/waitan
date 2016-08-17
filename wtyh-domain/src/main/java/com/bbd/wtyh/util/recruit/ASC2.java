package com.bbd.wtyh.util.recruit;

import com.bbd.wtyh.util.relation.Utils;

/**
 * Created by wangchenge on 2016/8/17 0017.
 */
public class ASC2 {
    public static final char[] bcdLookup = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'b', 'c', 'd', 'e', 'f'};

    /**
     * 将字节串转化为十六进制字符串表示
     *
     * @param
     * @return
     */
    public static final String string2Hex(String string) {
        if (Utils.isNullForString(string)) {
            return null;
        }
        byte[] bytes = string.getBytes();
        StringBuffer sb = new StringBuffer(bytes.length * 2);
        for (int i = 0; i < bytes.length; i++) {
            sb.append(bcdLookup[(bytes[i] >>> 4) & 0x0f]);
            sb.append(bcdLookup[bytes[i] & 0x0f]);
        }
        return sb.toString();
    }

    /**
     * 将十六进制字符串转化为字串表示
     *
     * @param s
     * @return
     */
    public static final String hex2String(String s) {
        if (Utils.isNullForString(s)) {
            return null;
        }
        byte[] bytes = new byte[s.length() / 2];
        for (int i = 0; i < bytes.length; i++) {
            bytes[i] = (byte) Integer.parseInt(s.substring(2 * i, 2 * i + 2), 16);
        }
        return new String(bytes);
    }

//    public static void main(String[] args) {
//        String str = "攀枝花市交通旅游客运有限责任公司";
//        str = string2Hex(str);
////        String str1 = hex2String(str);
//        System.out.println(str);
//    }
}

