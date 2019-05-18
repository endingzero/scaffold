package com.zjw.scaffold.strategy;

import com.zjw.scaffold.attribute.AutoCodeAttribute;
import com.zjw.scaffold.util.DateUtils;

/**
 * @program scaffold
 * @description: 前缀+时间戳+第一种情况
 * @author: zhuangjiewei
 * @create: 2019/05/14 15:05
 */
public class PrefixDateIncreaseAutoCode implements AutoCodeStrategy {

    @Override
    public String getNextCode(AutoCodeAttribute autoCodeAttribute) {
        return autoCodeAttribute.getPrefix() + DateUtils.formatShortCurrent() + autoCodeAttribute.getNextValue();
    }
}
