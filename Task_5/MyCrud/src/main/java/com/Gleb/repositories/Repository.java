package com.Gleb.repositories;

import com.Gleb.DataSource;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public interface Repository<T> {

    default ResultSet getEntityById(String entity, int id, PreparedStatement statement) throws SQLException {
        ResultSet queryRes;
        Connection connection = DataSource.getConnection();

        statement = connection.prepareStatement(String.format
                ("select * from %s c where c.id = ?", entity));
        statement.setInt(1, id);

        queryRes = statement.executeQuery();

        return queryRes;
    }

    default void deleteEntityById(String entity, int id) throws SQLException {
        Connection connection = DataSource.getConnection();
        connection.setAutoCommit(false);

        PreparedStatement statement = connection
                .prepareStatement(String.format("delete from %s where id = ?", entity));
        statement.setInt(1, id);

        statement.executeUpdate();
        connection.commit();
    }

    default void executeUpdateTransaction(Object entity, boolean isUpdate) throws SQLException {
        Connection connection = DataSource.getConnection();
        connection.setAutoCommit(false);
        PreparedStatement statement = this.createStatement(entity, isUpdate, connection);
        statement.executeUpdate();
        connection.commit();
        if (statement != null) { statement.close(); }
    }

    PreparedStatement createStatement(Object entity, boolean isUpdate, Connection connection) throws SQLException;

    T getById(int id) throws SQLException;

    default void add(T entity) throws SQLException {
        this.executeUpdateTransaction(entity, false);
    }

    default void update(T entity) throws SQLException {
        this.executeUpdateTransaction(entity, true);
    }

    void delete(int id) throws SQLException;
}
