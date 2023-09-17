package com.Gleb.hotelroomreservations.services;

import com.Gleb.hotelroomreservations.exceptions.WorkingWithDBException;

public interface BaseService<T> {

    T getByIdImpl(int id);

    default T getById(int id) throws WorkingWithDBException {
        Object object;
        if ((object = this.getByIdImpl(id)) == null) { throw new WorkingWithDBException(); }
        return (T) object;
    }

    boolean deleteByIdImpl(int id);

    default void deleteById(int id) throws WorkingWithDBException {
        if (!this.deleteByIdImpl(id)) { throw new WorkingWithDBException(); }
    }
}
