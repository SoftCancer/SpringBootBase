package com.ygx.bootbase.common.interceptor.webmvcsupport;

import com.ygx.bootbase.common.interceptor.MyInterceptor;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurationSupport;

/**
 * @Description: 配置拦截器,
 * 继承 WebMvcConfigurationSupport 类的方式可以用在前后端分离的
 * 项目中，后台不需要访问静态资源（就不需要放开静态资源了）
 * @author: YaoGuangXun
 * @date: 2021/3/20 16:49
 * @Version: 1.0
 */
@Configuration
public class MyInterceptorConfig extends WebMvcConfigurationSupport {

    /**
     *  重写addInterceptors 方法，将我们上面自定义的拦截器添加进去，
     * addPathPatterns 方法是添加要拦截的请求，这里我们拦截所有的请求。
     * @Author: YaoGX
     * @Date: 2021/3/20 16:52
     **/
    @Override
    protected void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(new MyInterceptor()).addPathPatterns("/**");
        super.addInterceptors(registry);
    }

    /**
     * 当项目非前后端分离时，解决静态资源被拦截问题。
     * 用来指定静态资源不被拦截，否则继承 WebMvcConfigurationSupport 这种方式
     * 会导致静态资源无法直接访问
     * @Author: YaoGX
     * @Date: 2021/3/20 16:53
     **/
    @Override
    protected void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("/**").addResourceLocations("classpath:/static");
        super.addResourceHandlers(registry);
    }
}
