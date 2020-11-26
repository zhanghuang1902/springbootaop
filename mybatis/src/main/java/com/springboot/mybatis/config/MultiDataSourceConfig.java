package com.springboot.mybatis.config;

import com.alibaba.druid.spring.boot.autoconfigure.DruidDataSourceBuilder;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

import javax.sql.DataSource;

/**
 * ClassName:MultiDataSourceConfig
 * Package:com.springboot.mybatis.config
 * Description:
 *
 * @date:2020/11/26 17:13
 * @author:zh
 */
@Configuration
public class MultiDataSourceConfig {

    @Primary
    @Bean(name = "oneDataSource")
    @ConfigurationProperties("spring.datasource.one")
    public DataSource dataSourceOne(){
        return DruidDataSourceBuilder.create().build();
    }
    @Bean(name = "twoDataSource")
    @ConfigurationProperties("spring.datasource.two")
    public DataSource dataSourceTwo(){
        return DruidDataSourceBuilder.create().build();
    }
}
