package com.Gleb.hotelroomreservations;

import liquibase.integration.spring.SpringLiquibase;
import org.apache.commons.dbcp2.BasicDataSource;
import org.springframework.context.annotation.Bean;

public class AppConfig {

    @Bean
    public SpringLiquibase getSpringLiquibase() {
        SpringLiquibase liquibase = new SpringLiquibase();
        liquibase.setChangeLog("classpath:config/liquibase/master.xml");

        BasicDataSource dataSource = new BasicDataSource();
        dataSource.setUrl("jdbc:postgresql://localhost:5432/postgres");
        dataSource.setUsername("postgres");
        dataSource.setPassword("postgres");
        dataSource.setMaxTotal(1);
        liquibase.setDataSource(dataSource);

        return liquibase;
    }
}
