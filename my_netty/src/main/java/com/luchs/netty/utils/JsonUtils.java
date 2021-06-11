package com.luchs.netty.utils;

import com.alibaba.fastjson.JSON;
import com.google.gson.GsonBuilder;

/**
 * @Author cheng
 * @Date 2021/5/31
 */
public class JsonUtils {

    private static final GsonBuilder gb = new GsonBuilder();
    static {
        // 不需要html escape
        gb.disableHtmlEscaping();
    }

    public static String pojoToJson(Object o) {
        return gb.create().toJson(o);
    }

    public static <T> T jsonToPojo(String json, Class<T> clazz) {
        return JSON.parseObject(json, clazz);
    }

}
