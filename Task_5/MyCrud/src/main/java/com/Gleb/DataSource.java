package com.Gleb;

import org.apache.commons.dbcp2.BasicDataSource;

import java.sql.Connection;
import java.sql.SQLException;
import java.time.Duration;

public class DataSource {

    private DataSource() {}

    private static BasicDataSource dataSource;

    static {
        dataSource = new BasicDataSource();
        dataSource.setUrl("jdbc:postgresql://localhost:5432/postgres");
        dataSource.setUsername("postgres");
        dataSource.setPassword("postgres");
        dataSource.setMinIdle(5);
        dataSource.setMaxTotal(10);
        dataSource.setMaxWait(Duration.ofMinutes(10));
    }

    public static Connection getConnection() throws SQLException {
        return dataSource.getConnection();
    }
}
