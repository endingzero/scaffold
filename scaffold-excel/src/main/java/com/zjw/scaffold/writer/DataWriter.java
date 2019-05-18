package com.zjw.scaffold.writer;

import java.util.function.Consumer;
import java.util.function.Supplier;

/**
 * @program scaffold
 * @description: 数据写入接口,将数据消耗掉并输出
 * @author: zhuangjiewei
 * @create: 2019/03/28 21:43
 */
public interface DataWriter<R> extends Consumer<String[]>, Supplier<R> {

    void setTitle(String title);

    void setHeader(String[] header);

}
