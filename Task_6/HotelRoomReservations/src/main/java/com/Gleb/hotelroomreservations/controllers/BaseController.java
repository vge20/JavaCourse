package com.Gleb.hotelroomreservations.controllers;

import com.Gleb.hotelroomreservations.exceptions.WorkingWithDBException;
import com.Gleb.hotelroomreservations.services.BaseService;

public class BaseController<T> {

    protected Object getObjectById(BaseService<T> service, int id) {
        Object object;
        try {
            object = service.getById(id);
        } catch (WorkingWithDBException e) {
            return e.getJsonMessage();
        }
        return object;
    }

    protected Object deleteObjectById(BaseService<T> service, int id) {
        Object object;
        try {
            service.deleteById(id);
        } catch (WorkingWithDBException e) {
            return e.getJsonMessage();
        }
        return null;
    }
}
