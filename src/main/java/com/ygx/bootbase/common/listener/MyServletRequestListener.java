package com.ygx.bootbase.common.listener;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import javax.servlet.ServletRequestEvent;
import javax.servlet.ServletRequestListener;
import javax.servlet.http.HttpServletRequest;

/**
 * @Description:
 * @author: YaoGuangXun
 * @date: 2021/3/17 21:57
 * @Version: 1.0
 */
@Component
public class MyServletRequestListener implements ServletRequestListener {
    private static final Logger logger =
            LoggerFactory.getLogger(MyServletRequestListener.class);


    @Override
    public void requestInitialized(ServletRequestEvent sre) {
        HttpServletRequest request = (HttpServletRequest) sre.getServletRequest();
        logger.info("Session id 是：{}", request.getRequestedSessionId());

        logger.info("request url:{}", request.getRequestURL());

        request.setAttribute("name", "姚明");
    }

    @Override
    public void requestDestroyed(ServletRequestEvent sre) {
        logger.info("request end");
        HttpServletRequest request = (HttpServletRequest) sre.getServletRequest();
        logger.info("request 域中保存的 name 值为：{}", request.getAttribute("name"));
    }

}
