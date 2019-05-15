package com.zjw.scaffold.core.code.cache;

import com.zjw.scaffold.core.code.attribute.AutoCodeAttribute;

import java.util.concurrent.ConcurrentHashMap;

/**
 * @program scaffold
 * @description:
 * @author: zhuangjiewei
 * @create: 2019/05/15 17:34
 */
public class AutoCodeCache {

    private static final ConcurrentHashMap<String, AutoCodeAttribute> autoCodeMap = new ConcurrentHashMap<>();

    public static AutoCodeAttribute put(AutoCodeAttribute autoCodeAttribute) {
        return autoCodeMap.put(autoCodeAttribute.getCode(),autoCodeAttribute);
    }

    public static AutoCodeAttribute get(String code) {
        return autoCodeMap.get(code);
    }


}
