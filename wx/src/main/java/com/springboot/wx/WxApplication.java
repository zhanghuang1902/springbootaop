package com.springboot.wx;

import com.srpingboot.jedis.util.JedisUtil;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.http.converter.StringHttpMessageConverter;
import org.springframework.web.client.RestTemplate;

import java.nio.charset.StandardCharsets;

@SpringBootApplication
public class WxApplication {

    public static void main(String[] args) {
        SpringApplication.run(WxApplication.class, args);
    }


    @Bean
    public RestTemplate restTemplate(){
        RestTemplate restTemplate = new RestTemplate();
        restTemplate.getMessageConverters().set(1, new StringHttpMessageConverter(StandardCharsets.UTF_8));
        return restTemplate;
    }

    @Bean
    public JedisUtil jedisUtil(){
        return new JedisUtil();
    }
}
