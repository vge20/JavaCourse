package com.Gleb.hotelroomreservations.controllers;

import com.Gleb.hotelroomreservations.exceptions.BaseException;
import com.Gleb.hotelroomreservations.services.BaseService;
import com.Gleb.hotelroomreservations.validators.Validator;

public class BaseController<T> {

    protected String deleteObjectById(Validator validator, BaseService<T> service,
                                      int id, String nextTemplate) {
        try {
            validator.validateId(id);
            service.deleteById(id);
        } catch (BaseException e) {
            return e.getTemplate();
        }
        return nextTemplate;
    }

    protected String addObject(Validator validator, BaseService<T> service,
                               Object object, String nextTemplate) {
        try {
            validator.validateForAdd(object);
            service.saveObject((T) object);
        } catch (BaseException e) {
            return e.getTemplate();
        }
        return nextTemplate;
    }

    protected String updateObject(Validator validator, BaseService<T> service,
                               Object object, String nextTemplate) {
        try {
            validator.validateForUpdate(object);
            service.saveObject((T) object);
        } catch (BaseException e) {
            return e.getTemplate();
        }
        return nextTemplate;
    }
}
