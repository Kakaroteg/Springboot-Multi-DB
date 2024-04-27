package com.springmultipledb.springbootmds.config;

import org.springframework.boot.autoconfigure.jdbc.DataSourceProperties;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

import javax.sql.DataSource;

@Configuration
public class PostgresSqlDatasourceConfiguration {

    @ConfigurationProperties("spring.datasource.pg")
    @Bean
    public DataSourceProperties postgresDatasourceProperties()
    {
       return new DataSourceProperties();
    }

    @Bean
    public DataSource postgresDatasource()
    {
        return postgresDatasourceProperties().initializeDataSourceBuilder().build();
    }

}
