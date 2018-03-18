package com.wangwei.springboot;

import com.wangwei.EnableRedis;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import redis.clients.jedis.Jedis;

/**
 * Created by wangwei on 2018/3/18.
 */
@SpringBootApplication
//@EnableRedis
public class App2 {
    public static void main(String[] args) {
        ConfigurableApplicationContext context = SpringApplication.run(App2.class, args);
        Jedis jedis = context.getBean(Jedis.class);
        System.out.println(jedis);
//        jedis.set("huying","wangwei");
        System.out.println(jedis.get("huying")+" love "+jedis.get("wangwei")+" forever!");
        context.close();
    }
}
