package com.zjw.scaffold.converter;

import java.util.List;
import java.util.function.Function;

/**
 * @program scaffold
 * @description: 将数据进行转换
 * @author: zhuangjiewei
 * @create: 2019/03/28 21:43
 */
public interface DataConverter<T> extends Function<T, List<String>> {

    String getTitle();

    List<String> getHeader();
}
