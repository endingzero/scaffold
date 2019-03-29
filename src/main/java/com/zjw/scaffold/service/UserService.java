package com.zjw.scaffold.service;

import com.zjw.scaffold.core.service.BaseService;
import com.zjw.scaffold.entity.User;

/**
 * @program scaffold
 * @description: 用户接口
 * @author: zhuangjiewei
 * @create: 2019/03/28 16:06
 */
public interface UserService extends BaseService<User> {
    
    void addUser(User user);
}
