package com.ygx.bootbase.common.interceptor;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * @Description:  该注解用来指定某个方法不用拦截
 * @Author: YaoGX
 * @Date: 2021/3/20 17:35
 **/
@Target(ElementType.METHOD) // 　作用：用于描述注解的使用范围
@Retention(RetentionPolicy.RUNTIME)
public @interface UnInterception {
}
