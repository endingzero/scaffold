package com.zjw.scaffold.handler;

import com.zjw.scaffold.converter.DataConverter;
import com.zjw.scaffold.writer.DataWriter;
import org.apache.ibatis.session.ResultContext;
import org.apache.ibatis.session.ResultHandler;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.function.Supplier;

/**
 * @program scaffold
 * @description: 导出结果实现类
 * @author: zhuangjiewei
 * @create: 2019/04/19 16:46
 */
public class ExportResultHandler<T,R> implements ResultHandler<T>, Supplier<R> {

    private DataConverter<T> converter;
    private DataWriter<R> writer;
    private int cacheSize = 500;
    protected List<T> dataCache;

    public ExportResultHandler(DataConverter<T> converter, DataWriter<R> writer) {
        if(Objects.isNull(converter)) {
            throw new NullPointerException("converter不能为空!");
        }
        if(Objects.isNull(writer)) {
            throw new NullPointerException("writer不能为空!");
        }

        this.converter = converter;
        this.writer = writer;
        this.init();
    }

    private void init() {
        this.writer.setTitle(this.converter.getTitle());
        this.writer.setHeader(this.converter.getHeader());
        this.dataCache = new ArrayList<>(this.cacheSize);
    }

    @Override
    public R get() {
        this.handle();
        return this.writer.get();
    }

    @Override
    public void handleResult(ResultContext<? extends T> resultContext) {

        this.dataCache.add(resultContext.getResultObject());
        if(this.dataCache.size() >= cacheSize) {
            this.handle();
        }
    }

    private void handle() {
        if(!this.dataCache.isEmpty()) {
            this.dataCache.forEach(v -> this.writer.accept(this.converter.apply(v)));
            this.dataCache.clear();
        }
    }
}
