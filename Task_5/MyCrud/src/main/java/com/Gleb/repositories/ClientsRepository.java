package com.Gleb.repositories;

import com.Gleb.entities.Client;
import com.Gleb.DBConnection;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class ClientsRepository {

    public Client getClientById(int id) throws Exception {
        Client client = new Client();
        Statement statement = null;
        ResultSet queryRes = null;

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

        if (queryRes != null) { queryRes.close(); }
        if (statement != null) { statement.close(); }

        return client;
    }

    public void addClient(Client client) throws SQLException {
        Statement statement = null;
        statement = DBConnection.getConnection().createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,
                    ResultSet.CONCUR_UPDATABLE);

        statement.execute("insert into clients (full_name, date_birth, gender) " +
                    "values ('" + client.getFullName() + "', '" + client.getDateBirth()
                    + "', " + client.getGender() + ")");

        if (statement != null) { statement.close(); }
    }

    public void updateClient(Client client) throws SQLException {
        Statement statement = null;
        statement = DBConnection.getConnection().createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,
                    ResultSet.CONCUR_UPDATABLE);

        statement.execute("update clients set full_name = '" + client.getFullName() + "', date_birth = '" +
                    client.getDateBirth() + "', gender = " + client.getGender() + " where id = " + client.getId());

        if (statement != null) { statement.close(); }
    }

    public void deleteClient(int id) throws SQLException {
        Statement statement = null;
        statement = DBConnection.getConnection().createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,
                    ResultSet.CONCUR_UPDATABLE);

        statement.execute("delete from clients where id = " + id);

        if (statement != null) { statement.close(); }
    }
 }
