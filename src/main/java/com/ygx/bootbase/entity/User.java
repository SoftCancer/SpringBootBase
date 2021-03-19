package com.ygx.bootbase.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @Description:
 * @author: YaoGuangXun
 * @date: 2021/3/14 22:38
 * @Version: 1.0
 */
@Data
@NoArgsConstructor                 //无参构造
@AllArgsConstructor                //有参构造
public class User {

    private String userId;

    private String userName;

    private String passWord;


}
