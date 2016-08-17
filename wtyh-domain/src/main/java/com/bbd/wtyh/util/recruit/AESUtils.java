package com.bbd.wtyh.util.recruit;

import com.bbd.wtyh.util.relation.BbdException;
import sun.misc.BASE64Decoder;
import sun.misc.BASE64Encoder;

import javax.crypto.Cipher;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;

/**
 * @author wangchenge
 * @since 2016.08.16
 */
public class AESUtils {
    private static final String algorithm = "AES/CBC/PKCS5Padding";//"算法/模式/补码方式"
    private static final String aes = "AES";
    private static final String charCode = "ASCII";//编码类型
    private static final String model = "0102030405060708";//使用CBC模式，需要一个向量iv，可增加加密算法的强度
    public static final String screte = "1234567890123456";//密钥


    // 加密
    public static String encrypt(String sSrc, String sKey) {
        if (sKey == null) {
            return null;
        }
        // 判断Key是否为16位
        if (sKey.length() != 16) {

            return null;
        }
        String afterCode = null;
        try {
            byte[] raw = sKey.getBytes();
            Cipher cipher = Cipher.getInstance(algorithm);
            SecretKeySpec skeySpec = new SecretKeySpec(raw, aes);
            IvParameterSpec iv = new IvParameterSpec(model.getBytes());
            cipher.init(Cipher.ENCRYPT_MODE, skeySpec, iv);
            byte[] encrypted = cipher.doFinal(sSrc.getBytes());
            afterCode = new BASE64Encoder().encode(encrypted);//此处使用BASE64做转码功能，同时能起到2次加密的作用。
        } catch (Exception e) {
            throw new BbdException(e.getMessage());
        }
        return afterCode;
    }

    // 解密
    public static String decrypt(String sSrc, String sKey) {
        String originalString = null;
        try {
            // 判断Key密钥是否正确
            if (sKey == null) {

                return null;
            }
            // 判断Key是否为16位
            if (sKey.length() != 16) {

                return null;
            }
            byte[] raw = sKey.getBytes(charCode);
            SecretKeySpec skeySpec = new SecretKeySpec(raw, aes);
            Cipher cipher = Cipher.getInstance(algorithm);
            IvParameterSpec iv = new IvParameterSpec(model.getBytes());
            cipher.init(Cipher.DECRYPT_MODE, skeySpec, iv);
            byte[] encrypted1 = new BASE64Decoder().decodeBuffer(sSrc);//先用base64解密
            byte[] original = cipher.doFinal(encrypted1);
            originalString = new String(original);
        } catch (Exception e) {
            e.printStackTrace();
            throw new BbdException(e.getMessage());
        }
        return originalString;
    }
}
