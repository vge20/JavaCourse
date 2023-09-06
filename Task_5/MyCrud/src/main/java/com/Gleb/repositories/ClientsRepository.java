package com.Gleb.repositories;

import com.Gleb.entities.Client;

import java.sql.*;

public class ClientsRepository implements Repository {

    @Override
    public PreparedStatement createStatement(Object entity, boolean isUpdate,
                                             Connection connection) throws SQLException {
        Client client = (Client) entity;
        PreparedStatement statement;
        if (isUpdate) {
            statement = connection.prepareStatement(
                    "update clients set full_name = ?, date_birth = ?, gender = ? where id = ?");
            statement.setInt(4, client.getId());
        }
        else {
            statement = connection.prepareStatement(
                    "insert into clients (full_name, date_birth, gender) values (?, ?, ?)");
        }
        statement.setString(1, client.getFullName());
        statement.setDate(2, Date.valueOf(client.getDateBirth()));
        statement.setBoolean(3, client.isGender());

        return statement;
    }

    @Override
    public Object getById(int id) throws Exception {
        Client client = new Client();
        PreparedStatement statement = null;
        ResultSet queryRes = this.getEntityById("clients", id, statement);

        if (queryRes.next()) {
            client.setId(queryRes.getInt("id"));
            client.setFullName(queryRes.getString("full_name"));
            client.setDateBirth(queryRes.getString("date_birth"));
            client.setGender(queryRes.getBoolean("gender"));
        }
        else {
            throw new Exception();
        }

        if (statement != null) { statement.close(); }
        if (queryRes != null) { queryRes.close(); }

        return client;
    }

    @Override
    public void delete(int id) throws SQLException {
        this.deleteEntityById("clients", id);
    }
}
