package com.Gleb.repositories;

import com.Gleb.TypeOfUpdate;
import com.Gleb.entities.Client;

import java.sql.*;

public class ClientsRepository implements Repository {

    @Override
    public PreparedStatement createStatement(Object entity, TypeOfUpdate typeOfUpdate,
                                             Connection connection) throws SQLException {
        Client client = (Client) entity;
        PreparedStatement statement;

        if (typeOfUpdate != TypeOfUpdate.ADD_WITH_ID) {
            if (typeOfUpdate == TypeOfUpdate.UPDATE) {
                statement = connection.prepareStatement(
                        "update clients set full_name = ?, date_birth = ?, gender = ? where id = ?");
                statement.setInt(4, client.getId());
            } else {
                statement = connection.prepareStatement(
                        "insert into clients (full_name, date_birth, gender) values (?, ?, ?)");
            }
            statement.setString(1, client.getFullName());
            statement.setDate(2, Date.valueOf(client.getDateBirth()));
            statement.setBoolean(3, client.isGender());
        }
        else {
            statement = connection.prepareStatement(
                    "insert into clients (id, full_name, date_birth, gender) values (?, ?, ?, ?)");
            statement.setInt(1, client.getId());
            statement.setString(2, client.getFullName());
            statement.setDate(3, Date.valueOf(client.getDateBirth()));
            statement.setBoolean(4, client.isGender());
        }

        return statement;
    }

    @Override
    public Object getById(int id) throws SQLException {
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
            return null;
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
