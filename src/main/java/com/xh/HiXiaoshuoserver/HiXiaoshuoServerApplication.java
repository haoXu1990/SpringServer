package com.xh.HiXiaoshuoserver;

import com.github.pagehelper.PageHelper;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.Properties;

@SpringBootApplication
@MapperScan("com.xh.HiXiaoshuoserver.mapper")
public class HiXiaoshuoServerApplication {

	public static void main(String[] args) {
		SpringApplication.run(HiXiaoshuoServerApplication.class, args);
	}


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
