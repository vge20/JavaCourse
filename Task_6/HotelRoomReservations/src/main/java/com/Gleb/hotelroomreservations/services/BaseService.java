package com.Gleb.hotelroomreservations.services;

import com.Gleb.hotelroomreservations.exceptions.NotFoundException;

public interface BaseService<T> {

    T getByIdImpl(int id);

    default T getById(int id) throws NotFoundException {
        T object;
        try {
            if ((object = this.getByIdImpl(id)) == null) { throw new NotFoundException(); }
        } catch (Exception e) {
            throw new NotFoundException();
        }

        return object;
    }

    void deleteByIdImpl(int id);

    default void deleteById(int id) throws NotFoundException {
        try {
            this.deleteByIdImpl(id);
        } catch (Exception e) {
            throw new NotFoundException();
        }
    }

    T saveObjectImpl(Object object);

    default void saveObject(T object) throws NotFoundException {
        try {
            if (this.saveObjectImpl(object) == null) { throw new NotFoundException(); }
        } catch (Exception e) {
            throw new NotFoundException();
        }
    }
}
