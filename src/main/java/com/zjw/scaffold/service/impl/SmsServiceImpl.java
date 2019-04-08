package com.zjw.scaffold.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.zjw.scaffold.entity.User;
import com.zjw.scaffold.event.AddUserEvent;
import com.zjw.scaffold.mapper.UserMapper;
import com.zjw.scaffold.service.SmsService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

/**
 * @program scaffold
 * @description: 短信实现类
 * @author: zhuangjiewei
 * @create: 2019/03/29 16:29
 */
@Service
@Slf4j
public class SmsServiceImpl extends ServiceImpl<UserMapper, User> implements SmsService {


    @Override
    @Async
    @Transactional(propagation = Propagation.REQUIRES_NEW)
    public void sendMsg(AddUserEvent addUserEvent) {
        System.out.println(addUserEvent.getUser().getId());
        User user = new User();
        user.setName("yaya");
        this.baseMapper.insert(user);
        String s = null;

        s.toString();
    }
}
