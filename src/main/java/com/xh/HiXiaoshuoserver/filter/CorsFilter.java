package com.xh.HiXiaoshuoserver.filter;


import com.xh.HiXiaoshuoserver.config.CorsConfig;
import org.springframework.beans.factory.annotation.Autowired;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;


/**
 * @program: HiXiaoshuo-server
 * @description:
 * @author: XuHao
 * @create: 2018-12-12 11:12
 **/

@WebFilter(urlPatterns = "/*", filterName = "coreFilter")
public class CorsFilter implements javax.servlet.Filter {

    @Autowired
    private CorsConfig corsConfig;

    @Override
    public void destroy() {

    }

    @Override
    public void doFilter(ServletRequest req, ServletResponse res, FilterChain chain)
            throws IOException, ServletException {
        HttpServletResponse response = (HttpServletResponse) res;
        response.setHeader("Access-Control-Allow-Origin", corsConfig.getAllowedOrigins());
        response.setHeader("Access-Control-Allow-Methods", corsConfig.getAllowedMethods());

        response.setHeader("Access-Control-Allow-Headers", corsConfig.getAllowedHeaders());
        chain.doFilter(req, res);
    }

    @Override
    public void init(FilterConfig arg0) throws ServletException {

    }

}