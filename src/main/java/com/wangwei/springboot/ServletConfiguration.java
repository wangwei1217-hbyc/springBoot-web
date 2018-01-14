package com.wangwei.springboot;

import org.springframework.boot.SpringBootConfiguration;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.boot.web.servlet.ServletListenerRegistrationBean;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;

import java.util.Arrays;

/**
 * Created by wangwei on 2018/1/14.
 */
@SpringBootConfiguration
public class ServletConfiguration {

    @Bean
    public ServletRegistrationBean createUserServlet(){
        ServletRegistrationBean userServlet = new ServletRegistrationBean();
        userServlet.setServlet(new UserServlet());
        userServlet.setUrlMappings(Arrays.asList("/user"));
        return userServlet;
    }
    @Bean
    public FilterRegistrationBean createUserFilter(){
        FilterRegistrationBean userFilter = new FilterRegistrationBean();
        userFilter.setFilter(new UserFilter());
        userFilter.setUrlPatterns(Arrays.asList("/*"));
        return userFilter;
    }
    @Bean
    public ServletListenerRegistrationBean createListener(){
        ServletListenerRegistrationBean<MyUserListener> myUserListener = new ServletListenerRegistrationBean<>();
        myUserListener.setListener(new MyUserListener());
        return myUserListener;
    }
}
