package com.Gleb.repositories;

import com.Gleb.DBConnection;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public interface Repository<T> {

    default ResultSet getEntityById(String entity, int id, PreparedStatement statement) throws SQLException {
        ResultSet queryRes;

        statement = DBConnection.getConnection().prepareStatement(String.format
                ("select * from %s c where c.id = ?", entity));
        statement.setInt(1, id);

        queryRes = statement.executeQuery();

        return queryRes;
    }

    default void deleteEntityById(String entity, int id) throws SQLException {
        PreparedStatement statement = DBConnection.getConnection()
                .prepareStatement(String.format("delete from %s where id = ?", entity));
        statement.setInt(1, id);

        statement.execute();
    }

    default void executeUpdateTable(PreparedStatement statement) throws SQLException {
        statement.executeUpdate();
        if (statement != null) { statement.close(); }
    }

    T getById(int id) throws Exception;

    void add(T entity) throws SQLException;

    void update(T entity) throws SQLException;

    void delete(int id) throws SQLException;
}
