package com.Gleb.services;

import com.Gleb.exceptions.DoesNotExistRecordException;
import com.Gleb.exceptions.WorkingWithDBException;

import java.sql.SQLException;

public interface Service<T> {

    T executeGet(int id) throws SQLException;

    void executeAdd(T entity) throws SQLException;

    void executeUpdate(T entity) throws SQLException;

    void executeDelete(int id) throws SQLException;


    default T get(int id) throws WorkingWithDBException, DoesNotExistRecordException {
        Object entity;
        try {
            entity = this.executeGet(id);
        } catch (SQLException e) {
            throw new WorkingWithDBException();
        }

        if (entity == null) {
            throw new  DoesNotExistRecordException();
        }

        return (T) entity;
    }

    default void add(Object entity) throws WorkingWithDBException {
        try {
            this.executeAdd((T) entity);
        } catch (SQLException e) {
            throw new WorkingWithDBException();
        }
    }

    default void update(Object entity) throws WorkingWithDBException {
        try {
            this.executeUpdate((T) entity);
        } catch (SQLException e) {
            throw new WorkingWithDBException();
        }
    }

    default void delete(int id) throws WorkingWithDBException {
        try {
            this.executeDelete(id);
        } catch (SQLException e) {
            throw new WorkingWithDBException();
        }
    }
}
