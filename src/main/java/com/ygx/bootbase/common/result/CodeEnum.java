package com.ygx.bootbase.common.result;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.Objects;

/**
 * @Description: 定义统一的消息提示编码
 * @Author: YaoGX
 * @Date: 2021/1/2 16:35
 **/
@Getter
@AllArgsConstructor(access = AccessLevel.PRIVATE)
public enum CodeEnum {
    
    OK("200", "成功"),
    FAIL("250", "失败"),
    VALUE_NULL("300", "值为空"),
    PARAM_NULL("301", "参数为空，处理异常"),
    PARAMETER_MISSING("400", "缺少必要的请求参数"),
    NULL_POINTER_EXCEPTION("401", "空指针异常！"),
    SIGN_ERROR("700", "签名错误"),
    NO_LOGIN("701", "未登录"),

    SYS_ERROR("500", "系统异常,联系管理员！");

    private String code;
    private String msg;

    // 根据code返回msg信息
    public String getMsgByCode(String code) {
        for (CodeEnum entry : CodeEnum.values()) {
            if (Objects.equals(entry.getCode(), code)) {
                return entry.getMsg();
            }
        }

        return "";
    }

}
