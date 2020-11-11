package com.learn.java.cache;


import com.alibaba.fastjson.JSON;
import com.learn.java.config.SpringBeanUtil;
import org.apache.commons.lang3.StringUtils;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Component;

import java.lang.reflect.Type;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.concurrent.TimeUnit;

@Aspect
@Component
public class SimpleCacheAop extends BasicCacheAop {
    private static final Logger log = LoggerFactory.getLogger(SimpleCacheAop.class);

    public SimpleCacheAop() {
    }

    @Around("execution(* *(..)) && @annotation(cache)")
    public Object simpleRedisCache(ProceedingJoinPoint pjp, SimpleCache cache) throws Throwable {
        RedisTemplate stringRedisTemplate = SpringBeanUtil.getBean("redisTemplate", RedisTemplate.class);
        if (null == stringRedisTemplate) {
            return pjp.proceed();
        }
        String methodName = getMethodName(pjp);
        String calKey = justJoinToGetCacheKey(cache.key(), this.getMethodName(pjp), this.getArgName2Value(pjp), cache.value());
        String cacheKey = calKey;
        if (calKey.length() > SIMPLE_CACHE_KEY_MAX_LEN) {
            cacheKey = md5str(cacheKey);
        }

        log.info("simpleRedisCache method：{},calKey:{},key:{}", methodName, calKey, cacheKey);
        Boolean isContainKey = stringRedisTemplate.hasKey(cacheKey);
        if (isContainKey) {
            String cacheVal = (String) stringRedisTemplate.opsForValue().get(cacheKey);
            if ("###+--**-+###".equals(cacheVal)) {
                return null;
            }

            if (StringUtils.isNotBlank(cacheVal)) {
                Type returnType = this.getReturnType(pjp);
                log.info("缓存method：{},key:{},命中redis.", methodName, calKey);
                return JSON.parseObject(cacheVal, returnType);
            }
        }

        log.warn("[REDIS] can't find value from simple cache :{} , maybe will get from db", calKey);
        Object res = pjp.proceed();
        stringRedisTemplate.delete(cacheKey);
        if (null != res) {
            if (res instanceof Character) {
                if (cache.expireTime() > 0) {
                    stringRedisTemplate.opsForValue().set(cacheKey, res.toString(), (long) cache.expireTime(), TimeUnit.SECONDS);
                } else {
                    stringRedisTemplate.opsForValue().set(cacheKey, res.toString());
                }
            } else {
                String jsonVal = JSON.toJSONString(res);
                if (StringUtils.isNotEmpty(jsonVal)) {
                    if (cache.expireTime() > 0) {
                        stringRedisTemplate.opsForValue().set(cacheKey, jsonVal, (long) cache.expireTime(), TimeUnit.SECONDS);
                    } else {
                        stringRedisTemplate.opsForValue().set(cacheKey, jsonVal);
                    }
                } else {
                    log.error("缓存method:{},key：{}，失败，方法返回值序列化为json为空", methodName, cacheKey);
                }
            }
        } else if (cache.expireTime() > 0) {
            log.warn("[REDIS] will add empty value, cacheKey:{}, expires: {} ", cacheKey, cache.expireTime());
            stringRedisTemplate.opsForValue().set(cacheKey, "###+--**-+###", (long) cache.expireTime(), TimeUnit.SECONDS);
        }

        return res;

    }


    private static String md5str(String plainText) {
        String re_md5;
        try {
            MessageDigest md = MessageDigest.getInstance("MD5");
            md.update(plainText.getBytes());
            byte b[] = md.digest();

            int i;

            StringBuffer buf = new StringBuffer("");
            for (int offset = 0; offset < b.length; offset++) {
                i = b[offset];
                if (i < 0)
                    i += 256;
                if (i < 16)
                    buf.append("0");
                buf.append(Integer.toHexString(i));
            }

            re_md5 = buf.toString();

        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
            return plainText;
        }
        return re_md5;
    }

}
