/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.SpringBoot;

import com.example.SpringBoot.Entity.Student;
import java.lang.reflect.Method;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.core.MethodParameter;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

/**
 *
 * @author sks
 */
@Component
public class APIInterceptor_1 implements HandlerInterceptor {

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        System.out.println(handler);
        System.out.println("inside interceptor1 preHandle " + request.getLocalAddr());
//        if (handler instanceof HandlerMethod) {
//            if (handler != null) {
//                HandlerMethod handlerMethod = (HandlerMethod) handler;
//                System.out.println(handlerMethod.getMethod());
//                System.out.println(handlerMethod.getMethod().getName());
//                System.out.println(handlerMethod.getBean());
//                System.out.println(handlerMethod.getBean().getClass());
//                System.out.println(handlerMethod.getBean().getClass().getName());
//
//                MethodParameter parameters[] = handlerMethod.getMethodParameters();
//                for (MethodParameter parameter : parameters) {
//                    System.out.println(parameter.getParameter());
//                    System.out.println(parameter.getParameter().getName());
//                    System.out.println(parameter.getMethod());
//                    Method student = parameter.getMethod();
//                    System.out.println(student.getName());
////                }
//                return true;
//            }

//        }
            return true;
//        return false;

    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response,
            Object Handler, ModelAndView modelAndView) throws Exception {
        long startTime = System.currentTimeMillis();
        System.out.println( "Interceptor1 PostHandle" + request.getServerPort());
        

    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response,
            Object Handler, Exception ex) throws Exception {
        System.out.println("Interceptor1 AfterCompletion");
    }

}
