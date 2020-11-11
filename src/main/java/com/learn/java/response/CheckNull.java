package com.learn.java.response;

public class CheckNull {

    public static void isNull(Object object, String remark) {
        if (object == null) {
            throw new BusinessException(remark);
        }

    }
    public static void isNotNull(Object object, String remark) {
        if (object != null) {
            throw new BusinessException(remark);
        }

    }
    public static void isNumer(Object object, String remark) {
        if (object != null) {
            throw new BusinessException(remark);
        }

    }
}
