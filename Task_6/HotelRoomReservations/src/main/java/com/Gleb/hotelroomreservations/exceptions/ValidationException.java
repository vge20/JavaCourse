package com.Gleb.hotelroomreservations.exceptions;

public class ValidationException extends BaseException {

    private String template;

    public ValidationException() {
        template = "validationException";
    }

    @Override
    public String getTemplate() {
        return template;
    }
}
