package com.ygx.bootbase.controller;

import com.ygx.bootbase.common.interceptor.UnInterception;
import com.ygx.bootbase.entity.User;
import com.ygx.bootbase.service.UserService;
import jdk.nashorn.internal.objects.annotations.Getter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.ServletContext;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;

@RestController
@RequestMapping("/listener")
public class TestController {

    @Autowired
    private UserService userService;


    @GetMapping("/user")
    public User getUser(HttpServletRequest request) {
        ServletContext application = request.getServletContext();
        return (User) application.getAttribute("user");
    }

    /**
     * 获取当前在线人数，该方法有 bug
     *
     * @param request * @return
     */
    @GetMapping("/total")
    public String getTotalUser(HttpServletRequest request) {
        Integer count = (Integer) request.getSession().getServletContext().getAttribute("count");
        return "当前在线人数：" + count;
    }

    /**
     * 获取当前在线人数，该方法有 bug
     *
     * @param request * @return
     */
    @GetMapping("/total2")
    public String getTotalUser2(HttpServletRequest request, HttpServletResponse response) {
        try {
            // 为什么 Cookie 配置 JSESSIONID 才起作用
            Cookie cookie = new Cookie("JSESSIONID", URLEncoder.encode(request.getSession().getId(), "UTF-8"));

            cookie.setPath("/");
            cookie.setMaxAge(48 * 60 * 60);
            response.addCookie(cookie);

        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        Integer count = (Integer) request.getSession().getServletContext().getAttribute("count");
        return "当前在线人数：" + count;
    }

    /**
     * @Description:
     * @Author: YaoGX
     * @Date: 2021/3/17 23:10
     **/
    @GetMapping("/destruction")
    public String invalidate(HttpServletRequest request, HttpServletResponse response) {
        try {
            // 为什么 Cookie 配置 JSESSIONID 才起作用
            Cookie cookie = new Cookie("JSESSIONID", URLEncoder.encode(request.getSession().getId(), "UTF-8"));

            cookie.setPath("/");
            cookie.setMaxAge(48 * 60 * 60);
            response.addCookie(cookie);

        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        request.getSession().invalidate();
        System.out.println(request.getAttribute("count"));
//        Integer count = (Integer) request.getSession().getServletContext().getAttribute("count");
        return "已销毁Session对象！";
    }


    /**
     * @Description:
     * @Author: YaoGX
     * @Date: 2021/3/17 23:17
     **/
    @GetMapping("/request")
    public String getRequestInfo(HttpServletRequest
                                         request) {
        System.out.println("requestListener 中的初始化的 name 数据：" +
                request.getAttribute("name"));
        return "success";
    }

    @UnInterception
    @GetMapping("/publish")
    public User publishEvent() {
        User user = userService.getUser_2();
        System.out.println("自定义事件监听,数据：" + user.getUserName());
        return user;
    }

}