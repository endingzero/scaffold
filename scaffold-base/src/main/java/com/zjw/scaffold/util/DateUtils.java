package com.zjw.scaffold.util;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

/**
 * @program scaffold
 * @description: 时间工具
 * @author: zhuangjiewei
 * @create: 2019/05/14 14:56
 */
public class DateUtils {

    //获取指定时间的指定格式
    public static String formatShortCurrent() {
        return LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyyMMddHHmmss"));
    }
}
