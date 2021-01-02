package com.ygx.bootbase.controller;

import com.ygx.bootbase.common.result.ResultMsg;
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
@RestController
@RequestMapping("login")
public class LoginController {

    @RequestMapping("/spring")
    public ResultMsg login(){
        if (1==1){
          return  ResultMsg.fail();
        }
        Map<String,Object> map  = new HashMap<>();
        map.put("name","姚明");
        return ResultMsg.success(map);
    }
}
