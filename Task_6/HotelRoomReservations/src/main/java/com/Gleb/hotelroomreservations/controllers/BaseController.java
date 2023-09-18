package com.Gleb.hotelroomreservations.controllers;

import com.Gleb.hotelroomreservations.exceptions.WorkingWithDBException;
import com.Gleb.hotelroomreservations.services.BaseService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

public class BaseController<T> {

    protected ResponseEntity<Object> getObjectById(BaseService<T> service, int id) {
        Object object;
        try {
            object = service.getById(id);
        } catch (WorkingWithDBException e) {
            return new ResponseEntity<>(e.getJsonMessage(), HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(object, HttpStatus.OK);
    }

    protected ResponseEntity<Object> deleteObjectById(BaseService<T> service, int id) {
        try {
            service.deleteById(id);
        } catch (WorkingWithDBException e) {
            return new ResponseEntity<>(e.getJsonMessage(), HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(null, HttpStatus.OK);
    }

    protected ResponseEntity<Object> saveObject(BaseService<T> service, Object object) {
        try {
            service.saveObject((T) object);
        } catch (WorkingWithDBException e) {
            return new ResponseEntity<>(e.getJsonMessage(), HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity<>(null, HttpStatus.OK);
    }
}
