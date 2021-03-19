package com.ygx.bootbase.common.exception;

import com.ygx.bootbase.common.result.BusinessEnum;
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

    public BusinessException(BusinessEnum businessEnum) {
        this.code = businessEnum.getCode();
        this.msg = businessEnum.getMsg();
    }
}
