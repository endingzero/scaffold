package com.zjw.scaffold.core.code.strategy;

import com.zjw.scaffold.core.code.attribute.AutoCodeAttribute;
import com.zjw.scaffold.util.DateUtils;
import org.apache.commons.lang3.StringUtils;

/**
 * @program scaffold
 * @description: 前缀+时间戳+第二种情况
 * @author: zhuangjiewei
 * @create: 2019/05/14 15:07
 */
public class PrefixDateZeroIncreaseAutoCode implements AutoCodeStrategy{
    @Override
    public String getNextCode(AutoCodeAttribute autoCodeAttribute) {
        return autoCodeAttribute.getPrefix() + DateUtils.formatShortCurrent() + StringUtils.leftPad(String.valueOf(autoCodeAttribute.getNextValue()), autoCodeAttribute.getNumLength(), "0");
    }
}
