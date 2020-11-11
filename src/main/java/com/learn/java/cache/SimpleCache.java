package com.learn.java.cache;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.METHOD})
public @interface SimpleCache {

    String key() default "";

    String[] value() default {""};

    /**
     * 缓存的 秒
     *
     * @return
     */
    int expireTime() default -1;
}
