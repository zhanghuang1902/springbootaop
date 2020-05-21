package com.example.springboot.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * ClassName:CenterUrl
 * Package:com.example.springboot.config
 * Description:
 *
 * @date:2020/2/21 22:09
 * @author:zh
 */
@Component
@ConfigurationProperties("url")
public class CenterUrl {

    private String orderUrl;

    private String userUrl;

    private String triageUrl;

    public String getOrderUrl() {
        return orderUrl;
    }

    public void setOrderUrl(String orderUrl) {
        this.orderUrl = orderUrl;
    }

    public String getUserUrl() {
        return userUrl;
    }

    public void setUserUrl(String userUrl) {
        this.userUrl = userUrl;
    }

    public String getTriageUrl() {
        return triageUrl;
    }

    public void setTriageUrl(String triageUrl) {
        this.triageUrl = triageUrl;
    }
}
