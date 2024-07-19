package com.bolivar.rick_and_morthy.config;

import com.zaxxer.hikari.HikariDataSource;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

import javax.sql.DataSource;

@Configuration
public class DatabaseConfig {

    @Bean
    public DataSource getDataSource() {
        DataSourceBuilder dataSourceBuilder = DataSourceBuilder.create();
        dataSourceBuilder.driverClassName("com.mysql.cj.jdbc.Driver");
        dataSourceBuilder.url("jdbc:mysql://bolivar-db-test.c5aoqae021zo.sa-east-1.rds.amazonaws.com:3306/bolivar-db-test");
        dataSourceBuilder.username("admin");
        dataSourceBuilder.password("Bolivar12345*");
        return dataSourceBuilder.build();
    }
}
