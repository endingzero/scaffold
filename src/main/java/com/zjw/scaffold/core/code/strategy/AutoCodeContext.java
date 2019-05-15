package com.zjw.scaffold.core.code.strategy;

import com.zjw.scaffold.core.code.attribute.AutoCodeAttribute;
import com.zjw.scaffold.core.code.enums.AutoCodeType;

import java.util.concurrent.ConcurrentHashMap;

/**
 * @program scaffold
 * @description: 编码注册
 * @author: zhuangjiewei
 * @create: 2019/05/14 17:49
 */
public class AutoCodeContext {
    private static final ConcurrentHashMap<String, AutoCodeStrategy> noStrategyMap = new ConcurrentHashMap();

    public static AutoCodeStrategy get(AutoCodeAttribute autoCodeAttribute) {
        return noStrategyMap.get(autoCodeAttribute.getName());
    }

    public static AutoCodeStrategy get(String name) {
        return noStrategyMap.get(name);
    }

    static {
        noStrategyMap.put(AutoCodeType.INCREMENT.name(),new IncreaseAutoCode());
        noStrategyMap.put(AutoCodeType.ZERO_INCREMENT.name(),new ZeroIncreaseAutoCode());
        noStrategyMap.put(AutoCodeType.DATE_INCREMENT.name(), new ZeroIncreaseAutoCode());
        noStrategyMap.put(AutoCodeType.DATE_ZERO_INCREMENT.name(), new DateZeroIncreaseAutoCode());
        noStrategyMap.put(AutoCodeType.PREFIX_INCREMENT.name(), new PrefixIncreaseAutoCode());
        noStrategyMap.put(AutoCodeType.PREFIX_DATE_INCREMENT.name(), new PrefixDateIncreaseAutoCode());
        noStrategyMap.put(AutoCodeType.PREFIX_ZERO_INCREMENT.name(), new PrefixZeroIncreaseAutoCode());
        noStrategyMap.put(AutoCodeType.PREFIX_DATE_ZERO_INCREMENT.name(), new PrefixDateZeroIncreaseAutoCode());
    }
}
