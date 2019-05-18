package com.zjw.scaffold.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.zjw.scaffold.entity.User;
import com.zjw.scaffold.handler.ExcelDownloadResultHandler;

/**
 * @program scaffold
 * @description:
 * @author: zhuangjiewei
 * @create: 2019/03/28 16:16
 */
public interface UserMapper extends BaseMapper<User> {

    void listAllUser(ExcelDownloadResultHandler resultHandler);
}
