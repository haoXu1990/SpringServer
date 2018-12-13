package com.xh.HiXiaoshuoserver.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;



/**
 * @program: HiXiaoshuo-server
 * @description:
 * @author: XuHao
 * @create: 2018-12-12 10:29
 **/

@Data
@Configuration
@ConfigurationProperties(prefix = "cors")
public class CorsConfig {

    // 允许的域
    private String allowedOrigins;

    // 允许的方法
    private String allowedMethods;

    // 允许的头信息
    private String allowedHeaders;

}
