package com.ygx.bootbase.controller;

import com.ygx.bootbase.common.result.ResultMsg;
import lombok.extern.log4j.Log4j2;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

/**
 * @Description:
 * @author: YaoGuangXun
 * @date: 2021/1/1 15:20
 * @Version: 1.0
 */
@Log4j2
@RestController
@RequestMapping("login")
public class LoginController {

    @RequestMapping("/spring")
    public ResultMsg login(){
        log.info("测试日志输出");
        Map<String,Object> map  = new HashMap<>();
        map.put("name","姚明");
        return ResultMsg.success(map);
    }
}
