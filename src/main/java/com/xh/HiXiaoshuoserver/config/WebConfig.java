package com.xh.HiXiaoshuoserver.config;


import com.alibaba.fastjson.support.config.FastJsonConfig;
import com.alibaba.fastjson.support.spring.FastJsonHttpMessageConverter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import java.util.List;

import static com.alibaba.fastjson.serializer.SerializerFeature.*;
import static com.alibaba.fastjson.serializer.SerializerFeature.DisableCircularReferenceDetect;
import static com.alibaba.fastjson.serializer.SerializerFeature.WriteNullStringAsEmpty;

/**
 * @program: HiXiaoshuo-server
 * @description:
 * @author: XuHao
 * @create: 2018-07-23 15:43
 **/
@Configuration
public class WebConfig implements WebMvcConfigurer {
//
//    @Autowired
//    private CORSInterceptor corsInterceptor;

    @Override
    public void configureMessageConverters(List<HttpMessageConverter<?>> converters) {


        FastJsonHttpMessageConverter converter = new FastJsonHttpMessageConverter();

        FastJsonConfig config = new FastJsonConfig();
        config.setSerializerFeatures(
                QuoteFieldNames,
                WriteMapNullValue,// 是否输出值为null的字段
                WriteNullNumberAsZero,//数值字段如果为null,输出为0,而非null
                WriteNullListAsEmpty,//List字段如果为null,输出为[],而非null
                WriteNullStringAsEmpty,//字符类型字段如果为null,输出为"",而非null
                //WriteNullBooleanAsFalse,//Boolean字段如果为null,输出为false,而非null
                //WriteNullStringAsEmpty,// null String不输出
                //WriteMapNullValue,//null String也要输出
                //WriteDateUseDateFormat,//Date的日期转换器
                DisableCircularReferenceDetect,//禁止循环引用
                PrettyFormat
        );
        converter.setFastJsonConfig(config);
        converters.add(converter);

    }


    @Override
    public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("/**") // 配置可以被跨域的路径
                .allowedMethods("*") // 允许跨域的请求方法
                .allowedOrigins("http://localhost:8080", "http://www.book2345.top:1990") // 允许所有域名访问跨域资源
                .allowedHeaders("*"); // 允许所有的请求Header访问
    }

//    @Override
//    public void addInterceptors(InterceptorRegistry registry) {
//            registry.addInterceptor(corsInterceptor);
//    }
}