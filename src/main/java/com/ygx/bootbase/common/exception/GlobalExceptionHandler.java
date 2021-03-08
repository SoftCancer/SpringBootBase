package com.ygx.bootbase.common.exception;

import com.ygx.bootbase.common.result.CodeEnum;
import com.ygx.bootbase.common.result.ResultMsg;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.MissingServletRequestParameterException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * @Description: 全局异常处理类
 * 在方法上通过 @ExceptionHandler 注解来指定具体的异常，
 * 然后在方法中处理该异常信息，最后将结果通过统一的 json 结构体返回给调用者。
 * @author: YaoGuangXun
 * @date: 2021/1/27 23:59
 * @Version: 1.0
 */
@ControllerAdvice
@ResponseBody
public class GlobalExceptionHandler {
    private static final Logger logger = LoggerFactory.getLogger(GlobalExceptionHandler.class);

    /**
     * 统一处理处理参数缺失异常
     * @Description:
     * @Author: YaoGX
     * @Date: 2021/1/28 0:13
     **/
    @ExceptionHandler(MissingServletRequestParameterException.class)
    @ResponseStatus(value = HttpStatus.BAD_REQUEST)
    public ResultMsg handelParameterMissingException(MissingServletRequestParameterException ex){
        logger.error("缺少请求参数：{}",ex.getMessage());
        return ResultMsg.fail(CodeEnum.PARAMETER_MISSING.getCode(),CodeEnum.PARAMETER_MISSING.getMsg());
    }

    /**
     * 空指针异常
     * @Description:
     * @Author: YaoGX
     * @Date: 2021/3/8 22:43
     **/
    @ExceptionHandler(NullPointerException.class)
    @ResponseStatus(value = HttpStatus.INTERNAL_SERVER_ERROR)
    public ResultMsg handleTypeMismachException(NullPointerException ex){
        logger.error("空指针异常：{}",ex);
        return ResultMsg.fail(CodeEnum.NULL_POINTER_EXCEPTION.getCode(),CodeEnum.NULL_POINTER_EXCEPTION.getMsg());
    }

    /**
     * 定义全局异常
     * @Description:
     * @Author: YaoGX
     * @Date: 2021/3/8 22:53
     **/
    @ExceptionHandler(Exception.class)
    @ResponseStatus(value = HttpStatus.INTERNAL_SERVER_ERROR)
    public ResultMsg handleUnexceptionServer(Exception ex){
        logger.error("系统异常：{}",ex);
        return ResultMsg.fail(CodeEnum.SIGN_ERROR.getCode(),CodeEnum.SIGN_ERROR.getMsg());
    }
}
