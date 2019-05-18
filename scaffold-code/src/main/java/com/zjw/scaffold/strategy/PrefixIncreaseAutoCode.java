package com.zjw.scaffold.strategy;

import com.zjw.scaffold.attribute.AutoCodeAttribute;

/**
 * @program scaffold
 * @description:
 * @author: zhuangjiewei
 * @create: 2019/05/14 18:03
 */
public class PrefixIncreaseAutoCode implements AutoCodeStrategy{
    @Override
    public String getNextCode(AutoCodeAttribute autoCodeAttribute) {
        return autoCodeAttribute.getPrefix() + autoCodeAttribute.getNextValue();
    }
}
