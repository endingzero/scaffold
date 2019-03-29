package com.zjw.scaffold.event;

import com.zjw.scaffold.entity.User;
import com.zjw.scaffold.service.impl.UserServiceImpl;
import lombok.Getter;
import org.springframework.context.ApplicationEvent;

/**
 * @program scaffold
 * @description:
 * @author: zhuangjiewei
 * @create: 2019/03/29 16:22
 */
@Getter
public class AddUserEvent extends ApplicationEvent {

    private User user;
    public AddUserEvent(Object source, User user) {
        super(source);
        this.user = user;
    }
}
