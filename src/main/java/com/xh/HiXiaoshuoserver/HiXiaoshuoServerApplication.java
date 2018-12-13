package com.xh.HiXiaoshuoserver;

import com.github.pagehelper.PageHelper;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import java.util.Properties;

@SpringBootApplication
@MapperScan("com.xh.HiXiaoshuoserver.mapper")
@ComponentScan
@Configuration
public class HiXiaoshuoServerApplication {

	public static void main(String[] args) {
		SpringApplication.run(HiXiaoshuoServerApplication.class, args);
	}

}
