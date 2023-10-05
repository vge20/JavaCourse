package com.Gleb.hotelroomreservations.configurs;

import liquibase.integration.spring.SpringLiquibase;
import org.apache.commons.dbcp2.BasicDataSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.sql.DataSource;
import java.time.Duration;

@Configuration
public class AppConfig {

    private BasicDataSource dataSource;

    public AppConfig() {
        dataSource = new BasicDataSource();
        dataSource.setDriverClassName("org.postgresql.Driver");
        dataSource.setUrl("jdbc:postgresql://localhost:5432/postgres");
        dataSource.setUsername("postgres");
        dataSource.setPassword("postgres");
        dataSource.setMinIdle(5);
        dataSource.setMaxTotal(10);
        dataSource.setMaxWait(Duration.ofMinutes(10));
    }

    @Bean
    public DataSource getDataSource() {
        return dataSource;
    }

    @Bean
    public SpringLiquibase getSpringLiquibase() {
        SpringLiquibase liquibase = new SpringLiquibase();
        liquibase.setChangeLog("classpath:config/liquibase/master.xml");

        liquibase.setDataSource(dataSource);

        return liquibase;
    }
}
