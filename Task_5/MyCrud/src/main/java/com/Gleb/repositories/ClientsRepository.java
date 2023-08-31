package com.Gleb.repositories;

import com.Gleb.entities.Car;
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
        statement.setBoolean(3, client.getGender());

        return statement;
    }

    public Client getClientById(int id) throws Exception {
        Client client = new Client();
        ResultSet queryRes = this.getEntityById("clients", id);

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

        return client;
    }

    public void addClient(Client client) throws SQLException {
        this.executeUpdateTable(this.createStatement(client, false));
    }

    public void updateClient(Client client) throws SQLException {
        this.executeUpdateTable(this.createStatement(client, true));
    }

    public void deleteClient(int id) throws SQLException {
        this.deleteEntityById("clients", id);
    }
 }
