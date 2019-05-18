package com.zjw.scaffold.strategy;

import com.zjw.scaffold.attribute.AutoCodeAttribute;
import com.zjw.scaffold.util.DateUtils;
import org.apache.commons.lang3.StringUtils;

/**
 * @program scaffold
 * @description: 时间戳+第二种情况
 * @author: zhuangjiewei
 * @create: 2019/05/14 15:03
 */
public class DateZeroIncreaseAutoCode implements AutoCodeStrategy {

    @Override
    public String getNextCode(AutoCodeAttribute autoCodeAttribute) {
        return DateUtils.formatShortCurrent() + StringUtils.leftPad(String.valueOf(autoCodeAttribute.getNextValue()), autoCodeAttribute.getNumLength(), "0");
    }
}
