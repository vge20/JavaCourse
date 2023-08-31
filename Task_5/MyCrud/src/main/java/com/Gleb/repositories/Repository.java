package com.Gleb.repositories;

import com.Gleb.DBConnection;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public interface Repository {

    default ResultSet getEntityById(String entity, int id) throws SQLException {
        PreparedStatement statement;
        ResultSet queryRes;

        statement = DBConnection.getConnection().prepareStatement("select * from ? c where c.id = ?");
        statement.setString(1, entity);
        statement.setInt(2, id);

        queryRes = statement.executeQuery();

        if (statement != null) { statement.close(); }

        return queryRes;
    }

    default void deleteEntityById(String entity, int id) throws SQLException {
        PreparedStatement statement = DBConnection.getConnection()
                .prepareStatement("delete from ? where id = ?");
        statement.setString(1, entity);
        statement.setInt(2, id);
    }

    default void executeUpdateTable(PreparedStatement statement) throws SQLException {
        statement.execute();
        if (statement != null) { statement.close(); }
    }
}
