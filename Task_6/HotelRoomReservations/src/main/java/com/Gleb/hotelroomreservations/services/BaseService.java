package com.Gleb.hotelroomreservations.services;

import com.Gleb.hotelroomreservations.exceptions.WorkingWithDBException;

public interface BaseService<T> {

    T getByIdImpl(int id);

    default T getById(int id) throws WorkingWithDBException {
        T object;
        if ((object = this.getByIdImpl(id)) == null) { throw new WorkingWithDBException(); }
        return object;
    }

    boolean deleteByIdImpl(int id);

    default void deleteById(int id) throws WorkingWithDBException {
        if (!this.deleteByIdImpl(id)) { throw new WorkingWithDBException(); }
    }

    T saveObjectImpl(Object object);

    default void addObject(T object) throws WorkingWithDBException {
        if (this.saveObjectImpl(object) == null) { throw new WorkingWithDBException(); }
    }

    default void updateObject(T object) throws WorkingWithDBException {
        if (this.saveObjectImpl(object) == null) { throw new WorkingWithDBException(); }
    }
}
