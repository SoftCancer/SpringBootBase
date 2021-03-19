package com.ygx.bootbase.common.configure;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * @Description: 获取自定义配置信息
 * @author: YaoGuangXun
 * @date: 2021/1/6 22:00
 * @Version: 1.0
 */
@Data
@Component
@ConfigurationProperties(prefix = "url")
public class ConfigurationServiceUrl {

    private String orderUrl;
    private String userUrl;
    private String carUrl;
}
