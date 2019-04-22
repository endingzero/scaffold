package com.zjw.scaffold.core.excel.writer;

import java.util.List;
import java.util.function.Consumer;
import java.util.function.Supplier;

/**
 * @program scaffold
 * @description: 数据写入接口,将数据消耗掉并输出
 * @author: zhuangjiewei
 * @create: 2019/03/28 21:43
 */
public interface DataWriter<R> extends Consumer<List<String>>, Supplier<R> {

    void setTitle(String title);

    void setHeader(List<String> header);

}
