package com.ygx.bootbase.common.result;

import com.alibaba.fastjson.JSON;
import org.springframework.core.MethodParameter;
import org.springframework.http.MediaType;
import org.springframework.http.server.ServerHttpRequest;
import org.springframework.http.server.ServerHttpResponse;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.servlet.mvc.method.annotation.ResponseBodyAdvice;

/**
 * @Description: 对返回数据 进行统一拦截处理
 * @author: YaoGuangXun
 * @date: 2021/1/2 18:41
 * @Version: 1.0
 */
// 要扫描的包
@ControllerAdvice(basePackages = "com.ygx.bootbase.controller")
public class CommonResponseDataAdvice implements ResponseBodyAdvice {

    /**
     * @Description: 判断是否要执行beforeBodyWrite方法，true为执行，false不执行
     * 通过supports方法，我们可以选择哪些类，或者哪些方法要对response进行处理，其余的则不处理。
     * 可以对 登录控制层 跳过处理
     * @Author: YaoGX
     * @Date: 2021/1/2 18:45
     **/
    @Override
    public boolean supports(MethodParameter methodParameter, Class aClass) {
        return true;
    }

    @Override
    public Object beforeBodyWrite(Object o, MethodParameter methodParameter, MediaType mediaType, Class aClass, ServerHttpRequest serverHttpRequest, ServerHttpResponse serverHttpResponse) {
        // o is null -> return response
        if (o == null)
            return ResultMsg.success();

        // o is instanceof ConmmonResponse -> return o
        if (o instanceof ResultMsg)
            return (ResultMsg) o;

        // string 特殊处理
        if (o instanceof String)
            return JSON.toJSONString(ResultMsg.success(o));

        return ResultMsg.success(o);
    }
}
