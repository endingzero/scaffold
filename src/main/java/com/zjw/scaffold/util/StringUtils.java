package com.zjw.scaffold.util;

import java.util.Objects;

/**
 * @program scaffold
 * @description: 自写工具类
 * @author: zhuangjiewei
 * @create: 2019/03/28 17:37
 */
public class StringUtils {

    public static boolean isNumeric(CharSequence cs) {
        if (Objects.isNull(cs)) {
            return false;
        } else {
            int sz = cs.length();

            for(int i = 0; i < sz; ++i) {
                if (!Character.isDigit(cs.charAt(i))) {
                    return false;
                }
            }
            return true;
        }
    }
}
