package com.wangwei.springboot;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Servlet3.0支持的注解
 *--@WebServlet(name = "UserServlet",urlPatterns = "/userServlet")
 */
@WebServlet(name = "UserServlet",urlPatterns = "/userServlet")
public class UserServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.getWriter().println("===SpringBoot UserServlet==");
    }
}
