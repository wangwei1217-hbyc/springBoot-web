package com.wangwei.springboot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.web.ErrorMvcAutoConfiguration;
import org.springframework.boot.context.embedded.AnnotationConfigEmbeddedWebApplicationContext;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;

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

 ** 拦截器的使用：
 * 1）编写一个类，实现HandlerInterceptor接口
 * 2）编写一个配置类，继承WebMvcConfigurerAdapter抽象类，重写addInterceptors方法。并调用registry.addInterceptor(new LogInterceptor())，把拦截器加进去。


 ----异常页面的处理：
    默认会使用ErrorMvcAutoConfiguration配置类中的默认页面
    自定义错误页面：
     1)排除掉ErrorMvcAutoConfiguration这个类。在@SpringBootApplication上加上exclude = {ErrorMvcAutoConfiguration.class}
     2)编写一个类，实现ErrorPageRegistrar接口，重写registerErrorPages方法。在方法中定义ErrorPage对象，最后将ErrorPage注册进去。
        ErrorPage对象有两个构造方法，
        public ErrorPage(HttpStatus status, String path)
        public ErrorPage(Class<? extends Throwable> exception, String path)
        例如;
public void registerErrorPages(ErrorPageRegistry registry) {
    ErrorPage e404 = new ErrorPage(HttpStatus.NOT_FOUND,"/404.html");
    ErrorPage e500 = new ErrorPage(HttpStatus.INTERNAL_SERVER_ERROR,"/500.html");
    ErrorPage eArgs = new ErrorPage(IllegalArgumentException.class, "/args.html");
    registry.addErrorPages(e404,e500,eArgs);

    *自定义异常拦截处理：
 *   1)在Controller内部，编写一个方法用来处理异常，方法上用@ExceptionHandler(value = {IllegalAccessException.class})
 *   进行声明，注解value值表明针对哪种异常进行拦截处理，可以多个。
 *   注意:局限性-只对当前Controller有效
 *   2）全局异常处理拦截：
 *   编写一个类，类上用@ControllerAdvice进行标注。
 *   类中定义异常处理方法，用@ExceptionHandler进行标注，注解参数--指明拦截何种异常。
 *   注意：此种方式全局有效。
}
 */
//@ServletComponentScan
@SpringBootApplication(scanBasePackages = {"com.wangwei"},exclude = {ErrorMvcAutoConfiguration.class})
public class App {
    public static void main(String[] args) {
        SpringApplication.run(App.class,args);
    }
}
