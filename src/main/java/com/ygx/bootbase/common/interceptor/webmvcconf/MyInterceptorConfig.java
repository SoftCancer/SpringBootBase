package com.ygx.bootbase.common.interceptor.webmvcconf;

import com.ygx.bootbase.common.interceptor.MyInterceptor;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * 拦截器处理资源的两种实现方式：
 *      1.实现WebMvcConfigurationSupport 类，需要放开静态资源
 *      2.实现WebMvcConfigurer 接口，不需要放开静态资源
 * @Description: 实现 WebMvcConfigure 接口的方式可以用在非前后端分离的项目中，
 * @author: YaoGuangXun
 * @date: 2021/3/20 17:24
 * @Version: 1.0
 */
//@Configuration
public class MyInterceptorConfig implements WebMvcConfigurer {
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(new MyInterceptor()).addPathPatterns("/**");
    }
}
