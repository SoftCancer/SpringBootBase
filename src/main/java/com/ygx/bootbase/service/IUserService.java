package com.ygx.bootbase.service;

import com.ygx.bootbase.entity.User;

import java.util.Set;

/**
 * @Description:
 * @author: YaoGuangXun
 * @date: 2021/3/21 22:13
 * @Version: 1.0
 */
public interface
IUserService {

    public User getUserByName(String userName);

    public Set<String> getRoleByName(String userName);

    public Set<String> getPermissionsByName(String userName);
}
