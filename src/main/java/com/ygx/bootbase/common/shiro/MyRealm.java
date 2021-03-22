package com.ygx.bootbase.common.shiro;

import com.ygx.bootbase.entity.User;
import com.ygx.bootbase.service.IUserService;
import com.ygx.bootbase.service.impl.UserServiceImpl;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.springframework.beans.factory.annotation.Autowired;


/**
 * @Description:
 * @author: YaoGuangXun
 * @date: 2021/3/20 23:21
 * @Version: 1.0
 */
public class MyRealm extends AuthorizingRealm {

    @Autowired
    private IUserService userService;


    /**
     * 用来为当前登陆成功的用户 授予权限和角色
     *
     * @Author: YaoGX
     * @Date: 2021/3/20 23:30
     **/
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {
        // 获取用户名
        String userName = (String) principalCollection.getPrimaryPrincipal();

        SimpleAuthorizationInfo authorizationInfo = new SimpleAuthorizationInfo();

        authorizationInfo.setRoles(userService.getRoleByName(userName));

        authorizationInfo.setStringPermissions(userService.getPermissionsByName(userName));
        return authorizationInfo;
    }

    /**
     * 用来验证当前登录的用户，获取认证信息
     *
     * @Author: YaoGX
     * @Date: 2021/3/20 23:29
     **/
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authenticationToken) throws AuthenticationException {
        // 根据 token 获取用户名，如果您不知道该该 token 怎么来的，先可以不管，下文会解释
        String username = (String) authenticationToken.getPrincipal();
        // 根据用户名从数据库中查询该用户
        User user = userService.getUserByName(username);
        if (user != null) {
            // 把当前用户存到 session 中
            SecurityUtils.getSubject().getSession().setAttribute("user", user);
            // 传入用户名和密码进行身份认证，并返回认证信息
            AuthenticationInfo authcInfo = new
                    SimpleAuthenticationInfo(user.getUserName(), user.getPassWord(),
                    "myRealm");
            return authcInfo;
        } else {
            return null;
        }
    }

}
