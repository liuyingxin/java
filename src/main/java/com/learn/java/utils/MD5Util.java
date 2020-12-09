package com.learn.java.utils;

import org.springframework.util.DigestUtils;

public class MD5Util {
    public MD5Util() {
    }

    public static String md5DigestAsHex(byte[] bytes) {
        return DigestUtils.md5DigestAsHex(bytes);
    }
}
