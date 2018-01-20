package com.wangwei.embedded;

import org.apache.catalina.connector.Connector;
import org.apache.catalina.valves.AccessLogValve;
import org.apache.coyote.http11.Http11NioProtocol;
import org.springframework.boot.context.embedded.ConfigurableEmbeddedServletContainer;
import org.springframework.boot.context.embedded.EmbeddedServletContainerCustomizer;
import org.springframework.boot.context.embedded.tomcat.TomcatConnectorCustomizer;
import org.springframework.boot.context.embedded.tomcat.TomcatEmbeddedServletContainerFactory;
import org.springframework.stereotype.Component;

import java.io.File;
import java.util.Arrays;

/**
 * Created by wangwei on 2018/1/17.
 */
//@Component
public class MyEmbeddedServletContainerCustomizer implements EmbeddedServletContainerCustomizer {
    @Override
    public void customize(ConfigurableEmbeddedServletContainer container) {
        System.out.println("------------"+container.getClass());
        TomcatEmbeddedServletContainerFactory tomcatFactory = (TomcatEmbeddedServletContainerFactory) container;
        tomcatFactory.setPort(8888);
        tomcatFactory.setBaseDirectory(new File("E:/logs/tomcat"));
        tomcatFactory.addContextValves(createAccessLog());
        tomcatFactory.addConnectorCustomizers(new MyTomcatConnectorCustomizer());
    }
    private AccessLogValve createAccessLog(){
        AccessLogValve accessLogValve = new AccessLogValve();
        accessLogValve.setEnabled(true);
        accessLogValve.setPattern("combined");
        accessLogValve.setPrefix("springboot-tomcat-logs");
        accessLogValve.setDirectory("E:/logs");
        accessLogValve.setSuffix(".txt");
        return accessLogValve;
    }
}
class MyTomcatConnectorCustomizer implements TomcatConnectorCustomizer{

    @Override
    public void customize(Connector connector) {
        System.out.println("--connector:"+connector.getProtocol());
        System.out.println("--connector:"+connector.getScheme());
        System.out.println("--connector:"+connector.getProtocolHandler().getClass());
        Http11NioProtocol protocol = (Http11NioProtocol) connector.getProtocolHandler();
        protocol.setMaxConnections(2000);
        protocol.setMaxThreads(50);
    }
}
