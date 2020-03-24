package com.cerr.school_api.utils;

import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**
 * 使用SHA算法来加密
 */
public class shaEncryption {

    public static String encryption(String data) throws NoSuchAlgorithmException {
        data += "cerr";
        //信息摘要器
        MessageDigest md = MessageDigest.getInstance("SHA");
        //把字符串转为字节数组
        byte[] b = data.getBytes();
        //使用指定的字节来更新我们的摘要
        md.update(b);
        //md.digest()进行哈希运算
        String str = new BigInteger(md.digest()).toString(32);
        return str;
    }
}
