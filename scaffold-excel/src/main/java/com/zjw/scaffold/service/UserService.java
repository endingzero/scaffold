package com.zjw.scaffold.service;

import com.zjw.scaffold.entity.User;
import org.springframework.core.io.FileSystemResource;
import org.springframework.http.ResponseEntity;

/**
 * @program scaffold
 * @description: 用户接口
 * @author: zhuangjiewei
 * @create: 2019/03/28 16:06
 */
public interface UserService extends BaseService<User> {
    
    void addUser(User user);

    ResponseEntity<FileSystemResource> exportAllUser();
}
