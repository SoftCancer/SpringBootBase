package com.ygx.bootbase.service;

import com.ygx.bootbase.common.listener.event.MyEvent;
import com.ygx.bootbase.entity.User;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @Description:
 * @author: YaoGuangXun
 * @date: 2021/3/14 22:36
 * @Version: 1.0
 */
@Service
public class UserService {

    @Resource
    private ApplicationContext applicationContext;

    public User getUser() {
        return new User("1", "yaogx", "123456");
    }

    public User getUser_2() {
        User user = new User("2", "贾静雯", "46");

        // 发布事件
        MyEvent myEvent = new MyEvent(this,user);
        applicationContext.publishEvent(myEvent);
        return user;
    }

}
