package com.wangwei.springboot;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

/**
 * @WebListener servlet3.0支持注解
 */
//@WebListener
public class MyUserListener implements ServletContextListener {
    @Override
    public void contextInitialized(ServletContextEvent servletContextEvent) {
        System.out.println("************Application start init  ********");
    }

    @Override
    public void contextDestroyed(ServletContextEvent servletContextEvent) {

    }
}
