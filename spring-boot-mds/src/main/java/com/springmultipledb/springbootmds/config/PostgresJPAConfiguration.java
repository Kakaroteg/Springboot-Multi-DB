package com.springmultipledb.springbootmds.config;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.orm.jpa.EntityManagerFactoryBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.sql.DataSource;

@EnableTransactionManagement
@Configuration
@EnableJpaRepositories(
        basePackages = "com.springmultipledb.springbootmds.orderrepository",
        entityManagerFactoryRef = "postGresEntityManagerFactoryBean",
        transactionManagerRef = "postgresTransactionManager"
)
public class PostgresJPAConfiguration {

    @Bean
    LocalContainerEntityManagerFactoryBean postGresEntityManagerFactoryBean(EntityManagerFactoryBuilder entityManagerFactoryBuilder,
                                                                         @Qualifier("postgresDatasource") DataSource dataSource)
    {
        return entityManagerFactoryBuilder
                .dataSource(dataSource)
                .packages("com.springmultipledb.springbootmds.orderentity")
                .build();
    }
    @Bean
    PlatformTransactionManager postgresTransactionManager(@Qualifier("postGresEntityManagerFactoryBean") LocalContainerEntityManagerFactoryBean emfb)
    {
        return new JpaTransactionManager(emfb.getObject());
    }
}
