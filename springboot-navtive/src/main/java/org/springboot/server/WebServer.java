package org.springboot.server;

import org.springframework.context.ApplicationContext;
import org.springframework.web.context.WebApplicationContext;

public interface WebServer {

    void startUp(String ip, int port, WebApplicationContext WebApplicationContext) throws Exception;
}
