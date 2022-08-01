/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.SpringBoot;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 *
 * @author sks
 */
@Configuration
public class InterceptorConfig implements WebMvcConfigurer {

    @Autowired
    private APIInterceptor apiLoggerInterceptor;
    @Autowired
    private APIInterceptor_1 apiLoggerInterceptor1;

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(apiLoggerInterceptor).order(1);
        registry.addInterceptor(apiLoggerInterceptor1).order(2);

//        registry.addInterceptor(apiLoggerInterceptor).addPathPatterns("/students/**");
    }

}
