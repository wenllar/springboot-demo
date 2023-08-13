package org.springboot.config;


import org.springboot.condition.JettyServerCondition;
import org.springboot.condition.TomcatServerCondition;
import org.springboot.server.WebServer;
import org.springboot.server.impl.JettyServer;
import org.springboot.server.impl.TomcatServer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Conditional;
import org.springframework.context.annotation.Configuration;

@Configuration
public class WebServerAutoConfiguration implements AutoConfiguration{

    @Bean
    @Conditional(TomcatServerCondition.class)
    public WebServer tomcatServer(){
        return new TomcatServer();
    }

    @Bean
    @Conditional(JettyServerCondition.class)
    public WebServer jettyServer(){
        return new JettyServer();
    }

}
