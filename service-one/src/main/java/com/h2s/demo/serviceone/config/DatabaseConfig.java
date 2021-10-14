/*
 * @created 14/10/2021 - 2:47 PM
 * @author vanha
 */

package com.h2s.demo.serviceone.config;

import com.h2s.demo.serviceone.ServiceOneConfig;
import com.netflix.discovery.converters.Auto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

import javax.sql.DataSource;

@Configuration
public class DatabaseConfig {

    @Autowired
    private ServiceOneConfig serviceOneConfig;

    @Bean
    public DataSource dataSource() {
        DataSourceBuilder dataSourceBuilder = DataSourceBuilder.create();
        dataSourceBuilder.driverClassName(serviceOneConfig.getDriverDB());
        dataSourceBuilder.url(serviceOneConfig.getUrl());
        dataSourceBuilder.username(serviceOneConfig.getUsernameDB());
        dataSourceBuilder.password(serviceOneConfig.getPasswordDB());
        return dataSourceBuilder.build();
    }
}
