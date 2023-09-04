package com.Gleb.repositories;

import com.Gleb.entities.Client;
import com.Gleb.DBConnection;

import java.sql.*;

public class ClientsRepository implements Repository {

    private PreparedStatement createStatement(Client client, boolean isUpdate) throws SQLException {
        PreparedStatement statement;
        if (isUpdate) {
            statement = DBConnection.getConnection().prepareStatement(
                    "update clients set full_name = ?, date_birth = ?, gender = ? where id = ?");
            statement.setInt(4, client.getId());
        }
        else {
            statement = DBConnection.getConnection().prepareStatement(
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
    public void add(Object entity) throws SQLException {
        this.executeUpdateTable(this.createStatement((Client) entity, false));
    }

    @Override
    public void update(Object entity) throws SQLException {
        this.executeUpdateTable(this.createStatement((Client) entity, true));
    }

    @Override
    public void delete(int id) throws SQLException {
        this.deleteEntityById("clients", id);
    }
}
