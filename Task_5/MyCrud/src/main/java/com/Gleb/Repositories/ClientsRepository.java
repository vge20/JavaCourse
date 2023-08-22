package com.Gleb.Repositories;

import com.Gleb.BLObjects.Client;
import com.Gleb.DBConnection;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class ClientsRepository {

    public Client getClientById(String id) throws Exception {
        Client client = new Client();
        Connection connection = null;
        Statement statement = null;
        ResultSet queryRes = null;

        try {
            statement = DBConnection.getConnection().createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,
                    ResultSet.CONCUR_UPDATABLE);

            queryRes = statement.executeQuery("select * from clients c where c.id = " + id);

            if (queryRes.next()) {
                client.setId(queryRes.getInt("id"));
                client.setFullName(queryRes.getString("full_name"));
                client.setDateBirth(queryRes.getDate("date_birth"));
                client.setGender(queryRes.getBoolean("gender"));
            }
            else {
                throw new Exception();
            }
        }
        catch (Exception e) {
            throw new Exception();
        }

        try {
            if (queryRes != null) { queryRes.close(); }
            if (statement != null) { statement.close(); }
            if (connection != null) { connection.close(); }
        } catch (SQLException e) {
            throw new SQLException();
        }

        return client;
    }
}
