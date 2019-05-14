package com.zjw.scaffold.core.code.strategy;

import com.zjw.scaffold.core.code.attribute.AutoCodeAttribute;
import org.apache.commons.lang3.StringUtils;

/**
 * @program scaffold
 * @description: 固定长度补0的自增长编号
 * @author: zhuangjiewei
 * @create: 2019/05/14 14:47
 */
public class ZeroIncreaseAutoCode implements AutoCodeStrategy  {

    @Override
    public String getNextCode(AutoCodeAttribute autoCodeAttribute) {
        return StringUtils.leftPad(String.valueOf(autoCodeAttribute.getNextValue()), autoCodeAttribute.getNumLength(), "0");
    }
}
