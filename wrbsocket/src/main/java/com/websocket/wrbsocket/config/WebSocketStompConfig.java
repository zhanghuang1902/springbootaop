package com.websocket.wrbsocket.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.socket.server.standard.ServerEndpointExporter;

/**
 * ClassName:WebSocketStompConfig
 * Package:com.websocket.wrbsocket.config
 * Description:
 *
 * @date:2020/9/16 11:19
 * @author:zh
 * 节点配置类
 */

@Configuration
public class WebSocketStompConfig {
    //这个bean的注册,用于扫描带有@ServerEndpoint的注解成为websocket  ,如果你使用外置的tomcat就不需要该配置文件
    @Bean
    public ServerEndpointExporter serverEndpointExporter()
    {
        return new ServerEndpointExporter();
    }
}
