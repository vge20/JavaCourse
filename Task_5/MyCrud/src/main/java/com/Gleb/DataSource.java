package com.Gleb;

import org.apache.commons.dbcp2.BasicDataSource;

import java.sql.Connection;
import java.sql.SQLException;
import java.time.Duration;

public class DataSource {

    private DataSource() {}

    private static BasicDataSource ds;

    static {
        ds = new BasicDataSource();
        ds.setUrl("jdbc:postgresql://localhost:5432/postgres");
        ds.setUsername("postgres");
        ds.setPassword("postgres");
        ds.setMinIdle(5);
        ds.setMaxTotal(10);
        ds.setMaxWait(Duration.ofMinutes(10));
    }

    public static Connection getConnection() throws SQLException {
        return ds.getConnection();
    }
}
