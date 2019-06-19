package com.zjw.scaffold.converter;


import com.zjw.scaffold.dto.UserExportResponse;

import java.util.ArrayList;
import java.util.List;

/**
 * @program scaffold
 * @description:
 * @author: zhuangjiewei
 * @create: 2019/04/20 11:02
 */
public class UserDataConverter implements DataConverter<UserExportResponse> {

    @Override
    public String getTitle() {
        return "用户数据导出表";
    }

    @Override
    public List<String> getHeader() {
        List<String> headerList = new ArrayList<>();
        headerList.add("id");
        headerList.add("账号");
        headerList.add("姓名");
        return headerList;
    }

    @Override
    public List<String> apply(UserExportResponse data) {

        List<String> result = new ArrayList<>();
        result.add(String.valueOf(data.getId()));
        result.add(data.getUsername());
        result.add(data.getName());
        return result;
    }
}
