package com.zjw.scaffold.core.excel.handler;

import org.apache.ibatis.session.ResultContext;
import org.apache.ibatis.session.ResultHandler;

import java.util.function.Supplier;

/**
 * @program scaffold
 * @description: 导出结果实现类
 * @author: zhuangjiewei
 * @create: 2019/04/19 16:46
 */
public class ExportResultHandler<T,R> implements ResultHandler<T>, Supplier<R> {

    @Override
    public R get() {
        return null;
    }

    @Override
    public void handleResult(ResultContext<? extends T> resultContext) {

    }
}
