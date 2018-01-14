package com.wangwei.springboot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;

/**
 *SpringBoot中设置端口号、contextPath等配置，参见ServerProperties类
 *
 * SpringBoot中加载静态资源配置，参见ResourceProperties类
 *  --默认加载{
 "      classpath:/META-INF/resources/", "classpath:/resources/",
 "      classpath:/static/", "classpath:/public/" }路径下的资源。
        可以通过spring.resources.staticLocations在属性文件中进行配置。
 *
 * SpringBoot的web开发，默认使用Tomcat容器，如果想换成其他的，如Jetty容器，需要在pom.xml中排除tomcat依赖
 *
 * <dependency>
     <groupId>org.springframework.boot</groupId>
     <artifactId>spring-boot-starter-web</artifactId>
     <exclusions>
         <exclusion>
             <groupId>org.springframework.boot</groupId>
             <artifactId>spring-boot-starter-tomcat</artifactId>
         </exclusion>
     </exclusions>
    </dependency>
 *
 *  同时加入jetty容器的依赖.
 *
 *  =================================================================================
 *  SpringBoot中使用Servlet、Filter、Listener
 *  1）Servlet
 *      --第一种方式：编写一个Servlet，并使用@WebServlet进行声明，同时需要在App启动类中加入@ServletComponentScan
 *      --第二种方式：编写一个Servlet,不使用@WebServlet进行声明，而是在配置类中将Bean注入.例如：
 *      @Bean
        public ServletRegistrationBean createUserServlet(){
            ServletRegistrationBean userServlet = new ServletRegistrationBean();
            userServlet.setServlet(new UserServlet());
            userServlet.setUrlMappings(Arrays.asList("/user"));
            return userServlet;
        }
  2)Filter
        --第一种方式：编写一个Filter，并使用@WebFilter进行声明，同时需要在App启动类中加入@ServletComponentScan
 *      --第二种方式：编写一个Filter,不使用@WebFilter进行声明，而是在配置类中将Bean注入.例如：
 *          @Bean
            public FilterRegistrationBean createUserFilter(){
                FilterRegistrationBean userFilter = new FilterRegistrationBean();
                userFilter.setFilter(new UserFilter());
                userFilter.setUrlPatterns(Arrays.asList("/*"));
            return userFilter;
            ｝

    3）Listener
        --第一种方式：编写一个Listener，并使用@WebListener进行声明，同时需要在App启动类中加入@ServletComponentScan
 *      --第二种方式：编写一个Listener,不使用@WebListener进行声明，而是在配置类中将Bean注入.例如：
 *          @Bean
            public ServletListenerRegistrationBean createListener(){
                ServletListenerRegistrationBean<MyUserListener> myUserListener = new ServletListenerRegistrationBean<>();
                myUserListener.setListener(new MyUserListener());
            return myUserListener;
            }

 */
//@ServletComponentScan
@SpringBootApplication
public class App {
    public static void main(String[] args) {
        SpringApplication.run(App.class,args);

    }
}
