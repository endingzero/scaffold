package com.zjw.scaffold.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.zjw.scaffold.entity.User;
import com.zjw.scaffold.mapper.UserMapper;
import com.zjw.scaffold.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @program scaffold
 * @description: 用户接口实现类
 * @author: zhuangjiewei
 * @create: 2019/03/28 16:08
 */
@Service
@Slf4j
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements UserService {
}
