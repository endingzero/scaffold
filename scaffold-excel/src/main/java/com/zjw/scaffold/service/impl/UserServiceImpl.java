package com.zjw.scaffold.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.zjw.scaffold.converter.UserDataConverter;
import com.zjw.scaffold.entity.User;
import com.zjw.scaffold.handler.ExcelDownloadResultHandler;
import com.zjw.scaffold.mapper.UserMapper;
import com.zjw.scaffold.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.core.io.FileSystemResource;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * @program scaffold
 * @description: 用户接口实现类
 * @author: zhuangjiewei
 * @create: 2019/03/28 16:08
 */
@Service
@Slf4j
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements UserService {

    @Override
    @Transactional
    public void addUser(User user) {
        this.baseMapper.insert(user);
    }

    @Override
    public ResponseEntity<FileSystemResource> exportAllUser() {


        UserDataConverter userDataConverter = new UserDataConverter();
        ExcelDownloadResultHandler resultHandler = ExcelDownloadResultHandler.create(userDataConverter);

        this.baseMapper.listAllUser(resultHandler);
        return null;
    }
}
