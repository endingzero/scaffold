package com.zjw.scaffold.core.excel.writer;

import org.springframework.core.io.FileSystemResource;
import org.springframework.http.ResponseEntity;

/**
 * @program scaffold
 * @description: excel数据写入
 * @author: zhuangjiewei
 * @create: 2019/03/28 22:49
 */
public class ExcelDataWriter implements DataWriter<ResponseEntity<FileSystemResource>> {

    @Override
    public void setTitle(String title) {

    }

    @Override
    public void setHeader(String[] header) {

    }

    @Override
    public void accept(String[] strings) {

    }

    @Override
    public ResponseEntity<FileSystemResource> get() {
        return null;
    }
}
