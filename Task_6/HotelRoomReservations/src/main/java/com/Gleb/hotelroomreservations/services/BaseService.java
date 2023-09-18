package com.Gleb.hotelroomreservations.services;

import com.Gleb.hotelroomreservations.exceptions.WorkingWithDBException;
import com.Gleb.hotelroomreservations.models.Room;

public interface BaseService<T> {

    T getByIdImpl(int id);

    default T getById(int id) throws WorkingWithDBException {
        T object;
        if ((object = this.getByIdImpl(id)) == null) { throw new WorkingWithDBException(); }
        return object;
    }

    void deleteByIdImpl(int id);

    default void deleteById(int id) throws WorkingWithDBException {
        try {
            this.deleteByIdImpl(id);
        } catch (Exception e) {
            throw new WorkingWithDBException();
        }
    }

    T saveObjectImpl(Object object);

    default void saveObject(T object) throws WorkingWithDBException {
        if (this.saveObjectImpl(object) == null) { throw new WorkingWithDBException(); }
    }
}
