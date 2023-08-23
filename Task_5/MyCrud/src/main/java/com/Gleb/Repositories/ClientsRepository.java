package com.Gleb.Repositories;

import com.Gleb.BLObjects.Client;
import com.Gleb.DBConnection;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class ClientsRepository {

    public Client getClientById(int id) throws Exception {
        Client client = new Client();
        Statement statement = null;
        ResultSet queryRes = null;

        try {
            statement = DBConnection.getConnection().createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,
                    ResultSet.CONCUR_UPDATABLE);

            queryRes = statement.executeQuery("select * from clients c where c.id = " + id);

            if (queryRes.next()) {
                client.setId(queryRes.getInt("id"));
                client.setFullName(queryRes.getString("full_name"));
                client.setDateBirth(queryRes.getString("date_birth"));
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
        } catch (SQLException e) {
            throw new SQLException();
        }

        return client;
    }

    public void addClient(Client client) throws Exception {
        Statement statement = null;
        try {
            statement = DBConnection.getConnection().createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,
                    ResultSet.CONCUR_UPDATABLE);

            statement.execute("insert into clients (full_name, date_birth, gender) " +
                    "values ('" + client.getFullName() + "', '" + client.getDateBirth()
                    + "', " + client.getGender() + ")");

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        try {
            if (statement != null) { statement.close(); }
        } catch (SQLException e) {
            throw new SQLException();
        }
    }

    public void updateClient(Client client) throws Exception {
        Statement statement = null;
        try {
            statement = DBConnection.getConnection().createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,
                    ResultSet.CONCUR_UPDATABLE);

            statement.execute("update clients set full_name = '" + client.getFullName() + "', date_birth = '" +
                    client.getDateBirth() + "', gender = " + client.getGender() + " where id = " + client.getId());

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        try {
            if (statement != null) { statement.close(); }
        } catch (SQLException e) {
            throw new SQLException();
        }
    }

    public void deleteClient(int id) throws Exception {
        Statement statement = null;
        try {
            statement = DBConnection.getConnection().createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,
                    ResultSet.CONCUR_UPDATABLE);

            statement.execute("delete from clients where id = " + id);

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        try {
            if (statement != null) { statement.close(); }
        } catch (SQLException e) {
            throw new SQLException();
        }
    }
 }
