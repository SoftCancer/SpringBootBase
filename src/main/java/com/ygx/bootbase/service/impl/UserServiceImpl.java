package com.ygx.bootbase.service.impl;

import com.ygx.bootbase.common.listener.event.MyEvent;
import com.ygx.bootbase.dao.UserDao;
import com.ygx.bootbase.entity.User;
import com.ygx.bootbase.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.HashSet;
import java.util.Set;

/**
 * @Description:
 * @author: YaoGuangXun
 * @date: 2021/3/14 22:36
 * @Version: 1.0
 */
@Service
public class UserServiceImpl implements IUserService {

    @Resource
    private ApplicationContext applicationContext;


    public User getUser_2() {
        User user = new User(2, "贾静雯", "46",4);
        // 发布事件
        MyEvent myEvent = new MyEvent(this, user);
        applicationContext.publishEvent(myEvent);
        return user;
    }

    @Autowired
    private UserDao userDao;

    @Override
    public User getUserByName(String userName) {
        return userDao.getUserByName(userName);
    }

    @Override
    public Set<String> getRoleByName(String userName) {
        Set<String> roles = new HashSet<>();
        return roles;
    }

    @Override
    public Set<String> getPermissionsByName(String userName) {
        Set<String> Permissions = new HashSet<>();
        return Permissions;
    }

}
