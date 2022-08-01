/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.SpringBoot;

import com.example.SpringBoot.filter.Filter2;
import com.example.SpringBoot.filter.StudentFilter;
import java.util.Enumeration;
import javax.servlet.FilterConfig;
import javax.servlet.ServletContext;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

/**
 *
 * @author sks
 */
@Configuration
public class FilterConfiguration {

   
     @Bean
    public FilterRegistrationBean<Filter2> filter2() {
        FilterRegistrationBean<Filter2> registrationBean
                = new FilterRegistrationBean<>();

        registrationBean.setFilter(new Filter2());
//        registrationBean.addUrlPatterns("/students/*");
        registrationBean.setOrder(2);

        return registrationBean;
    }
    
    @Bean
    public FilterRegistrationBean<StudentFilter> studentFilter() {
        FilterRegistrationBean<StudentFilter> registrationBean
                = new FilterRegistrationBean<>();

        registrationBean.setFilter(new StudentFilter());
//        registrationBean.addUrlPatterns("");
        registrationBean.setOrder(1);

        return registrationBean;
    }
}
