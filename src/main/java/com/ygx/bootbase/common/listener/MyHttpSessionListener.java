package com.ygx.bootbase.common.listener;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

/**
 * @Description: 使用 HttpSessionListener 监听器 统计在线用户数
 * @author: YaoGuangXun
 * @date: 2021/3/16 23:15
 * @Version: 1.0
 */
@Component
public class MyHttpSessionListener implements HttpSessionListener {
    private static final Logger logger =
            LoggerFactory.getLogger(MyHttpSessionListener.class);

    public Integer count = 0;

    @Override
    public synchronized void sessionCreated(HttpSessionEvent se) {
        logger.info("新用户上线了！");
        count++;
        se.getSession().getServletContext().setAttribute("count",count);
    }

    @Override
    public synchronized void sessionDestroyed(HttpSessionEvent se) {
        logger.info("新用户下线了！");
        count--;
        logger.info("当前用户数：{}",count);
        se.getSession().getServletContext().setAttribute("count",count);
    }
}
