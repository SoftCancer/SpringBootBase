package com.ygx.bootbase.dao;

import com.ygx.bootbase.entity.User;

import java.util.HashSet;
import java.util.Set;

/**
 * @Description:
 * @author: YaoGuangXun
 * @date: 2021/3/21 22:12
 * @Version: 1.0
 */
public interface UserDao {

    public User getUserByName(String userName);

    public Set<String> getRoleByName(String userName);

    public Set<String> getPermissionsByName(String userName);
}
