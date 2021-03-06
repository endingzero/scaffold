package com.zjw.scaffold.strategy;

import com.zjw.scaffold.attribute.AutoCodeAttribute;
import com.zjw.scaffold.util.DateUtils;

/**
 * @program scaffold
 * @description: 时间戳+第一种情况
 * @author: zhuangjiewei
 * @create: 2019/05/14 14:50
 */
public class DateIncreaseAutoCode implements AutoCodeStrategy{
    @Override
    public String getNextCode(AutoCodeAttribute autoCodeAttribute) {
        return DateUtils.formatShortCurrent() + autoCodeAttribute.getNextValue();
    }
}
