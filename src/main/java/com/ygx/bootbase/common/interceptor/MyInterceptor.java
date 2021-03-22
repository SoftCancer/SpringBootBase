package com.ygx.bootbase.common.interceptor;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.resource.ResourceHttpRequestHandler;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.lang.reflect.Method;

/**
 * @Description: 定义拦截器
 *
 * @author: YaoGuangXun
 * @date: 2021/3/20 16:11
 * @Version: 1.0
 */
public class MyInterceptor implements HandlerInterceptor {

    private static final Logger logger = LoggerFactory.getLogger(MyInterceptor.class);

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {


        if (handler instanceof HandlerMethod){
            HandlerMethod handlerMethod = (HandlerMethod) handler;
            Method method = handlerMethod.getMethod();
            // 获取 自定义注解，判断是否被拦截
            UnInterception unInterception = method.getAnnotation(UnInterception.class);
            if (null != unInterception){
                return true;
            }

            String methodName = method.getName();
            logger.info("拦截到的方法名：{},拦截器在该方法之前执行...",methodName);

        }else if (handler instanceof ResourceHttpRequestHandler){
            return true;
        }

        // 返回 true 才会继续执行，返回 false 则取消当前请求
        return true;
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
        logger.info("执行完方法之后进执行，但是此时还没进行视图渲染");
    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
        logger.info("整个请求都处理完咯，DispatcherServlet 也渲染了对应的 视图咯，此时我可以做一些清理的工作了");
    }



}
