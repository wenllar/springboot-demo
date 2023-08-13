package org.springboot.server.impl;

import org.eclipse.jetty.servlet.ServletHolder;
import org.eclipse.jetty.servlet.ServletMapping;
import org.springboot.server.WebServer;
import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.servlet.ServletContextHandler;
import org.eclipse.jetty.servlet.ServletHandler;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.servlet.DispatcherServlet;

public class JettyServer implements WebServer {
    @Override
    public void startUp(String host, int port, WebApplicationContext WebApplicationContext) throws Exception{
        System.out.println("启动Jetty服务");

        // 必须使用ServletContextHandler，启动Jetty服务，如若使用ServletHandler 将无法获取Contextpath，处理MVC请求时会报 nullpointException
        this.startJettyServerWithHandler(host, port, WebApplicationContext);

        // 调用以下方法，无法获取Contextpath，处理MVC请求时会报 nullpointException
       // this.startJettyServer(host, port, WebApplicationContext);
    }

    /**
     *
     * @param host
     * @param port
     * @param WebApplicationContext
     * @throws Exception
     */
    private void startJettyServer(String host, int port, WebApplicationContext WebApplicationContext) throws Exception {
        // 服务器的监听端口
        Server server = new Server(port);
        //ServletHandler通过一个servlet创建了一个非常简单的context处理器
        //这个处理器需要在Server上注册
        ServletHandler handler = new ServletHandler();
        server.setHandler(handler);
        //传入能匹配到这个servlet的路径
        //提示：这是一个未经处理的servlet，没有通过web.xml或@WebServlet注解或其他方式配置
        ServletHolder servletHolder = new ServletHolder(new DispatcherServlet(WebApplicationContext));
        handler.addServletWithMapping(servletHolder, "/*");
       // System.out.println(String.format("servletName = %s", servletName));
        server.start();
        server.join();
    }

    private void startJettyServerWithHandler(String host, int port, WebApplicationContext WebApplicationContext) throws Exception {
        // 服务器的监听端口
        Server server = new Server(port);

        // Add a single handler on context "/hello"
        ServletContextHandler context = new ServletContextHandler();
        context.setContextPath("/");
        ServletHolder servletHolder = new ServletHolder(new DispatcherServlet(WebApplicationContext));
        context.addServlet(servletHolder, "/*");

        // Can be accessed using http://localhost:8080/hello
        server.setHandler(context);

        // Start the server
        server.start();
        server.join();
    }
}
