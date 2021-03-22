package com.ygx.bootbase.controller;

import com.ygx.bootbase.entity.User;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

/**
 * @Description:
 * @author: YaoGuangXun
 * @date: 2021/3/21 21:10
 * @Version: 1.0
 */
@RestController
@RequestMapping(value = "/user")
public class UaerController {

    @PostMapping("/login")
    public String login(User user, HttpServletRequest request) {
        // 根据用户名和密码创建 token
        UsernamePasswordToken token = new UsernamePasswordToken(user.getUserName(), user.getPassWord());
        // 获取 subject 认证主体
        Subject subject = SecurityUtils.getSubject();
        try {
            // 开始认证，这一步会跳到我们自定义的 realm 中
            subject.login(token);
            request.getSession().setAttribute("user", user);
            return "成功！";
        } catch (Exception e) {
                e.printStackTrace();
                request.getSession().setAttribute("user", user);
                request.setAttribute("error", "用户名或密码错误！");
                return "login";
            }
        }

    }
