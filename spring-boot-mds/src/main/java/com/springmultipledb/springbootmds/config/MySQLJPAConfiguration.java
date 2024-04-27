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
        basePackages = "com.springmultipledb.springbootmds.productrepository",
        entityManagerFactoryRef = "mySQLEntityManagerFactoryBean",
        transactionManagerRef = "mySqlTransactionManager"
)
public class MySQLJPAConfiguration {

    @Bean
    LocalContainerEntityManagerFactoryBean mySQLEntityManagerFactoryBean(EntityManagerFactoryBuilder entityManagerFactoryBuilder,
                                                                         @Qualifier("mysqlDatasource") DataSource dataSource)
    {
        return entityManagerFactoryBuilder
                .dataSource(dataSource)
                .packages("com.springmultipledb.springbootmds.productentity")
                .build();
    }

    @Bean
    PlatformTransactionManager mySqlTransactionManager( @Qualifier("mySQLEntityManagerFactoryBean") LocalContainerEntityManagerFactoryBean emfb)
    {
        return new JpaTransactionManager(emfb.getObject());
    }
}
