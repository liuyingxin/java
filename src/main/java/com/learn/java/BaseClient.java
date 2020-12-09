package com.learn.java;

import com.google.common.base.Joiner;
import com.google.common.collect.Maps;

import java.util.Map;
import java.util.TreeMap;

/**
 * @author ：zhaolijun
 * @description：
 * @date ：2020/5/18 19:18
 */
public abstract class BaseClient {

    protected String appendUrlParams(String baseUrl, Map<String, ?> map){
        StringBuilder url = new StringBuilder(baseUrl);
        url.append("?");
        url.append(
                Joiner.on("&").join(Maps.transformEntries(map, new Maps.EntryTransformer<String, Object, String>() {
                    @Override
                    public String transformEntry(String key, Object value) {
                        if (key == null) {
                            return "";
                        }
                        if (value == null) {
                            return key + "=";
                        }
                        return key + "=" + value;
                    }

                }).values()));
        return url.toString();

    }

    /**
     * 生成签名字符串，规则根据不同服务的请求自定
     * @param paramMap
     * @return
     */
    protected abstract String createSign(TreeMap<String, ?> paramMap);

}
