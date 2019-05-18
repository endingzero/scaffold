package com.zjw.scaffold.strategy;

import com.zjw.scaffold.attribute.AutoCodeAttribute;
import org.apache.commons.lang3.StringUtils;

/**
 * @program scaffold
 * @description:
 * @author: zhuangjiewei
 * @create: 2019/05/14 18:04
 */
public class PrefixZeroIncreaseAutoCode implements AutoCodeStrategy {
    @Override
    public String getNextCode(AutoCodeAttribute autoCodeAttribute) {
        return autoCodeAttribute.getPrefix() + StringUtils.leftPad(String.valueOf(autoCodeAttribute.getNextValue()), autoCodeAttribute.getNumLength(), "0");
    }
}
