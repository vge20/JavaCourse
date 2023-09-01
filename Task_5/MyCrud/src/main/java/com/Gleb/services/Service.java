package com.Gleb.services;

import com.Gleb.exceptions.WorkingWithDBException;

public interface Service<T> {

    T get(int id) throws WorkingWithDBException;

    void add(T entity) throws WorkingWithDBException;

    void update(T entity) throws WorkingWithDBException;

    void delete(int id) throws WorkingWithDBException;
}
