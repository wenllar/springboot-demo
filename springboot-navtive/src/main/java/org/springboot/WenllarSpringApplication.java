package org.springboot;

import org.springboot.server.WebServer;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;

import java.util.Map;

public class WenllarSpringApplication {


    public static void run(Class clazz) throws Exception {
        AnnotationConfigWebApplicationContext applicationContext = new AnnotationConfigWebApplicationContext();
        applicationContext.register(clazz);
        applicationContext.refresh();

        WebServer bean = getWebServer(applicationContext);
        bean.startUp("localhost", 8089, applicationContext);
    }


    private static WebServer getWebServer(AnnotationConfigWebApplicationContext applicationContext){
        Map<String, WebServer> beansOfType = applicationContext.getBeansOfType(WebServer.class);
        if(beansOfType.isEmpty()){
            throw new NullPointerException();
        }

        if(beansOfType.size() > 1){
            throw new IllegalStateException();
        }

        return beansOfType.values().stream().findFirst().get();
    }
}
