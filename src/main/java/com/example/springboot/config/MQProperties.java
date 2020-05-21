package com.example.springboot.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * ClassName:MQProperties
 * Package:com.example.springboot.config
 * Description:
 *
 * @date:2020/5/18 17:07
 * @author:zh
 */
@Component
@ConfigurationProperties(prefix = "mq")
public class MQProperties {
    private String defaultExchange;
    private String routeKey;
    private String queue;

    public String getDefaultExchange() {
        return defaultExchange;
    }

    public void setDefaultExchange(String defaultExchange) {
        this.defaultExchange = defaultExchange;
    }

    public String getRouteKey() {
        return routeKey;
    }

    public void setRouteKey(String routeKey) {
        this.routeKey = routeKey;
    }

    public String getQueue() {
        return queue;
    }

    public void setQueue(String queue) {
        this.queue = queue;
    }

}
