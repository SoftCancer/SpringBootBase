package com.ygx.bootbase.controller;


import com.ygx.bootbase.common.exception.BusinessException;
import com.ygx.bootbase.common.result.BusinessEnum;

import com.ygx.bootbase.common.configure.ConfigurationServiceUrl;

import com.ygx.bootbase.common.result.ResultMsg;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
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
@Api(value = "登录接口")
public class LoginController {

    private static final Logger logger = LoggerFactory.getLogger(LoginController.class);


    @ApiOperation(value = "日志测试接口", notes = "请求路径：login/spring")
    @RequestMapping(value = "/spring",method = RequestMethod.GET)
    public ResultMsg login() {
        logger.info("测试日志输出");
        Map<String, Object> map = new HashMap<>();
        map.put("name", "姚明");
        log.info("Slf4j");
        return ResultMsg.success(map);
    }


    @RequestMapping("/test")
    public ResultMsg exce() {
        logger.info("测试日志输出");
        try {
            int i = 1 / 0;
        } catch (Exception e) {
            throw new BusinessException(BusinessEnum.UNEXPECTED_EXCEPTION);
        }
        return ResultMsg.fail();
}
    @Resource
    private ConfigurationServiceUrl microServiceUrl;

    @RequestMapping(value = "/config",method = RequestMethod.POST)
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
