package com.wangwei.interceptor;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Created by wangwei on 2018/1/17.
 */

public class LogInterceptor implements HandlerInterceptor {
    /**Controller执行前带调用**/
    @Override
    public boolean preHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o) throws Exception {
        System.out.println("=====LogInterceptor preHandle========="+o.getClass());
        return true;
    }
    /**Controller调用之后，页面渲染之前调用**/
    @Override
    public void postHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, ModelAndView modelAndView) throws Exception {
        System.out.println("=====LogInterceptor postHandle=========");
    }
    /**页面渲染之后，一般用于资源清理操作**/
    @Override
    public void afterCompletion(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, Exception e) throws Exception {
        System.out.println("=====LogInterceptor afterCompletion=========");
    }
}
