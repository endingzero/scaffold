package com.zjw.scaffold.core.code.strategy;

import com.zjw.scaffold.core.code.attribute.AutoCodeAttribute;

/**
 * @program scaffold
 * @description:
 * 1. 固定长度补0的自增长编号
 * 2. 不补0的自增长编号
 * 3. 时间戳+第一种情况
 * 4. 时间戳+第二种情况
 * 5. 前缀+第一种情况
 * 6. 前缀+第二种情况
 * 7. 前缀+时间戳+第一种情况
 * 8. 前缀+时间戳+第二种情况
 * @author: zhuangjiewei
 * @create: 2019/05/13 17:51
 */
public interface AutoCodeStrategy {

    String getNextCode(AutoCodeAttribute autoCodeAttribute);
}
