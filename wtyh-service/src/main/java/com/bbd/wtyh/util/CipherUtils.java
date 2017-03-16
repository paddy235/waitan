package com.bbd.wtyh.util;

import org.apache.commons.lang.StringUtils;
import org.apache.shiro.codec.Hex;
import org.apache.shiro.crypto.AesCipherService;

/**
 * Created by cgj on 2017/2/28.
 */
public class CipherUtils {
    private static final String AES_KEY = "7323ad76029faf9b16d65dfc762aea5c"; //不要修改
    private static AesCipherService aesCipherService;

    static {
        aesCipherService = new AesCipherService();
        aesCipherService.setKeySize(128); //设置key长度
    }

    public static String encrypt(String plaintext, String key) throws Exception {
        if (null == plaintext) {
            return plaintext;
        }
        if (StringUtils.isBlank(key))
            key = AES_KEY;
        return aesCipherService.encrypt(plaintext.getBytes("UTF-8"), Hex.decode(key)).toHex();
    }

    public static String encrypt(String plaintext) throws Exception {
        return encrypt(plaintext, null);
    }


    public static String decrypt(String ciphertext, String key) {
        if (StringUtils.isBlank(ciphertext)) {
            return ciphertext;
        }
        if (StringUtils.isBlank(key)) {
            key = AES_KEY;
        }
        String rstStr =null;
        try {
            rstStr =new String(aesCipherService.decrypt(Hex.decode(ciphertext), Hex.decode(key)).getBytes(),"UTF-8");
        } catch (Exception ee)        {
            rstStr ="";
        }
        return rstStr;
    }

    public static String decrypt(String ciphertext) {
        return decrypt(ciphertext, null);
    }


/*    public static void main(String[] args) throws Exception {
        String text = "王山";
        //加密
        String encrptText = CipherUtils.encrypt(text, "");
        String encrptText1 = CipherUtils.encrypt(text, "");
        //解密
        //encrptText ="3b028da7175bec72bf28b529d6eed4b0eecddbc9e80a0703299c1cc52df2b94d";
//        String text2 = CipherUtils.decrypt(encrptText, "");
//        encrptText ="0a11fc64e70b1a035a15523b470e4f7c226d045ff4d00424a2e586b4873c6e95";
        String text2 = CipherUtils.decrypt("c48d703a3cf91281b85f89ff6d27661b152eba8b066686cc4f8edfbc25cb0a18", "");
        String text3 = CipherUtils.decrypt("e47faef44f07976af2049f101d9a28c6ec089adda33a11fffa61151f7eda4af8", "");
//        System.out.println("原始值 : " + text);
//        System.out.println("加密值 : " + encrptText);
//        System.out.println("加密值 : " + encrptText1);
        System.out.println("解密值 : " + text2);
        System.out.println("解密值 : " + text3);

        String csn = AccessController.doPrivileged(
                new GetPropertyAction("file.encoding"));

        System.out.println(csn);

    }*/
    //String decryptPassword(String enPassword); //对用户密码解密

//    public static String byteToHexString(byte[] bytes){
//        StringBuffer sb = new StringBuffer();
//        for (int i = 0; i < bytes.length; i++) {
//            String strHex=Integer.toHexString(bytes[i]);
//            if(strHex.length() > 3){
//                sb.append(strHex.substring(6));
//            } else {
//                if(strHex.length() < 2){
//                    sb.append("0" + strHex);
//                } else {
//                    sb.append(strHex);
//                }
//            }
//        }
//        return  sb.toString();
//    }
//    public static byte[] hexStringToByte(String s) {
//        byte[] baKeyword = new byte[s.length() / 2];
//        for (int i = 0; i < baKeyword.length; i++) {
//            try {
//                baKeyword[i] = (byte) (0xff & Integer.parseInt(s.substring(i * 2, i * 2 + 2), 16));
//            } catch (Exception e) {
//                System.out.println("十六进制转byte发生错误！！！");
//                e.printStackTrace();
//            }
//        }
//        return baKeyword;
//    }
}
