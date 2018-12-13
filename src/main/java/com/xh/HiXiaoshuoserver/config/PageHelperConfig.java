package com.xh.HiXiaoshuoserver.config;


import com.github.pagehelper.PageHelper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.Properties;

/**
 * @program: HiXiaoshuo-server
 * @description: 分页插件配置
 * @author: XuHao
 * @create: 2018-12-13 11:27
 **/
@Configuration
public class PageHelperConfig {

    @Bean
    public PageHelper pageHelper() {
        PageHelper pageHelper = new PageHelper();
        Properties properties = new Properties();
        properties.setProperty("offsetAsPageNum", "true");
        properties.setProperty("rowBoundsWithCount", "true");
        properties.setProperty("reasonable", "true");
        properties.setProperty("dialect", "mysql");

        pageHelper.setProperties(properties);

        return pageHelper;
    }
}