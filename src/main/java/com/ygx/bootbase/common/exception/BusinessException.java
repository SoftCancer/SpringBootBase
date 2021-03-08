package com.ygx.bootbase.common.exception;

import lombok.Data;

/**
 * @Description:
 * @author: YaoGuangXun
 * @date: 2021/3/8 23:44
 * @Version: 1.0
 */
@Data
public class BusinessException extends RuntimeException{

    // 异常状态码
    private String code;

    // 异常信息
    private String msg;

    public BusinessException(String code, String msg) {
        this.code = code;
        this.msg = msg;
    }
}
