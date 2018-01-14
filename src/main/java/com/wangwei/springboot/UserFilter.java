package com.wangwei.springboot;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.time.LocalDateTime;

/**
 * Servlet3.0支持的注解
 * --@WebFilter(filterName = "UserFilter",urlPatterns = "/*")
 */
//@WebFilter(filterName = "UserFilter",urlPatterns = "/*")
public class UserFilter implements Filter {
    public void destroy() {
    }

    public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain) throws ServletException, IOException {
        HttpServletRequest request = (HttpServletRequest) req;
        System.out.println(request.getRemotePort()+"=====SPringBoot UserFilter   log  start  "+ LocalDateTime.now().toString());
        chain.doFilter(req, resp);
    }

    public void init(FilterConfig config) throws ServletException {

    }

}
