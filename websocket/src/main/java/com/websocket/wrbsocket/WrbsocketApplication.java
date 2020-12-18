package com.websocket.wrbsocket;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

/**
 * @author Admin
 */
@SpringBootApplication(exclude= {DataSourceAutoConfiguration.class})
public class WrbsocketApplication {

    public static void main(String[] args) {
        SpringApplication.run(WrbsocketApplication.class, args);
    }

}
