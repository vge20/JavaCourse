package com.Gleb;

import com.Gleb.exceptions.ConnectionException;

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
            throw new RuntimeException(e); // этот метод запускается при загрузке класса,
        } catch (ClassNotFoundException e) { // поэтому если подключиться не получится,
            throw new RuntimeException(e); // то бросаем RuntimeException
        }
    }

    public static Connection getConnection() { return connection; }
}
