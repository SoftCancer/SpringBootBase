package com.ygx.bootbase.common.listener;

import com.ygx.bootbase.entity.User;
import com.ygx.bootbase.service.IUserService;
import com.ygx.bootbase.service.impl.UserServiceImpl;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

import javax.servlet.ServletContext;

/**
 * @Description:
 * @author: YaoGuangXun
 * @date: 2021/3/14 22:42
 * @Version: 1.0
 */
@Component
public class MyServletContextListener implements ApplicationListener<ContextRefreshedEvent> {

    @Override
    public void onApplicationEvent(ContextRefreshedEvent contextRefreshedEvent) {
        // 获取application 上下文
        ApplicationContext applicationContext = contextRefreshedEvent.getApplicationContext();

        // 获取对应的 Service
        UserServiceImpl userServiceImpl = applicationContext.getBean(UserServiceImpl.class);
        User user = userServiceImpl.getUser_2();
// 获取 application 域对象，将查到的信息放到 application 域中
        ServletContext servletContext = applicationContext.getBean(ServletContext.class);
        servletContext.setAttribute("user", user);

    }
}
