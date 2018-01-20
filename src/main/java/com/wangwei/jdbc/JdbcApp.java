package com.wangwei.jdbc;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.sql.DataSource;
import java.sql.Connection;

/**
 * 装配DataSource的步骤：
 * 1)加入spring-boot-starter-jdbc依赖
 * 2)加入MySQL数据库驱动
 * 3)在配置文件中配置如下 属性：
 *  spring.datasource.driverClassName=com.mysql.jdbc.Driver
    spring.datasource.url=jdbc:mysql://localhost:3306/springboot?createDatabaseIfNotExist=true&useUnicode=true&characterEncoding=utf8
    spring.datasource.username=root
    spring.datasource.password=root

 这样做之后，SpringBoot会自动装配好DataSource、JdbcTemplate对象

 SpringBoot默认支持数据源，参见DataSourceAutoConfiguration

 SpringBoot事物：
 1)只能对RuntimeException及其子类，事物才有效，否则不生效。如throw new FileNotFoundException();
 2)开启事物：在方法上加上注解@Transactional
 3)事物只对public修饰的方法有效
 */
@SpringBootApplication
@EnableTransactionManagement//开启事物管理。测试不加此注解，事物也启用了
public class JdbcApp {
    public static void main(String[] args) throws Exception {
        ConfigurableApplicationContext context = SpringApplication.run(JdbcApp.class, args);
        System.out.println(context.getBean(DataSource.class));
        DataSource ds = context.getBean(DataSource.class);
        Connection conn = ds.getConnection();
        System.out.println(conn.getCatalog());
        System.out.println(context.getBean(JdbcTemplate.class));
        System.out.println(ds.getClass());
        UserDao userDao = context.getBean(UserDao.class);
//        userDao.add("zhangsan");
//        userDao.add2("lisi");
//        userDao.add3("wangwu");
//        userDao.add4("王威");
        /**
         * userDao直接调用的方法上必须要有注解，事物才能生效。方法内部的 方法加了注解 @Transactional，事物无效
         */
        userDao.addUser("胡英");
        context.close();
    }
}
