package com.Gleb;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnection {
    private DBConnection() {}

    private static String url = "jdbc:postgresql://localhost:5432/postgres";
    private static String user = "postgres";
    private static String password = "postgres";

    private static Connection connection;

    static {
        try {
            Class.forName("org.postgresql.Driver");
            connection = DriverManager.getConnection(url, user, password);
        } catch (SQLException e) {
            throw new RuntimeException(e); // этот меод запускается при загрузке класса,
        } catch (ClassNotFoundException e) { // поэтому не понятно, как обработать эти ошибки
            throw new RuntimeException(e);
        }
    }

    public static Connection getConnection() { return connection; }
}
