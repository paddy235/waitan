package com.bbd.wtyh.util;

import org.apache.commons.codec.binary.Base64;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.net.URLEncoder;

/**
 * author: jerry
 */
public class DigestUtils {
    public final static String ENCODING = "UTF-8";

    public final static String DIGEST_KEY = "k5kX7H3S79RL1biHlVY3kOuIABv9Yw71ub59HRN3blqvpRel95QW9u5Cub7a19Hu";


    public static String decodeBase64(String data) {
        byte[] _date = data.getBytes();
        try {
            return new String(Base64.decodeBase64(_date), ENCODING);
        } catch (UnsupportedEncodingException e) {
            throw new RuntimeException("encoding unknow", e);
        }
    }

    public static String decodeBase64(String data, String encoding) {
        byte[] _date = data.getBytes();
        try {
            return new String(Base64.decodeBase64(_date), encoding);
        } catch (UnsupportedEncodingException e) {
            throw new RuntimeException("encoding unknow", e);
        }
    }

    public static String encodeBase64(String data) {
        byte[] _date = data.getBytes();
        try {
            return new String(Base64.encodeBase64(_date), ENCODING);
        } catch (UnsupportedEncodingException e) {
            throw new RuntimeException("encoding unknow", e);
        }
    }

    public static byte[] encodeBase64ToByte(byte[] data) {
        try {
            return Base64.encodeBase64(data);
        } catch (Exception e) {
            throw new RuntimeException("encoding unknow", e);
        }
    }

    public static String encodeBase64(byte[] date) {
        try {
            return new String(Base64.encodeBase64(date), ENCODING);
        } catch (UnsupportedEncodingException e) {
            throw new RuntimeException("encoding unknow", e);
        }
    }

    public static byte[] decodeBase64(byte[] date) {
        return Base64.decodeBase64(date);
    }


    public static String encodeBase64(String data, String encoding) {
        byte[] _date = data.getBytes();
        try {
            return new String(Base64.encodeBase64(_date), encoding);
        } catch (UnsupportedEncodingException e) {
            throw new RuntimeException("encoding unknow", e);
        }
    }

    public static String encodeBase64(String data, String byteEncoding, String encoding) {
        try {
            byte[] _date = data.getBytes(byteEncoding);
            return new String(Base64.encodeBase64(_date), encoding);
        } catch (UnsupportedEncodingException e) {
            throw new RuntimeException("encoding unknow", e);
        }
    }

    public static String md5(String data) {
        return org.apache.commons.codec.digest.DigestUtils.md5Hex(data);
    }

    public static String md5(byte[] data) {
        return org.apache.commons.codec.digest.DigestUtils.md5Hex(data);
    }


    public static String urlEncode(String data, String encoding) {
        try {
            return URLEncoder.encode(data, encoding);
        } catch (UnsupportedEncodingException e) {
            throw new RuntimeException("encoding unknow", e);
        }
    }

    public static String urlDecode(String data, String encoding) {
        try {
            return URLDecoder.decode(data, encoding);
        } catch (UnsupportedEncodingException e) {
            throw new RuntimeException("encoding unknow", e);
        }
    }
}
