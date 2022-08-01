/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.SpringBoot.filter;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

/**
 *
 * @author sks
 */
public class StudentFilter implements Filter {

    @Override
    public void init(FilterConfig fc) throws ServletException {
//        Filter.super.init(fc); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void doFilter(ServletRequest sr, ServletResponse sr1, FilterChain fc) throws IOException, ServletException {
//        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        HttpServletRequest req = (HttpServletRequest) sr;
        System.out.println("Inside Student Filter " + req.getLocalAddr());

        fc.doFilter(sr, sr1);
        System.out.println("After Inside Student Filter " + req.getLocalAddr());

    }

    @Override
    public void destroy() {
//        Filter.super.destroy(); //To change body of generated methods, choose Tools | Templates.
    }

}
