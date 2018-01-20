package com.wangwei.embedded;

import org.apache.catalina.valves.AccessLogValve;
import org.springframework.boot.SpringBootConfiguration;
import org.springframework.boot.context.embedded.EmbeddedServletContainerFactory;
import org.springframework.boot.context.embedded.tomcat.TomcatEmbeddedServletContainerFactory;
import org.springframework.context.annotation.Bean;

import java.io.File;

/**
 * Created by wangwei on 2018/1/18.
 */
@SpringBootConfiguration
public class EmbeddedSevletContainerConfiguration {
    @Bean
    public EmbeddedServletContainerFactory createEmbeddedServletContainer(){
        TomcatEmbeddedServletContainerFactory containerFactory = new TomcatEmbeddedServletContainerFactory();
        containerFactory.setPort(9999);
        containerFactory.setBaseDirectory(new File("E:/logs/tomcat-server"));
        containerFactory.addContextValves(generateAccessLog());
        return containerFactory;
    }
    private AccessLogValve generateAccessLog(){
        AccessLogValve accessLogValve = new AccessLogValve();
        accessLogValve.setEnabled(true);
        accessLogValve.setPrefix("springboot-tomcatserver-logs");
        accessLogValve.setSuffix(".log");
        accessLogValve.setDirectory("E:/logs");
        accessLogValve.setPattern("combined");
        return accessLogValve;
    }
}
