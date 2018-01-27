package com.wangwei.aop;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

/**
 * SpringBoot AOP开发流程：
 * 1、加入springboot-aop的依赖。加入之后，默认就支持了AOp
 *      <dependency>
             <groupId>org.springframework.boot</groupId>
             <artifactId>spring-boot-starter-aop</artifactId>
         </dependency>
    2、编写一个切面类Aspect(封装横切关注点：日志，监控等等)，需要在方法上配置通知（前置通知、后置通知、最终通知、环绕通知）,以及切入点。
    3、将切面纳入到Spring容器中管理起来。并且这个切面对象上需要加上@Aspect注解

    --spring.aop.auto=true,配置是否启用AOP，默认true开启
    且默认使用JDk的动态代理
    -- spring.aop.proxy-target-class=false 配置代理的方式。默认false 或者不配置-采用JDK的动态代理(依赖接口)
        如果配置成false，但是类没有接口，则依然使用cglib代理
    -- spring.aop.proxy-target-class=true 的话，使用cglib代理(不依赖接口)

 --@EnableAspectJAutoProxy 注解：启用AOP。不加注解也会默认启用。
    属性：proxyTargetClass = false，配置代理的方式，默认false-JDK动态代理
            exposeProxy = false，配置成true，则可以使用 AopContext.currentProxy().getClass()获取当前代理对象
                    默认false。

 */
@SpringBootApplication
@EnableAspectJAutoProxy(exposeProxy = true)
public class AopAppCli {
    public static void main(String[] args) {
        ConfigurableApplicationContext context = SpringApplication.run(AopAppCli.class, args);
        IAopUserDao aopUserDao = context.getBean(IAopUserDao.class);
        System.out.println(aopUserDao.getClass());
        aopUserDao.addUser("张三");
        context.close();
    }
}
