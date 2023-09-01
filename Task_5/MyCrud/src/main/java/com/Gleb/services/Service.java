package com.Gleb.services;

import java.sql.SQLException;

public interface Service<T> {

    T get(int id) throws Exception;

    void add(T entity) throws SQLException;

    void update(T entity) throws SQLException;

    void delete(int id) throws SQLException;
}
