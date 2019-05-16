package com.zjw.scaffold.core.code.strategy;

import com.zjw.scaffold.core.code.attribute.AutoCodeAttribute;

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
