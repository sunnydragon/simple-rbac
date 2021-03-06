package com.rbac.config;

import com.rbac.interceptor.JwtInterceptor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurationSupport;

@Configuration
public class JwtConfiguration extends WebMvcConfigurationSupport {

    @Autowired
    private JwtInterceptor jwtInterceptor;


    @Override
    protected void addInterceptors(InterceptorRegistry registry) {

        registry.addInterceptor(jwtInterceptor).addPathPatterns("/**")
                .excludePathPatterns("/**/login/**");



    }
}
