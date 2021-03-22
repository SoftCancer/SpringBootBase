package com.ygx.bootbase;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@MapperScan("com.ygx.bootbase.dao")
@SpringBootApplication
public class BootbaseApplication {

    public static void main(String[] args) {
        SpringApplication.run(BootbaseApplication.class, args);
    }

}
