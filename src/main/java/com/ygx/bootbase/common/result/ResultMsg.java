package com.ygx.bootbase.common.result;

import lombok.*;

import java.io.Serializable;

/**
 * @Description: 封装统一的返回数据
 * @Author: YaoGX
 * @Date: 2021/1/2 16:21
 **/
@Data
@Builder(toBuilder = true)
public class ResultMsg<T> implements Serializable {

    private static final long serialVersionUID = 8676131899637805509L;

    // 返回编码
    private String code;
    // 返回信息
    private String msg;
    // 签名
    @Builder.Default
    private String sign = "";
    // 返回数据封装
    @Builder.Default
    private T data = (T) "";

    public ResultMsg() {
    }


    public ResultMsg(String code, String msg, T data) {
        this.code = code;
        this.msg = msg;
        this.data = data;
    }

    public ResultMsg(String code, String msg, String sign, T data) {
        this.code = code;
        this.msg = msg;
        this.sign = sign;
        this.data = data;
    }

    /**
     * 数据返回成功
     * @Description:
     * @Author: YaoGX
     * @Date: 2021/1/2 18:03
     **/
    public static ResultMsg success() {
        return success(null);
    }

    public static ResultMsg success(Object data) {
        return success(CodeEnum.OK.getMsg(), data);
    }

    public static ResultMsg success(String msg, Object data) {
        return success(CodeEnum.OK.getCode(), msg, data);
    }

    public static ResultMsg success(String code, String msg, Object data) {
        return new ResultMsg(code, msg, data);
    }

    /**
     * @Description: 数据返回失败
     * @Author: YaoGX
     * @Date: 2021/1/2 18:03
     **/
    public static ResultMsg fail() {
        return fail(null);
    }

    public static ResultMsg fail(Object data) {
        return fail(CodeEnum.FAIL.getMsg(), data);
    }


    public static ResultMsg fail(String msg, Object data) {
        return fail(CodeEnum.FAIL.getCode(), msg, data);
    }

    public static ResultMsg fail(String code, String msg) {
        return fail(code, msg,null);
    }

    public static ResultMsg fail(String code, String msg, Object data) {
        return new ResultMsg(code, msg, data);
    }

}
