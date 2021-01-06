package com.ygx.bootbase.controller;

import com.ygx.bootbase.common.configure.ConfigurationServiceUrl;
import com.ygx.bootbase.common.result.ResultMsg;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.Map;

/**
 * @Description:
 * @author: YaoGuangXun
 * @date: 2021/1/1 15:20
 * @Version: 1.0
 */
@Slf4j
@RestController
@RequestMapping("login")
public class LoginController {

    private static final Logger logger = LoggerFactory.getLogger(LoginController.class);

    @RequestMapping("/spring")
    public ResultMsg login(){
        logger.info("测试日志输出");
        Map<String,Object> map  = new HashMap<>();
        map.put("name","姚明");
        log.info("Slf4j");
        return ResultMsg.success(map);
    }

    @Resource
    private ConfigurationServiceUrl microServiceUrl;
    @RequestMapping("/config")
    public String testConfig() {
        logger.info("=====获取的订单服务地址为：{}",
                microServiceUrl.getOrderUrl());
        logger.info("=====获取的用户服务地址为：{}",
                microServiceUrl.getUserUrl());
        logger.info("=====获取的购物车服务地址为：{}",
                microServiceUrl.getCarUrl());
        return "success";
    }
}
