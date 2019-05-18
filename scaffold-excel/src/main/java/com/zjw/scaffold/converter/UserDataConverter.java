package com.zjw.scaffold.converter;


import com.zjw.scaffold.dto.UserExportResponse;

/**
 * @program scaffold
 * @description:
 * @author: zhuangjiewei
 * @create: 2019/04/20 11:02
 */
public class UserDataConverter implements DataConverter<UserExportResponse> {

    @Override
    public String getTitle() {
        return null;
    }

    @Override
    public String[] getHeader() {
        return new String[0];
    }

    @Override
    public String[] apply(UserExportResponse data) {
        return null;
    }
}
