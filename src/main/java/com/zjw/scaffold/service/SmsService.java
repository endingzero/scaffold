package com.zjw.scaffold.service;

import com.zjw.scaffold.core.service.BaseService;
import com.zjw.scaffold.entity.User;
import com.zjw.scaffold.event.AddUserEvent;
import org.springframework.transaction.event.TransactionalEventListener;

/**
 * Created by muchen on 2019-03-29.
 */
public interface SmsService extends BaseService<User> {

    @TransactionalEventListener(classes = {AddUserEvent.class})
    void sendMsg(AddUserEvent addUserEvent);
}
