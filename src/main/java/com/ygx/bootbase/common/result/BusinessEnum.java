package com.ygx.bootbase.common.result;


import lombok.Getter;

/**
 * 业务异常提示信息枚举类
 *
 * @author shengwu ni
 */
@Getter
public enum BusinessEnum {
    /**
     * 参数异常
     */
    PARMETER_EXCEPTION("101", "参数异常!"),
    /**
     * 等待超时
     */
    SERVICE_TIME_OUT("103", "服务调用超时！"),
    /**
     * 参数过大
     */
    PARMETER_BIG_EXCEPTION("102", "输入的图片数量不能超过 50 张!"),
    /**
     * 500 : 一劳永逸的提示也可以在这定义
     */
    UNEXPECTED_EXCEPTION("500", "系统发生异常，请联系管理员！");
// 还可以定义更多的业务异常
    /**
     * 消息码
     */
    private String code;
    /**
     * 消息内容
     */
    private String msg;

    private BusinessEnum(String code, String msg) {
        this.code = code;
        this.msg = msg;
    }

}